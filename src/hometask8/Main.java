package hometask8;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        FileLoggerConfigurationLoader fileLoggerConfigurationLoaded = new FileLoggerConfigurationLoader("C:/Users/USER/Desktop/fileConfiguration.txt");
        LoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(fileLoggerConfigurationLoaded);
        Logger fileLogger = new FileLogger(fileLoggerConfiguration);

        LoggerConfigurationLoader consoleLoggerConfigurationLoaded = new ConsoleLoggerConfigurationLoader("C:/Users/USER/Desktop/consoleConfiguration.txt");
        LoggerConfiguration consoleLoggerConfiguration = new ConsoleLoggerConfiguration(consoleLoggerConfigurationLoaded);
        Logger consoleLogger = new ConsoleLogger(consoleLoggerConfiguration);
        for (int i = 0; i < 60; i++) {
            if (i%2 == 0)
                fileLogger.toLogInDebug("some debug message");
            else
                fileLogger.toLogInInfo("some info message");
            Thread.sleep(40);
        }
        for (int i = 0; i < 60; i++) {
            if (i%2 == 0)
                consoleLogger.toLogInDebug("some debug message");
            else
                consoleLogger.toLogInInfo("some info message");

        }
    }
}
