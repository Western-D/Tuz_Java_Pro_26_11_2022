package hometask8;

public class FileLogger extends Logger {
    public FileLogger(LoggerConfigurationLoader fileLoggerConfigurationLoader) {
        super(new FileLoggerConfiguration((FileLoggerConfigurationLoader) fileLoggerConfigurationLoader));
    }

    public FileLogger(LoggerConfiguration loggerConfiguration) {
        super(loggerConfiguration);
    }

    public FileLogger() {
        super(new FileLoggerConfiguration());
    }
}

