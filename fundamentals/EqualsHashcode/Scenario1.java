package fundamentals.EqualsHashcode;

//Scenario 1: Without Overriding equals() and hashCode()

import java.util.HashSet;

class Employee {

    private int id;

    Employee(int id) {
        this.id = id;
    }
}

public class Scenario1 {

    public static void main(String[] args) {

        Employee e1 = new Employee(101);
        Employee e2 = new Employee(101);

        System.out.println(e1.equals(e2));

        HashSet<Employee> set = new HashSet<>();

        set.add(e1);
        set.add(e2);

        System.out.println(set.size());
    }
}
