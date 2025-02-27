📌 Real-Life Example of Static and Default Methods in Java 🚀
✅ Real-Life Example of Default Methods: "Payment System"
Scenario:
Suppose we have a Payment interface used by multiple payment providers (CreditCard, PayPal, UPI, etc.). Now, a new fraud detection feature needs to be added to all payment methods without modifying existing classes.

🔹 Solution: Use a default method in the Payment interface for fraud detection.

🔹 Implementation:
java
Copy
Edit
interface Payment {
    void processPayment(double amount);

    // New default method for fraud detection
    default void fraudCheck() {
        System.out.println("Performing fraud check...");
    }
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Payment cc = new CreditCardPayment();
        cc.processPayment(100.0);
        cc.fraudCheck(); // Uses the default method

        Payment paypal = new PayPalPayment();
        paypal.processPayment(200.0);
        paypal.fraudCheck(); // Uses the default method
    }
}
🔹 Output:
nginx
Copy
Edit
Processing credit card payment of $100.0
Performing fraud check...
Processing PayPal payment of $200.0
Performing fraud check...
✔️ Benefit: Fraud detection was added without modifying existing classes, ensuring backward compatibility.

✅ Real-Life Example of Static Methods: "Utility Methods for Loan Processing"
Scenario:
Banks offer loans, and we need to calculate interest for different types of loans (Home Loan, Car Loan, Personal Loan, etc.). Instead of adding this logic to every class, we define a static method in the LoanCalculator interface.

🔹 Solution: Use a static method in the LoanCalculator interface for interest calculation.

🔹 Implementation:
java
Copy
Edit
interface LoanCalculator {
    static double calculateInterest(double amount, double rate, int years) {
        return amount * rate * years / 100;
    }
}

public class LoanProcessing {
    public static void main(String[] args) {
        // Calling static method without creating an object
        double interest = LoanCalculator.calculateInterest(10000, 5, 3);
        System.out.println("Total Interest: $" + interest);
    }
}
🔹 Output:
nginx
Copy
Edit
Total Interest: $1500.0
✔️ Benefit: The calculateInterest() method is reusable without needing an object, avoiding duplicate logic across different loan types.

📌 Summary
Method Type	Real-Life Use Case	Key Benefit
Default Method	Adding fraud detection to all payment methods	Backward compatibility without modifying existing code
Static Method	Loan interest calculation utility	No need for an instance, reusable helper function
Would you like more examples or an explanation of any part? 😊🚀
