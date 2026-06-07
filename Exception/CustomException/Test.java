package Exception.CustomException;

public class Test {
    public void getOrder(int id) throws ObjectNotFoundException{
        if(id==420){
            throw new ObjectNotFoundException("420 not allowed");
        }
        else{
            System.out.println("Your successfull placed order with id is"+id);
        }
    }
    public static void main(String[] args) throws ObjectNotFoundException {
        Test t = new Test();
        t.getOrder(654);

    }
}
