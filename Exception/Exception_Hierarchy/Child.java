package Exception.Exception_Hierarchy;

import java.io.FileNotFoundException;

class Child extends Parent {

    // Same checked exception
    @Override
    void method1() throws Exception {
    }

    // Narrower checked exception
    @Override
    void method2() throws FileNotFoundException {
    }

    // Runtime exception allowed
    @Override
    void method3() throws RuntimeException {
    }

    public static void main(String[] args) {

        Parent p = new Child();

        System.out.println(
            "Exception Overriding Rules Demo"
        );
    }
}

/*
 * ❌ INVALID
 *
 * class Child extends Parent {
 *
 *     @Override
 *     void method2() throws Exception {
 *     }
 * }
 *
 * Reason:
 * Parent allows IOException.
 * Child cannot widen it to Exception.
 */