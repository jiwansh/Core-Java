package fundamentals.EqualsHashcode;

//Scenario 2: Override equals() Only

import java.util.HashSet;

class Employee {

    private int id;

    Employee(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        Employee emp = (Employee) obj;

        return this.id == emp.id;
    }
}

public class Scenario2 {

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
