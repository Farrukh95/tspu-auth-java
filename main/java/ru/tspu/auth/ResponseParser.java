package ru.tspu.auth;

public class ResponseParser {

    /**
     * @param message
     * @return
     */
    public static Response parse(String message) {
        String[] fields = message.split(";");
        int length = fields.length;
        String fio = null;
        String group = null;
        if (length > 0) {
            fio = fields[Fields.FIO.ordinal()];
        }
        if (length > 1) {
            group = fields[Fields.GROUP.ordinal()];
        }
        return new Response(fio, group);
    }

    private enum Fields {
        FIO,
        GROUP;
    }

}
