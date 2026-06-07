package fundamentals.finalFinallyFinalize;

class Parent {

    final void show() {
        System.out.println("Final Method");
    }
}

/*
class Child extends Parent {

    @Override
    void show() { } // Compilation Error
}
*/

final class Vehicle {

    void start() {
        System.out.println("Vehicle Started");
    }
}

/*
class Car extends Vehicle { } // Compilation Error
*/

public class Demo {

    private final int a = 10;

    public void m1() {

        // a = 20; // Compilation Error

        try {

            System.out.println("Try Block");

        } finally {

            System.out.println("Finally Block");
        }
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("Finalize Called");
    }

    public static void main(String[] args) {

        Demo demo = new Demo();

        // final variable
        System.out.println("Final Variable = " + demo.a);

        // finally block
        demo.m1();

        // final method
        Parent parent = new Parent();
        parent.show();

        // final class
        Vehicle vehicle = new Vehicle();
        vehicle.start();

        // finalize()
        demo = null;
        System.gc();
    }
}