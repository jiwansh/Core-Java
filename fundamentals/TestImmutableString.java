package fundamentals;

public class TestImmutableString {
    public static void main(String[] args) {
        String s = "Java";              // s -> "Java" (immutable)
        String result = s.concat("Jiwanshu"); 
        // new object "JavaJiwanshu", s still -> "Java"

        System.out.println(s);          // prints "Java"
        System.out.println(result);     // prints "JavaJiwanshu"

        // 2. Reassignment vs modification
        String a = "Hello";
        String b = a;                // both point to same "Hello" in SCP
        a = a + " World";            // a now points to NEW object "Hello World"
        System.out.println("a: " + a);   // Hello World
        System.out.println("b: " + b);   // Hello
        // Shows: changing a does NOT affect b -> original object never changed

        /* Reasons for String Immutability
         * 1) Security: used in sensitive places (class names, file paths, DB URLs).
         * 2) String pool: many references can safely share same literal.
         * 3) Thread-safety: immutable objects are safe to share across threads.
         * 4) Stable hashCode: safe and efficient as keys in hash-based collections.
        */

        // mutability 
        /*
          StringBuffer is mutable and thread-safe:
          append() changes the same object, 
          and its methods are synchronized, 
          so it’s safe when multiple threads use the same instance
        */
        StringBuffer sb = new StringBuffer("String");
        sb.append("Buffer");
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder("String");
        sb1.append("Builder");
        System.out.println(sb1);

    }
    
}
