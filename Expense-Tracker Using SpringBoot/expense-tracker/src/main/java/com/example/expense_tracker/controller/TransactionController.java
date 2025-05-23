package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Transaction;
import com.example.expense_tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/")
    public String index(@RequestParam(required = false) Integer year,
                        @RequestParam(required = false) Integer month,
                        Model model) {
        if (year != null && month != null) {
            List<Transaction> summary = service.getMonthlySummary(year, month);
            model.addAttribute("summary", summary);
        }
        return "index";
    }

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute Transaction transaction) {
        service.saveTransaction(transaction);
        return "redirect:/";
    }

    @PostMapping("/upload-csv")
    public String uploadCSV(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a CSV file to upload.");
            return "redirect:/";
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean firstLine = true;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // skip header
                }

                String[] fields = line.split(",");

                if (fields.length >= 4) {
                    // Clean up quotes and whitespace
                    String type = fields[0].replaceAll("\"", "").trim();
                    String category = fields[1].replaceAll("\"", "").trim();
                    String amountStr = fields[2].replaceAll("\"", "").trim();
                    String dateStr = fields[3].replaceAll("\"", "").trim();

                    Transaction transaction = new Transaction();
                    transaction.setType(type);
                    transaction.setCategory(category);
                    transaction.setAmount(Double.parseDouble(amountStr));
                    transaction.setDate(LocalDate.parse(dateStr, formatter));
                    service.saveTransaction(transaction);
                }
            }

            redirectAttributes.addFlashAttribute("message", "CSV file uploaded successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error processing CSV file: " + e.getMessage());
        }

        return "redirect:/";
    }


}
