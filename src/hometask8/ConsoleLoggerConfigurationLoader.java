package hometask8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Пример содержания конфигурационного файла:
Уровень логгирования:   DEBUG
Формат логгирования     %s  (%s)  message: %s
*/

public class ConsoleLoggerConfigurationLoader extends LoggerConfigurationLoader{
    public ConsoleLoggerConfigurationLoader(String path) {
        super(path);
        try (Scanner configurationReader = new Scanner(new File(path))){
            setLoggingLevel(configurationReader.nextLine());
            setFormat(configurationReader.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
