package frameworkLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import enums.loggerType;
import reports.reportManager;



public final class frameworkLog {

    private frameworkLog() {
    }

    private static Consumer<String> INFO = message -> reportManager.getExtTest().info(message);
    private static Consumer<String> CONSOLE = message -> System.out.println("INFO: " + message);

    private static Consumer<String> EXTENTREPORTANDCONSOLE = INFO.andThen(CONSOLE);

    private static Map<loggerType, Consumer<String>> MAP = new HashMap<>();

    static {

        MAP.put(loggerType.INFO, INFO);
        MAP.put(loggerType.EXTENTREPORTANDCONSOLE, EXTENTREPORTANDCONSOLE);

    }

    public static void log(loggerType status, String messsage) {
        MAP.get(status).accept(messsage);
    }

}
