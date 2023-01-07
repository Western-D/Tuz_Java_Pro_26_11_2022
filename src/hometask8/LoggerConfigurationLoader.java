package hometask8;


public abstract  class LoggerConfigurationLoader {
    private String loggingLevel;
    private String format;

    public void setLoggingLevel(String loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public LoggerConfigurationLoader(String path) {
    }
    public String getFormat() {
        return format;
    }
}

