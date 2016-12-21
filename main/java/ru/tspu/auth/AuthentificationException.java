package ru.tspu.auth;

/**
 *
 * @author maa
 */
public class AuthentificationException extends Exception {
    
    private int statusCode;

    public AuthentificationException(int statusCode) {
        super("Неверный логин или пароль");
        this.statusCode = statusCode;
    }

    public AuthentificationException(String msg) {
        super(msg);
    }
}
