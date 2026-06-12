package Exception;

public class tryCatch {
    /*
    1) Normal case, no returns:
    no exception: try → finally
    with exception: try (partial) → catch → finally
     */
    public static void noReturn(){
        try {
        System.out.println("I am in try block");
        System.out.println(10/0);
    }
    catch(Exception e) {
        System.out.println("I am catch block, I run if an exception happens in try");
    }
    finally {
        System.out.println("I am finally block, I run at the end (almost always)");
    }

   }
   /*
   2) Case with returns:
     return in try → finally runs → then returns that value.
     return in catch → finally runs → then returns that value.
     return in finally → overrides any previous return or thrown exception
    */
    public static int returnInTry() {
    try {
        System.out.println("try");
        return 1;
    } catch(Exception e) {
        System.out.println("catch");
        return 2;
    } finally {
        System.out.println("finally");
    }
} 
public static int returnInCatch() {
    try {
        System.out.println("try");
        System.out.println(10/0);
        return 1; // never reached
    } catch(Exception e) {
        System.out.println("catch");
        return 2;
    } finally {
        System.out.println("finally");
    }
}
public static int returnInFinally() {
    try {
        System.out.println("try");
        return 1;
    } catch(Exception e) {
        System.out.println("catch");
        return 2;
    } finally {
        System.out.println("finally");
        return 3;
    }
}
/*
finally may not run only if:
    JVM exits (e.g., System.exit(0)), or
    JVM crashes, or infinite loop before finally
 */

    public static void main(String[] args) {
       // noReturn();
       // System.out.println(returnInTry());
       //System.out.println(returnInCatch());
       System.out.println(returnInFinally());
    }
}
