package by.it.novikov.jd02_06;

import javafx.scene.chart.ScatterChart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Logger {
    Calendar calendar = new GregorianCalendar();
    private final String filename="log.txt";
    private static volatile Logger logger;
    private Logger(){

    }

    static Logger getInstance(){
        Logger localLogger = Logger.logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }







    private static String getFilename(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }

    public void log(String text) {
        String fn = getFilename(Logger.class, this.filename);
         try (PrintWriter writer = new PrintWriter(
                new FileWriter(fn,true))){
             writer.println(text+" "+calendar.getTime());

         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}

