# 💸 Expense Tracker Application - Spring Boot

This is a full-featured **Expense Tracker** application built using **Spring Boot** that allows users to **track income and expenses**, **view monthly summaries**, and **upload transactions using CSV files**.

---

## 🖥️ Full Dashboard View

The main screen of the application includes the following core functionalities:

- ✅ **Add Transaction** – Add income or expense with details like type, category, amount, and date.
- 📊 **Monthly Summary** – View your financial transactions for a selected month and year in a table format.
- 📁 **Upload CSV** – Upload a `.csv` file containing multiple transactions at once.

> 📸 **Screenshot 1**: Full-screen view showing all three major features in a single interface.
> ![image_alt](https://github.com/Yogeshk2002/Expense-Traker-Java/blob/8a1f69e834f3e1ad72c166b2d70878d2021080b0/Screenshot%202025-05-23%20232213.png)

---

## ➕ Add Transaction

Use the **Add Transaction** section to manually input a transaction.

### Fields:
- **Type**: Choose between `Income` or `Expense`.
- **Category**: Select from predefined categories such as `Salary`, `Food`, `Bills`, etc.
- **Amount**: Enter the transaction amount (e.g., `50000`).
- **Date**: Pick the transaction date (e.g., `01/05/2025`).
- **Add Button**: Click to save the transaction.

> 📸 **Screenshot 2**: Demonstrates adding an income transaction with:
> - Type: Income  
> - Category: Salary  
> - Amount: 50000  
> - Date: 01/05/2025
> - ![image_url](https://github.com/Yogeshk2002/Expense-Traker-Java/blob/34ed22e564ae48d8e6738c92743dae3e49d90864/Screenshot%202025-05-23%20232333.png)

---

## 📆 Monthly Summary

This section allows you to **view a summary of all transactions** for a particular month and year.

### Steps:
1. **Select Year** – Choose the desired year.
2. **Select Month** – Choose the desired month.
3. **Click View Summary** – Displays all matching transactions in a tabular format.

The summary helps track all income and expenses to manage budgets effectively.

> 📸 **Screenshot 3**: Shows the summary results for the selected month and year.

---

## 📤 Upload Transactions via CSV

You can bulk upload transactions using a `.csv` file in the **Upload Transactions** section.

### Steps:
1. Click on **Choose File** to select a valid CSV file.
2. Click **Upload** to submit.
3. Navigate to **Monthly Summary**, select the relevant month and year, and click **View Summary** to verify the uploaded transactions.

### CSV Format Requirements:
| Type   | Category | Amount | Date       |
|--------|----------|--------|------------|
| Income | Salary   | 50000  | 2025-05-01 |

> 📸 **Screenshot 4**: Shows the upload interface with file selection and upload button.
> 📸 **Screenshot 5**: Displays the result after uploading and viewing summary.

---



