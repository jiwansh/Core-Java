package Exception.Exception_Hierarchy;

/*
 * Exception Rules in Method Overriding
 *
 * Child can:
 * Throw same checked exception
 * Throw smaller checked exception
 * Throw no checked exception
 *
 * Child cannot:
 * ❌ Throw broader checked exception
 *
 * RuntimeException:
 * ✅ Always allowed
 */

import java.io.*;

class Parent {

    void method1() throws Exception {
    }

    void method2() throws IOException {
    }

    void method3() {
    }
}