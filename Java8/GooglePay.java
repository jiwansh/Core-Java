package Java8;

/*
 * Uses default implementation.
 */

public class GooglePay implements Payment {

    @Override
    public void doTransaction(){
        System.out.println("GPay Transactions");
    }
    
}
