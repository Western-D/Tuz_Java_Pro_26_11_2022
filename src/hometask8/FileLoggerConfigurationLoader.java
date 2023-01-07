package hometask8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Пример содержания конфигурационного файла:
Путь файла:             C:/Logs/
Уровень логгирования:   DEBUG
Размер файла:           512
Формат логгирования     %s  (%s)  message: %s
*/

public class FileLoggerConfigurationLoader extends LoggerConfigurationLoader{
    private int fileMaxSize;
    private String logsPath;
    public FileLoggerConfigurationLoader(String path) {
        super(path);

        try (Scanner configurationReader = new Scanner(new File(path))){
            logsPath = configurationReader.nextLine();
            setLoggingLevel(configurationReader.nextLine());
            fileMaxSize = Integer.parseInt(configurationReader.nextLine());
                setFormat(configurationReader.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public int getFileMaxSize() {
        return fileMaxSize;
    }
    public String getLogsPath() {
        return logsPath;
    }
}
