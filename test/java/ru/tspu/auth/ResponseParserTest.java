package ru.tspu.auth;

import org.junit.Assert;
import org.junit.Test;


public class ResponseParserTest {
    
    @Test
    public void parseTest() {
        String fio = "Иванов Имярек Батькович";
        String group = "123";
        String msg = fio + ";" + group;
        Response response = ResponseParser.parse(msg);
        Assert.assertEquals(fio, response.getFio());
        Assert.assertEquals(group, response.getGroup());
    }
    
}
