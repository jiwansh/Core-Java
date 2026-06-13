package marker;

public class DaoFramework {
     public void delete(Object object){

        if (object instanceof Deletable){
            //write DB logic
            // e.g. delete row from DB table corresponding to this entity
        }
    }
}
