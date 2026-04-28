# 🏦 BankSimulator

A simple Java-based bank simulation project that allows bank officers to manage customer accounts, including account creation, deposits, withdrawals, and transaction logging.

---

## ✨ Features

- 👤 **Account Creation** with details like name, gender, DOB, address, phone, Aadhaar, PAN, and account type.
- 💰 **Deposit and Withdraw** functionality.
- 🔍 **View Account Details** by account number.
- 📜 **Transaction Logging** to a file with timestamps.
- 💾 **Persistent Data Storage** using file I/O.
- 🛡️ **Officer Login Menu** for secured interactions.

---

## 🧠 Concepts and Logics Used

### 🔧 Core Java Concepts
- **OOP (Object-Oriented Programming)**  
  Classes like `Account`, `Utils`, and `BankOfficer` demonstrate encapsulation and object interactions.

- **File I/O (java.io)**  
  Data for accounts, transactions, and officers are stored and read using text files like:
  - `data/accounts.txt`
  - `data/officers.txt`
  - `data/transactions.txt`

- **Exception Handling**  
  Proper use of try-with-resources and exception messages for file operations.

- **Collections (List, ArrayList)**  
  To store and retrieve multiple account objects from file data.

- **String Formatting & Parsing**  
  Splitting and converting file data into structured `Account` objects.

- **Scanner for Console Input**  
  Menu-driven input from the user via `Scanner`.

### 📁 Directory Structure

BankSimulator/
├── data/
│ ├── accounts.txt
│ ├── officers.txt
│ └── transactions.txt
├── Account.java
├── Utils.java
├── BankOfficer.java
└── README.md

---

## 🚀 Getting Started

### ✅ Requirements
- Java JDK 8 or higher
- A terminal or IDE (VS Code, IntelliJ, etc.)

### ▶️ How to Run

```bash
# Compile the Java files
javac *.java

# Run the main class (Example: start with BankOfficer)
java BankOfficer
mkdir data
touch data/accounts.txt data/officers.txt data/transactions.txt

📃 License
This project is open source and free to use under the MIT License.

---

Let me know if you'd like me to include usage screenshots, test cases, or GitHub badges!
