# equals() and hashCode() in Java

## Overview

`equals()` and `hashCode()` are methods defined in the `Object` class. They are used to determine object equality and play a critical role in hash-based collections such as `HashMap`, `HashSet`, `Hashtable`, and `LinkedHashMap`.

Understanding their relationship is one of the most important Java interview topics.

---

## Default Behavior

Every Java class implicitly inherits `equals()` and `hashCode()` from `Object`.

### Default equals()

The default implementation compares memory addresses.

Two different objects containing the same data are considered different.

### Default hashCode()

The default implementation generates a hash value based on the object's identity in memory.

As a result, two different objects usually produce different hash codes even if their data is identical.

---

## Why Override equals()?

In real-world applications, objects are usually compared based on their data rather than their memory address.

Example:

Two Employee objects with:

* id = 101
* name = "John"

should generally be considered equal even if they are different objects in memory.

Overriding `equals()` allows defining what "logical equality" means for a class.

---

## Why Override hashCode()?

Hash-based collections use `hashCode()` to determine where an object should be stored internally.

The hash code determines the bucket location.

Objects that are logically equal should produce the same hash code so that collections can efficiently locate and compare them.

---

## HashSet / HashMap Internal Flow

When an object is inserted:

1. `hashCode()` is called.
2. Bucket location is determined.
3. Existing objects in that bucket are checked using `equals()`.
4. Duplicate detection occurs.

Flow:

```text
hashCode()
     ↓
Find Bucket
     ↓
equals()
     ↓
Store / Reject
```

Important:

`hashCode()` is always checked before `equals()`.

---

## Scenario 1: No Overriding

Behavior:

* equals() compares memory addresses.
* hashCode() is based on object identity.
* Objects with identical data are treated as different.

Result:

HashSet may store duplicate logical objects.

---

## Scenario 2: Override equals() Only

Behavior:

* Logical equality works correctly.
* Hash codes remain different.

Problem:

Hash-based collections may still treat equal objects as different because they are placed into different buckets.

Result:

Contract violation.

Collections behave incorrectly.

---

## Scenario 3: Override hashCode() Only

Behavior:

* Objects may end up in the same bucket.
* Logical equality still uses memory comparison.

Problem:

Objects that should be considered equal are still treated as different.

Result:

Incorrect duplicate detection.

---

## Scenario 4: Override Both equals() and hashCode()

Behavior:

* Logical equality works correctly.
* Equal objects generate the same hash code.
* Hash-based collections function correctly.

Result:

Correct behavior in HashMap and HashSet.

This is the recommended approach.

---

## equals() and hashCode() Contract

### Rule 1

If two objects are equal according to equals(),

their hash codes must be equal.

```text
equals() == true
        ↓
same hashCode()
```

---

### Rule 2

If two objects have the same hash code,

they are not necessarily equal.

```text
same hashCode()
        ↓
may or may not be equal
```

This situation is called a hash collision.

---

### Rule 3

If equals() is overridden,

hashCode() should also be overridden.

Failing to do so breaks hash-based collections.

---

## Hash Collision

A hash collision occurs when two different objects generate the same hash code.

This is completely valid.

Java handles collisions by using `equals()` for final comparison.

```text
same hashCode()
       ↓
equals()
       ↓
actual equality check
```

---

## Common Interview Questions

### Why do we override equals()?

To define logical equality based on object data instead of memory address.

### Why do we override hashCode()?

To ensure correct behavior in hash-based collections.

### Which method is called first in HashMap?

hashCode() is called first.

equals() is called only if necessary.

### Can two unequal objects have the same hash code?

Yes.

This is called a hash collision.

### Can two equal objects have different hash codes?

No.

This violates the equals-hashCode contract.

### Can we override equals() without hashCode()?

Yes, but it breaks hash-based collections.

### Can we override hashCode() without equals()?

Yes, but logical equality will not work correctly.

---

## Quick Revision

* equals() → Logical equality.
* hashCode() → Bucket location in hash-based collections.
* HashMap/HashSet use hashCode() first, then equals().
* Equal objects must have equal hash codes.
* Same hash code does not guarantee equality.
* Override equals() and hashCode() together.
* Hash collisions are valid and expected.
* Incorrect implementation leads to unexpected behavior in HashMap and HashSet.

## Interview One-Liner

Override `equals()` to define logical equality and override `hashCode()` to maintain the contract required by hash-based collections. Both methods should generally be overridden together.
