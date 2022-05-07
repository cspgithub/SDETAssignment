package utilities;

import java.util.Iterator;
import java.util.List;

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

}
