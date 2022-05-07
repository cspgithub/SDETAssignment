package utilities;

import java.util.Iterator;
import java.util.List;

import enums.loggerType;

import reports.frameworkLogger;

public class genericUtility {

    public static <T> List<T> removeNullFromList(List<T> list) {

        Iterator<T> itr = list.iterator();
        try {
            while (itr.hasNext()) {
                if (itr.next() == null || itr.next().toString().length() <= 0) {
                    String a= itr.next().toString();
                    frameworkLogger.log(loggerType.EXTENTREPORTANDCONSOLE, a);
                    itr.remove();
                }

            }

        } catch (Exception e) {
            String msg = e.getMessage();
            frameworkLogger.log(loggerType.EXTENTREPORTANDCONSOLE, msg);
        }

        return list;

    }

}
