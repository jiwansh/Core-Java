package fundamentals.EqualsHashcode;

//Scenario 3: Correct Implementation , Overriding Both

import java.util.HashSet;
import java.util.Objects;

class Employee {

    private int id;

    Employee(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Employee))
            return false;

        Employee emp = (Employee) obj;

        return this.id == emp.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

public class Scenario3 {

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
