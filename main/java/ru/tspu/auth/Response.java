package ru.tspu.auth;

/**
 * Ответ сервера аутентификации
 * @author maa
 */
public class Response {
    private final String fio;
    private final String group;

    /**
     * @param fio Фамилия Имя Отчество пользователя
     * @param group если пользователь является студентом, то ответ сопроваждется его группой
    */
    public Response(String fio, String group) {
        this.fio = fio;
        this.group = group;
    }

    public String getFio() {
        return fio;
    }

    public String getGroup() {
        return group;
    }
    
}
