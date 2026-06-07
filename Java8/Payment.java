package Java8;

/*
 * Java 8 Interface Features
 *
 * 1. Abstract Method
 *    Must be implemented.
 *
 * 2. Default Method
 *    Has implementation.
 *    Child class may override it.
 *
 * 3. Static Method
 *    Belongs to interface.
 *    Called using InterfaceName.method().
 */

public interface Payment {

    void doTransaction();

    default void addCoupon(){
        System.out.println("1 Rs CashBack");
    }

    static void generateReport(){
        System.out.println("Report Generated");
    }

    
}
