🚀 Key Rules for Exceptions in Method Overriding
1️⃣ Parent class method may or may not throw exceptions.
2️⃣ Child class method must follow these rules:

It cannot throw a broader checked exception than the parent.
It can throw the same checked exception as the parent.
It can throw a subclass of the parent's checked exception.
It can throw unchecked (runtime) exceptions freely.
If the parent method does not throw an exception, the child cannot throw a new checked exception but can throw unchecked exceptions.
====================================================================================================================================================

  ===========
  Exception Handling in Polymorphism (Zero to Hero) 🚀
Polymorphism in Java works with exception handling, but there are some rules and restrictions when overloading and overriding methods with exceptions. Let's explore how exceptions behave in polymorphism with real-world examples.

1️⃣ Exception Handling in Method Overloading
🔹 In method overloading, exceptions work independently for each overloaded method.
🔹 Each overloaded method can throw different types of exceptions.

✅ Example: Overloading Methods with Exceptions
java
Copy
Edit
class OverloadingException {
    // Method without exception
    void process(int a) {
        System.out.println("Processing integer: " + a);
    }

    // Overloaded method that throws ArithmeticException
    void process(double a) throws ArithmeticException {
        if (a == 0) {
            throw new ArithmeticException("Division by zero not allowed");
        }
        System.out.println("Processing double: " + a);
    }
}

public class ExceptionOverloadingDemo {
    public static void main(String[] args) {
        OverloadingException obj = new OverloadingException();

        obj.process(10); // No exception

        try {
            obj.process(0.0); // Throws ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
✔️ Key Takeaways:
✅ Each overloaded method handles exceptions independently.
✅ One method may throw an exception, while another may not.

2️⃣ Exception Handling in Method Overriding
🔹 In method overriding, the child class method cannot throw a broader or new checked exception than the parent method.
🔹 However, the child method can throw:

Same exception
Subclass of the parent’s exception
Fewer or no exceptions
✅ Example: Overriding with Exception Handling
java
Copy
Edit
class Parent {
    void show() throws IOException { // Parent method throws IOException
        System.out.println("Parent: Show method");
    }
}

class Child extends Parent {
    @Override
    void show() throws FileNotFoundException { // Allowed: Subclass of IOException
        System.out.println("Child: Show method");
    }
}

public class ExceptionOverridingDemo {
    public static void main(String[] args) {
        Parent obj = new Child();
        try {
            obj.show(); // Calls Child's method
        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
✔️ Key Takeaways:
✅ Child can throw the same exception as the parent.
✅ Child can throw a subclass exception (FileNotFoundException ⬇ is a subclass of IOException).
✅ Child cannot throw a new or broader checked exception (e.g., Exception instead of IOException).

3️⃣ Rules for Exceptions in Overriding
🔹 Checked Exception Rules:

Parent throws Checked Exception → Child must throw the same or a subclass.
Parent does not throw any Checked Exception → Child cannot throw a new Checked Exception.
🔹 Unchecked Exception Rules:

No restriction on unchecked exceptions (e.g., RuntimeException, NullPointerException).
🚫 Invalid Example (Throws Broader Exception)
java
Copy
Edit
class Parent {
    void display() throws IOException {} // Parent method throws IOException
}

class Child extends Parent {
    @Override
    void display() throws Exception { // ❌ Not Allowed: Exception is broader
    }
}
❌ Compile-time error: Child cannot throw a broader checked exception (Exception) than the parent (IOException).

4️⃣ Real-World Example: Bank Transactions
Imagine a banking system where a base Bank class defines a withdraw() method. Different banks override this method with specific exception handling.

✅ Example: Real-World Banking Scenario
java
Copy
Edit
class Bank {
    void withdraw(double amount) throws Exception {
        if (amount > 50000) {
            throw new Exception("Limit exceeded. Cannot withdraw more than $50,000.");
        }
        System.out.println("Withdrawal successful: $" + amount);
    }
}

class SBI extends Bank {
    @Override
    void withdraw(double amount) throws RuntimeException { // Allowed: Unchecked exception
        if (amount > 100000) {
            throw new RuntimeException("SBI Limit exceeded: Cannot withdraw more than $100,000.");
        }
        System.out.println("SBI Withdrawal successful: $" + amount);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new SBI();

        try {
            bank.withdraw(120000); // Throws RuntimeException
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
✔️ Key Takeaways:
✅ SBI class overrides the withdraw method with its own exception.
✅ Unchecked exceptions have no restrictions in method overriding.
✅ The base class allows general withdrawal, but SBI has a stricter limit.

5️⃣ Summary: Exception in Polymorphism
Feature	Method Overloading	Method Overriding
Exception Behavior	Each method handles exceptions independently	Child method must follow rules of parent method
Checked Exception Rules	No restriction	Child cannot throw broader checked exception
Unchecked Exception Rules	No restriction	No restriction
Compile-time Error?	No	Yes, if child throws a broader checked exception
🚀 Conclusion
✔️ Polymorphism & Exception Handling are important in real-world applications.
✔️ Method Overloading → Different methods handle exceptions independently.
✔️ Method Overriding → Child class must follow exception rules.
✔️ Unchecked Exceptions (like NullPointerException) have no restrictions.
✔️ Real-world example: Banking transactions handling different withdrawal limits.
