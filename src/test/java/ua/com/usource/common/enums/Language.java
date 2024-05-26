package ua.com.usource.common.enums;

public enum Language {

    ENGLISH("English", "eng"),
    UKRAINIAN("Українська", "ukr");

    private final String name;
    private final String value;

    Language(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
