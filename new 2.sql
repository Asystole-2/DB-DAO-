CREATE DATABASE FinanceTracker;
USE FinanceTracker;

CREATE TABLE Expenses (
    expenseID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL,
    dateIncurred DATE NOT NULL
);

CREATE TABLE Income (
    incomeID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    dateEarned DATE NOT NULL
);

-- Sample Data Insertion
INSERT INTO Expenses (title, category, amount, dateIncurred) VALUES
('weekly shop', 'groceries', 47.50, '2025-01-07'),
('gym membership', 'fitness', 30.00, '2025-01-09'),
('electricity bill', 'utilities', 60.75, '2025-01-10'),
('coffee', 'entertainment', 5.00, '2025-01-12'),
('bus pass', 'transportation', 25.00, '2025-01-15');

INSERT INTO Income (title, amount, dateEarned) VALUES
('babysitting', 60.00, '2025-01-05'),
('Bar work', 100.00, '2025-01-07'),
('freelance design', 200.00, '2025-01-08'),
('gift', 50.00, '2025-01-10'),
('tutoring', 75.00, '2025-01-12');
