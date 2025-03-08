# Java Memory Model Overview

## 1. Java Memory Model Overview:
- The **Java Virtual Machine (JVM)** is where Java code runs.
- **JVM** has two main parts:
  - **Heap Memory**: This is shared memory used by all threads to store objects (like `object1`, `object2`).
  - **Thread Stacks**: Each thread gets its own stack, which stores **local variables** used by that thread.

---

## 2. Thread-Specific Variables:
- Every thread in Java has its **own stack**.
- **Local variables** (like `runnable1`, `runnable2`) are stored in the thread's stack, meaning one thread’s local variables are **not shared** with other threads.
  
  **Example**:
  - If **Thread 1** creates a variable `runnable1`, it will only be accessible inside **Thread 1**.
  - Similarly, **Thread 2** can create its own variable `runnable2`, and it won’t interfere with **Thread 1**.


  ## 2. Thread-Specific Variables:
- Every thread in Java has its **own stack**.
- **Local variables** (like `runnable1`, `runnable2`) are stored in the thread's stack, meaning one thread’s local variables are **not shared** with other threads.
  
  **Example**:
  ```java
  Runnable runnable1 = new Runnable() {
      public void run() {
          int localVariable = 10;  // local to this thread
          System.out.println(localVariable);
      }
  };
If Thread 1 creates a variable runnable1, it will only be accessible inside Thread 1.
Similarly, Thread 2 can create its own variable runnable2, and it won’t interfere with Thread 1.


## 3. Shared Objects:
Objects (like object1, object2) are stored in Heap Memory.

All threads can have a reference to the same object, meaning they can share the same object in the heap.

Example:

```java

class SharedObject {
    int value;
}

SharedObject object1 = new SharedObject();
object1.value = 10;

### If both Thread 1 and Thread 2 use object1, they will both refer to the same object in memory (the Heap).
4. Problems with Shared Objects:
Visibility Problem: When one thread changes the value of a shared object, other threads might not immediately see that updated value.

Example:

java
Copy
// Thread 1 updates object1
object1.value = 20; // but this might not be visible to Thread 2 immediately

// Thread 2 reads object1
System.out.println(object1.value);  // might still print the old value if Thread 1's update is in cache
This issue can cause confusion or incorrect behavior if the threads aren't synchronized properly.

5. How CPUs Work with Threads:
Modern systems may have multiple CPUs (for example, CPU 1 and CPU 2).

Each CPU has its own cache and registers, which help the CPU process data faster.

Steps:

Data related to a thread is first stored in main memory.
The CPU copies this data to its cache and then to its registers for fast processing.
After processing, the data is updated back to main memory.
If multiple CPUs are involved, synchronization issues can occur when threads on different CPUs are trying to access shared data at the same time.

6. Registers and Caching:
CPU Registers are fast storage inside the CPU that helps with processing.

Cache is used to store frequently accessed data, which speeds up access times.

Example:

Caches and Registers help CPUs work quickly but can sometimes cause problems if the data isn’t updated correctly in main memory.
7. Visibility Problem:
This happens when one thread’s changes to an object (like object1) don’t immediately become visible to other threads.

Example:

java
Copy
// Thread 1 makes changes to object1
object1.value = 100;  // but stores it in cache

// Thread 2 is on another CPU and reads object1 from main memory
System.out.println(object1.value);  // might see the old value, not the updated one

8. How to Fix the Visibility Problem:
To make sure changes to shared objects are visible across all threads, you can use synchronization mechanisms.
Use the volatile keyword or synchronized blocks to ensure the changes are immediately visible to other threads.
Example (Using volatile):
java
Copy
private volatile int sharedVariable;

public void updateSharedVariable() {
    sharedVariable = 100;  // This change is visible to all threads immediately
}