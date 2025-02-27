 Notes on Abstract Classes & Interfaces in Java
1️⃣ Abstract Class vs Interface Overview
Feature	Abstract Class	Interface
Inheritance Type	Can extend only one abstract class	Can implement multiple interfaces
Method Type	Can have abstract & concrete methods	Only abstract methods (before Java 8)
Default Methods	❌ Not allowed (except static methods)	✅ Allowed (Java 8+)
Fields (Variables)	Can have instance variables	Only constants (public, static, final)
Constructors	✅ Can have constructors	❌ No constructors
Access Modifiers	Any (private, protected, public)	Methods are public by default
2️⃣ Abstract Class in Java
✅ What is an Abstract Class?
An abstract class is a class that cannot be instantiated (you cannot create an object of it). It is used as a blueprint for other classes.

✅ When to Use Abstract Classes?
✔️ When you have common behavior for multiple classes.
✔️ When you want to define some default methods (not all abstract).

🔹 Example of an Abstract Class
java
Copy
Edit
// Abstract class
abstract class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Abstract method (must be implemented by subclasses)
    abstract void makeSound();

    // Concrete method (can be used directly)
    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Concrete class extending abstract class
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    // Implementing abstract method
    @Override
    void makeSound() {
        System.out.println(name + " barks");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy");
        d.makeSound(); // Output: Buddy barks
        d.sleep();     // Output: Buddy is sleeping
    }
}
✅ Key Points:
✔️ The Animal class has both abstract (makeSound()) and concrete (sleep()) methods.
✔️ The Dog class must implement makeSound().
✔️ Objects of an abstract class cannot be created (Animal a = new Animal(); ❌).

