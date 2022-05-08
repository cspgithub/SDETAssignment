package utilities;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import enums.loggerType;
import reports.frameworkLogger;

public class genericUtility {

    public static <T> List<T> removeNullFromList(List<T> list) {

        Iterator<T> itr = list.iterator();
       

        while (itr.hasNext()) {
            String a = itr.next().toString();
            frameworkLogger.log(loggerType.EXTENTREPORTANDCONSOLE, a);

            if (itr.next().toString().length() <= 0) {

                itr.remove();
            }

        }
        return list;

    }
    public static <T> List<T> removeDuplicateFromList(List<T> list) {

        List<T> deduped = list.stream().distinct().collect(Collectors.toList());
        return deduped;

       

    }

}
