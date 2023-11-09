package kz.dkazi.airastana.enums;

public enum EventStatus {
    SUCCESS("Успешное"),
    FAILURE("Неуспешное"),
    UNDEFINED("Неизвестно");

    private final String label;

    private EventStatus(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
