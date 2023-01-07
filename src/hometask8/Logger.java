package hometask8;

public abstract class Logger
{
    LoggerConfiguration configuration;
    public Logger(LoggerConfiguration loggerConfiguration){
        this.configuration = loggerConfiguration;
    }

    public Logger(LoggerConfigurationLoader LoggerConfigurationLoader) {
        configuration = new LoggerConfiguration(LoggerConfigurationLoader);
    }

    public Logger(LoggingLevel loggingLevel) {
        configuration = new LoggerConfiguration(loggingLevel);
    }

    public Logger() {
        configuration = new LoggerConfiguration();
    }
    public void toLogInInfo(String logMessage){
        configuration.writeLogMessage(logMessage,LoggingLevel.INFO);
    }
    public void toLogInDebug(String logMessage){
        if (configuration.getLoggingLevel() == LoggingLevel.DEBUG)
            configuration.writeLogMessage(logMessage,LoggingLevel.DEBUG);
    }
}
