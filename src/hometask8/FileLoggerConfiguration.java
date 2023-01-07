package hometask8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLoggerConfiguration extends LoggerConfiguration {
    private String fileName;
    private int fileMaxSize = 1024;
    private String logsPath = "C:/Users/USER/IdeaProjects/MyFirstProjetc_with_JavaPro-26_11_2022/Logs/";


    public FileLoggerConfiguration() {
        setFileName();
    }

    public FileLoggerConfiguration(int fileMaxSize, LoggingLevel fileLoggingLevel) {
        super(fileLoggingLevel);
        this.fileMaxSize = fileMaxSize;
        setFileName();

    }

    public FileLoggerConfiguration(FileLoggerConfigurationLoader fileLoggerConfigurationLoader) {
        super(fileLoggerConfigurationLoader);
        this.logsPath = fileLoggerConfigurationLoader.getLogsPath();
        checkAndCreateFolder(logsPath);
        this.fileMaxSize = fileLoggerConfigurationLoader.getFileMaxSize();
        setFileName();
    }


    public String getFileName() {
        return fileName;
    }

    protected String getActualPath() {
        String actualPath = logsPath + getDate() + "/";
        checkAndCreateFolder(actualPath);
        return actualPath;
    }

    private void checkAndCreateFolder(String actualPath) {
        File folder = new File(actualPath);
        if (!folder.exists())
            folder.mkdir();
    }

    protected void createNewLogFile() {
        setFileName();
    }

    private void setFileName() {
        if (fileName != null && fileName.startsWith("Log_" + getTime()))
            if (!fileName.equals("Log_" + getTime())) {
                int prefix = fileName.lastIndexOf("-");
                int countFile = Integer.parseInt(fileName.substring(prefix+1));
                fileName = fileName.substring(0, prefix) + "-" + (countFile + 1);
            } else
                fileName = "Log_" + getTime() + "-1";
        else
            fileName = "Log_" + getTime();
    }

    protected boolean checkFileMaxSize() {
        File file = new File(getActualPath() + fileName);
        long fileSize = file.length();
        return  fileSize >= fileMaxSize;
    }

    protected void writeLogMessage(String logMessage, LoggingLevel loggingLevelMessage) {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(getActualPath() +
                getFileName(), true))) {
            String message = formatToString(loggingLevelMessage, logMessage);
            logWriter.write(message);
            if (checkFileMaxSize())
                createNewLogFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

