package ru.tspu.auth;

import org.junit.Test;

/**
 *
 * @author maa
 */
public class AuthentificatorTest {
    
    public AuthentificatorTest() {
    }

    @Test
    public void testCheckCredentails() throws Exception {
        System.out.println("checkCredentails");
        String login = "s4543";
        String password = "37078790";
        Authentificator instance = new Authentificator();
        instance.checkCredentails(login, password);
    }
    
    @Test(expected = AuthentificationException.class)
    public void testCheckCredentailsException() throws Exception {
        System.out.println("checkBadCredentails");
        String login = "bad";
        String password = "bad";
        Authentificator instance = new Authentificator();
        instance.checkCredentails(login, password);
    }
    
}
