package ru.tspu.auth;

/**
 *
 * @author maa
 */
public class Settings {

    private String apiEndpoint = "http://mail.tspu.edu.ru/api.php";
    private String method = "POST";
    
    private static final Settings SETTINGS = new Settings();

    public synchronized static Settings instance() {
        return SETTINGS;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public String getMethod() {
        return method;
    }

    private Settings() {
    }

    public enum FIELD {
        RETURN("return"),
        LOGIN("login"),
        PASSWORD("password");

        private String name;

        private FIELD(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

}
