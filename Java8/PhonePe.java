package Java8;

/*
 * Overrides default implementation.
 */

public class PhonePe implements Payment {

    @Override
    public void doTransaction() {
        System.out.println("PhonePe Transaction");
    }

    @Override
    public void addCoupon() {
        System.out.println("10% Cashback");
    }

    /*
     * @Override
    * public void generateReport(){
    *  can not be overriden
        }
    */

   

}
