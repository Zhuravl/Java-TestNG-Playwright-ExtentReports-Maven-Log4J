package ua.com.usource.common.enums;

/**
 * Enum contains set of available website pages
 */
public enum AppPage {

    ABOUT("About", "about"),
    SIGN_IN("Sign In", "login"),
    SIGN_UP("Sign Up", "register"),
    HOME("Home", "");

    private final String name;
    private final String prefix;

    AppPage(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        return name;
    }
}
