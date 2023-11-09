package kz.dkazi.airastana.enums;

public enum EventType {

    UNDEFINED("Не указано"),
    VIEW("Просмотр"),
    CREATE("Создание"),
    EDIT("Редактирование"),
    DELETE("Удаление"),
    LOGIN("Вход в систему"),
    LOGOUT("Выход из системы");

    private final String label;

    private EventType(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
