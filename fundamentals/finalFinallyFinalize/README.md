# final vs finally vs finalize()

## Overview

Although `final`, `finally`, and `finalize()` sound similar, they serve completely different purposes in Java.

* `final` → Keyword used to restrict modification.
* `finally` → Block used in exception handling.
* `finalize()` → Method historically used during garbage collection.

---

## final

The `final` keyword is used to prevent modification.

### Final Variable

A final variable can be assigned only once.

**Use Cases**

* Constants
* Immutable objects

### Final Method

A final method cannot be overridden by a child class.

**Use Cases**

* Prevent altering critical business logic.
* Security-sensitive methods.

### Final Class

A final class cannot be inherited.

**Use Cases**

* Immutable classes.
* Restricting inheritance.

**Example:** `String` class is final.

---

## finally

The `finally` block is associated with exception handling.

It executes after the `try` block regardless of whether an exception occurs or not.

### Common Uses

* Closing files
* Closing database connections
* Releasing resources
* Cleanup operations

### Important Point

The `finally` block executes in almost all cases.

Exceptions include:

* `System.exit()`
* JVM crash
* Forceful process termination

---

## finalize()

`finalize()` is a method of the `Object` class.

Historically, it was invoked by the Garbage Collector before reclaiming an object's memory.

### Important Points

* Execution is not guaranteed.
* JVM decides when garbage collection happens.
* Not suitable for resource cleanup.
* Deprecated since Java 9.

### Modern Alternatives

* try-with-resources
* AutoCloseable
* Explicit cleanup methods

---

## Comparison

| Feature             | final                       | finally                 | finalize()         |
| ------------------- | --------------------------- | ----------------------- | ------------------ |
| Type                | Keyword                     | Block                   | Method             |
| Purpose             | Restrict modification       | Cleanup after try/catch | Cleanup before GC  |
| Used With           | Variables, Methods, Classes | Exception Handling      | Garbage Collection |
| Inheritance Related | Yes                         | No                      | No                 |
| Commonly Used Today | Yes                         | Yes                     | No (Deprecated)    |

---

## Interview Questions

### Can a final variable be modified?

No.

### Can a final method be overridden?

No.

### Can a final class be inherited?

No.

### Does finally always execute?

Almost always. Exceptions include `System.exit()` and JVM termination.

### Is finalize() guaranteed to execute?

No.

### Is finalize() used in modern Java applications?

No. It is deprecated and should be avoided.

---

## Quick Revision

* final → Cannot modify.
* final variable → Cannot reassign.
* final method → Cannot override.
* final class → Cannot inherit.
* finally → Cleanup block, executes after try/catch.
* finalize() → GC-related method, deprecated, execution not guaranteed.
