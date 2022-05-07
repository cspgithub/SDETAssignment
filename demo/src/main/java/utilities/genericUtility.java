package utilities;

import java.util.Iterator;
import java.util.List;


public class genericUtility {

    public static <T> List<T> removeNullFromList(List<T> list) {

        Iterator<T> itr = list.iterator();
       
        while (itr.hasNext()) {
            if (itr.next() == null || itr.next().toString().length()<=0) {
                itr.remove();
            }

        }
        return list;

    }

}
