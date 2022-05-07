package utilities;

import java.util.Iterator;
import java.util.List;

import com.github.dockerjava.api.model.LogConfig.LoggingType;

import enums.loggerType;
import io.netty.handler.logging.LogLevel;
import reports.frameworkLogger;


public class genericUtility {

    public static <T> List<T> removeNullFromList(List<T> list) {

        Iterator<T> itr = list.iterator();
       try {
        while (itr.hasNext()) {
            if (itr.next() == null || itr.next().toString().length()<=0) {
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
