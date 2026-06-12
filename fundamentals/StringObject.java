package fundamentals;

public class StringObject {
    public static void main(String[] args) {
        //how many obejcts created here
        String s1 = new String("JK");
        /*
         * Object 1: "JK" in String Constant Pool (created when class is loaded, if not already present)
         * Object 2: new String("JK") in the heap
         */
        String s2 = "JK"; // no new object creation
        
        // intern() returns the pooled instance of this string
        System.out.println(s1.intern()); // prints "JK" (from SCP)

        // hashCode equality just means same content, not same object
        System.out.println(s1.intern().hashCode() == s2.hashCode()); // true

        // different behavior examples :
        System.out.println(s1 == s2);          // false (heap vs pool)
        System.out.println(s1.equals(s2));     // true (same characters)
        System.out.println(s1.intern() == s2); // true (both from SCP)

    }
}
