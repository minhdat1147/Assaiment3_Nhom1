package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validator {
    public static boolean isOrderDate(String orderDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        try{
            dateFormat.parse(orderDate);
        }catch (ParseException e){
            return false;
        }
        return true;
    }
}
