package fundamentals;

import java.util.Arrays;

/* which one is good to store password in Java? String or char[] & why?

Prefer char[] over String for passwords.

Why char[] is better:
1) Immutability vs mutability
    String is immutable: once created, its contents stay in memory until garbage collected. You cannot overwrite it.
    char[] is mutable: you can overwrite the array (e.g., fill with '\0') as soon as you’re done with the password, reducing the time it lives in memory.

2) String pool / memory:
    Many Strings (especially literals) can end up in the String Constant Pool, staying in memory longer than you expect.
    char[] is not pooled; when you overwrite and lose references, it’s effectively gone from your code’s reach.

3)Accidental leaks:
    Logging a String prints the actual password.
    Logging a char[] directly shows something like [C@1b6d3586, not the content (unless you explicitly convert it).
 */
public class StringVsCharArray {
     public static void main(String[] args) {
        // BAD: using String
        String pwdString = "MySecret123";

        // BETTER: using char[]
        char[] pwdChars = {'M','y','S','e','c','r','e','t','1','2','3'};

        // use pwdChars for auth, hashing, etc...

        // When done, wipe it
        Arrays.fill(pwdChars, '\0');  // overwrite characters in memory
       
    }
}
