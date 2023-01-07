package hometask8;

public class ConsoleLoggerConfiguration extends LoggerConfiguration{
    public ConsoleLoggerConfiguration(LoggingLevel fileLoggingLevel) {
        super(fileLoggingLevel);
    }

    public ConsoleLoggerConfiguration(LoggerConfigurationLoader loggerConfigurationLoader) {
        super(loggerConfigurationLoader);
    }

    public ConsoleLoggerConfiguration() {
    }

    @Override
    protected void writeLogMessage(String logMessage, LoggingLevel loggingLevelMessage) {
        System.out.print(formatToString(loggingLevelMessage, logMessage));
    }
}
