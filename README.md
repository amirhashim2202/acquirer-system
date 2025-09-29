# Payment System & Acquirer System

This project demonstrates a simple end-to-end payment workflow with a **Payment System** (merchant-facing) and an **Acquirer System** (simulated acquirer/bank).

## 🏦 System Overview

- **Payment System** – Handles customer interactions (dashboard, payment window, refund requests) and communicates with the Acquirer System.
- **Acquirer System** – Simulates the acquiring bank. Processes Sale/Refund requests and returns approval/decline responses.

## 📊 Workflow Summary

### 🔑 Dashboard
1. Access the login page: `http://localhost:8080`
   - **Username:** `user`
   - **Password:** `password`
2. Successful login redirects to the **Dashboard**.

### 💳 Sale Transaction
1. Open Payment Window: `http://localhost:8080/api/payment`
2. Fill in:
   - Card Number
   - CVC
   - Currency
   - Amount (**Note:** if amount cents = `99`, transaction fails)
3. Payment System sends **Sale Request** to Acquirer System.
4. Acquirer System responds (Approve/Decline).
5. Payment System displays **Success/Failure message** to the user.

### 💸 Refund Transaction
1. Send Refund Request using an API platform (e.g., Postman): `http://localhost:8080/api/refund`
2. Provide:
   - Payment Reference
   - Amount (**Note:** if amount cents = `99`, transaction fails)
3. Payment System sends **Refund Request** to Acquirer System.
4. Acquirer System responds (Approve/Decline).
5. Payment System displays **Success/Failure message**.

## 🛠 Tech Stack
- **Backend:** Spring Boot (Java)
- **Frontend:** Thymeleaf (for dashboard & payment window)
- **Database:** (Name:TESTDB, Driver:PostgreSQL)
- **API Testing:** Postman (for Refund API)
