package hometask8;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerConfiguration {
    private LoggingLevel loggingLevel = LoggingLevel.INFO;
    private String format = "%s \t(%s)\tmessage: %s";

    public LoggerConfiguration(LoggingLevel fileLoggingLevel) {
        this.loggingLevel = fileLoggingLevel;
    }

    public LoggerConfiguration(LoggerConfigurationLoader loggerConfigurationLoader) {
        this.format = loggerConfigurationLoader.getFormat();
        loggingLevel = loggerConfigurationLoader.equals("INFO") ? LoggingLevel.INFO : LoggingLevel.DEBUG;
    }

    public LoggerConfiguration() {

    }
    public LoggingLevel getLoggingLevel() {
            return loggingLevel;
        }
    protected String getTime() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
            return simpleDateFormat.format(new Date());
        }
    protected String getDate() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date());
        }
        protected String formatToString(LoggingLevel loggingLevel, String message){
            return String.format(format+"\n", loggingLevel, getTime(), message);
        }
    protected void writeLogMessage(String logMessage, LoggingLevel loggingLevelMessage){}
    }

