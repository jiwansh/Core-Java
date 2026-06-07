package Java8;

/*
 * Scenario 1
 * Default method inherited.
 */

public class Main {

    public static void main(String[] args) {

        Payment googlePay = new GooglePay();

        googlePay.addCoupon();
        // Output:
        // 5 Rs Cashback

        /*
         * Scenario 2
         * Default method overridden.
         */

        Payment phonePe = new PhonePe();

        phonePe.addCoupon();
        // Output:
        // 10% Cashback

        /*
         * Scenario 3
         * Static method.
         */

        Payment.generateReport();
        // Output:
        // Transaction Report Generated
    }
}