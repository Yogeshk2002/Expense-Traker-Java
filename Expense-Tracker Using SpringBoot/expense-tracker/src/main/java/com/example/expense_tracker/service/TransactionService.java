package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Transaction;
import com.example.expense_tracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public void saveTransaction(Transaction transaction) {
        repository.save(transaction);
    }

    public List<Transaction> getMonthlySummary(int year, int month) {
        return repository.findAll().stream()
                .filter(t -> t.getDate().getYear() == year && t.getDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }
}
