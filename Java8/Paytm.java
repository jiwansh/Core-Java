package Java8;
// uses default implemenatation

public class Paytm  implements Payment{

@Override
public void doTransaction() {
   System.out.println("Paytm Transactions");
}

@Override
public void addCoupon(){
 System.out.println("Paytm coupon added");
}
}
