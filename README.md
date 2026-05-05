# Java_Training

A collection of Java training exercises and demos covering various algorithms, data structures, design patterns, and concurrency concepts.

## Demos

### Algorithms
- **algorithms.Demo**: Interactive console application for sorting unsorted integer array lists. Allows users to input the number of arrays and their elements, then sorts them.

### Object Comparison
- **object_comparison.Demo**: Demonstrates object hash codes and comparison. Shows the difference between `System.identityHashCode()` and `hashCode()` for various objects.

### Polymorphism
- **polymorphism.Demo**: Illustrates polymorphism in Java using Person and Employee classes. Shows how objects of different types can be referenced by a common superclass.

### Dependency Injection
- **dependency_injection.Demo**: Implements the dependency injection pattern with payment services. Demonstrates injecting different payment methods (Cash, Visa, Paypal) into a consumer.

### Multithreaded Server
- **multithreaded_server.Demo**: Starts a simple HTTP server on a user-specified port. Waits for client requests and handles them in a multithreaded manner.

### Multithreading
- **multithreading.Terminal**: Multithreaded terminal application. Runs a separate thread for handling user input, allowing concurrent processing.

### Synchronization (Object Level)
- **synchronization.object_level.unsynchronized.Demo**: Demonstrates unsynchronized access to shared resources, potentially leading to race conditions.
- **synchronization.object_level.synchronized_lock.Demo**: Shows synchronization using explicit locks at the object level to prevent race conditions.
- **synchronization.object_level.synchronized_obj.Demo**: Illustrates synchronization on an object instance.
- **synchronization.object_level.synchronized_method.Demo**: Demonstrates synchronized methods at the object level.
- **synchronization.object_level.synchronized_obj2.Demo**: Another example of object-level synchronization.

### Synchronization (Class Level)
- **synchronization.class_level.unsynchronized.Demo**: Shows unsynchronized class-level operations.
- **synchronization.class_level.synchronized_class.Demo**: Demonstrates synchronization at the class level using static synchronized methods.
- **synchronization.class_level.synchronized_lock.Demo**: Illustrates class-level synchronization using locks.
- **synchronization.class_level.synchronized_method.Demo**: Shows synchronized static methods for class-level synchronization.

## How to Run

1. Compile the project using the "Compile Java" task in VS Code or run:
   ```bash
   find src -name '*.java' | xargs javac --release 21 -d bin
   ```

2. Run any demo using the launch configurations in VS Code or:
   ```bash
   java -cp bin <package.Demo>
   ```

## Requirements

- Java 21 or later
- VS Code with Java extensions (recommended)
