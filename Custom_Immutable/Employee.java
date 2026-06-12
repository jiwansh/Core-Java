package Custom_Immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 *Core principles of an immutable class
   1) Make the class final.
      So it cannot be subclassed and modified behavior can’t be added via inheritance.

   2)Make all fields private and final
     So they are set once (in constructor) and never reassigned.

   3) No setters
     Only getters, and getters must not expose mutable internals.

   4) Defensive copies for mutable fields

     In the constructor: copy incoming mutable objects instead of storing the references directly.

     In getters: return copies, not the original mutable objects.

   5) Ensure this(keyword) does not “leak” during construction
      Don’t pass this out of the constructor before it’s fully built.
 */

// 1) Class is final -> no subclass can break immutability
public final class Employee {

    // 2) All fields are private and final
    private final String name;
    private final Date doj;          // mutable type
    private final List<String> mobile; // mutable
    private final Address address;   // mutable custom type

    // 3) Constructor makes defensive copies of mutable fields->
    // as list , mutable claases have references, so intialize as copy of current object, because
    // maybe later changed
    public Employee(String name, Date doj, List<String> mobile, Address address) {
        this.name = name;
        // defensive copy of Date
        this.doj = new Date(doj.getTime());
        // defensive copy of List
        this.mobile = new ArrayList<>(mobile);
        // defensive copy of Address (custom mutable class)
        this.address = new Address(address.getCity(), address.getZip());
    }

    // 4) No setters

    public String getName() {
        return name; // String is already immutable
    }

    // return a copy, not internal Date
    public Date getDoj() {
        return new Date(doj.getTime());
    }

    // return a copy, not internal List
    public List<String> getMobile() {
        // optionally wrap as unmodifiable if you want caller to see that it’s read-only
        // or can use clone() too but its tricky
        return new ArrayList<>(mobile);
        // or: return Collections.unmodifiableList(new ArrayList<>(mobile));
    }

    // return a copy of Address, not the internal one
    public Address getAddress() {
        return new Address(address.getCity(), address.getZip());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", doj=" + doj +
                ", mobile=" + mobile +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        Address address = new Address("blr", "1012");
        Date doj = new Date();
        List<String> mobiles = new ArrayList<>();
        mobiles.add("1234");
        mobiles.add("5678");

        Employee employee = new Employee("Basant", doj, mobiles, address);

        // Try to mutate via original arguments
        doj.setDate(20);
        mobiles.add("9010");
        address.setCity("Pune");

        // Try to mutate via getters
        employee.getDoj().setDate(25);
        employee.getMobile().add("9999");
        employee.getAddress().setCity("Delhi");

        // Proof: Employee's internal state did not change
        System.out.println(employee);
    }
}
