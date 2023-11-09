package kz.dkazi.airastana.enums;

public enum EventSection {

    UNDEFINED("Не указано"),
    UPDATE("Журнал изменении");

    private final String label;

    private EventSection(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

}
