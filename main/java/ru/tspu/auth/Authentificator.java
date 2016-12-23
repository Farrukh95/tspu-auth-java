package ru.tspu.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 *
 * @author maa
 */
public class Authentificator {

    private final int OK = 200;

    public String checkCredentails(String login, String password) throws AuthentificationException {
        final String API = Settings.instance().getApiEndpoint();
        final String POST = Settings.instance().getMethod();
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(API).openConnection();
            con.setRequestMethod(POST);
            String params = buildParams(login, password);
            setPostFields(con, params);
            int status = con.getResponseCode();
            if (status != OK) {
                throw new AuthentificationException(status);
            }
            return getResponse(con);
        } catch (MalformedURLException ex) {
            throw new AuthentificationException(String.format("Неверный URL %s", API));
        } catch (IOException ex) {
            throw new AuthentificationException(String.format("Невозможно подключиться по URL %s", API));
        }
    }

    private String buildParams(String login, String password) {
        String delimeter = "&";
        StringBuilder sb = new StringBuilder();
        sb
                .append(Settings.FIELD.LOGIN.getName()).append("=").append(login)
                .append(delimeter)
                .append(Settings.FIELD.PASSWORD.getName()).append("=").append(password)
                .append(delimeter)
                .append(Settings.FIELD.RETURN.getName()).append("=").append("fio");
        return sb.toString();
    }

    private void setPostFields(HttpURLConnection con, String params) throws IOException {
        try {
            con.setDoOutput(true);
            OutputStream outputStream = con.getOutputStream();
            try (OutputStreamWriter requestData = new OutputStreamWriter(outputStream)) {
                requestData.write(params);
                requestData.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    private String getResponse(HttpURLConnection con) throws IOException {
        try (BufferedReader responseData = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String message = responseData.lines().collect(Collectors.joining("\n"));
            return message;
        }
    }
    
    

}
