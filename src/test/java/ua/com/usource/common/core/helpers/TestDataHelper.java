package ua.com.usource.common.core.helpers;

import ua.com.usource.common.consts.Constants;
import ua.com.usource.common.enums.Language;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class contains methods that help to generate data or expected results
 */
public class TestDataHelper {

    private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String nonZeroDigits = "123456789";
    private static final String withZeroDigits = "0" + nonZeroDigits;
    private static final String specials = "/*-+.,~!@#$%^&()_=";
    private static final String allCharacters = letters + letters.toLowerCase() + withZeroDigits;
    private static final String allCharactersIncludeSpecials = allCharacters + specials;

    /**
     * Returns randomly generated email
     */
    public static String getRandomEmail() {
        return getRandomString(letters.toLowerCase(), 10) + "@" + getRandomString(letters.toLowerCase(), 5) + "." + getRandomString(letters.toLowerCase(), 3);
    }

    /**
     * Returns random generated password
     */
    public static String getRandomPassword() {
        return getRandomString(letters, 3) + getRandomString(withZeroDigits, 3) + getRandomString(specials, 3) + getRandomString(letters.toLowerCase(), 3);
    }

    /**
     * Returns date as formatted string with default format
     *
     * @param date calendar instance
     * @return formatted date as String
     */
    public static String getFormattedDate(Calendar date) {
        return getFormattedDate(date, Constants.DateFormat.MM_dd_yyyy);
    }

    /**
     * Returns date as formatted string
     *
     * @param calendar      calendar instance
     * @param formatPattern pattern string
     * @return formatted date as String
     */
    public static String getFormattedDate(Calendar calendar, String formatPattern) {
        return new SimpleDateFormat(formatPattern).format(calendar.getTime());
    }

    /**
     * Returns random generated string
     */
    public static String getRandomString() {
        return getRandomString(allCharacters, 16);
    }

    /**
     * Returns random number with defined length
     *
     * @param length number length
     */
    public static int getRandomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(nonZeroDigits.charAt(new Random().nextInt(nonZeroDigits.length())));
        for (int i = 1; i < length; i++) {
            sb.append(withZeroDigits.charAt(new Random().nextInt(withZeroDigits.length())));
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * Returns timestamp based on the current date and time
     */
    public static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DateFormat.YYYYMMDDHHMMSS);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar calendar = new GregorianCalendar();
        return sdf.format(calendar.getTime());
    }

    /**
     * Returns the About page text based on the selected language
     *
     * @param language selected language
     */
    public static String getAboutPageText(Language language) {
        StringBuilder sb = new StringBuilder();
        if (language == Language.ENGLISH) {
            sb.append("Hello! ");
            sb.append("We designed the Usource project as a way to transfer knowledge in the field of intelligent technologies. " +
                    "It's no secret that each team, group, organization has engineers who know or are able a little more than others. " +
                    "So we thought that it would be nice to give such guys the opportunity to share their experience with \"colleagues in the shop\". " +
                    "And this turned out to be very useful, both for the speakers themselves and for their students. " +
                    "The first group strengthens their authority among colleagues and consolidates their own knowledge by sharing their experience. " +
                    "The second group gets time-tested knowledge and invaluable experience. And the Usource portal serves as a link between these two audiences. ");
            sb.append("Best regards, ");
            sb.append("Usource Team");
        } else {
            sb.append("Привіт! ");
            sb.append("Ми замислили проект Usource, як спосіб передачі знань в області інтелектуальних технологій. " +
                    "Адже не секрет, що в кожній команді, колективі, організації є інженери, які знають або вміють трохи більше інших. " +
                    "І ось ми подумали, що було б непогано дати можливість таким людям поділитися своїм досвідом з \"колегами по цеху\". " +
                    "І це виявилося дуже корисно, як для самих доповідачів, так і для їх слухачів - перші, поширюючі свої знання, зміцнюють свій авторитет серед колег і " +
                    "закріплюють наявні знання (адже всім відомо, що \"для того, щоб в чомусь розібратися - потрібно пояснити це комусь іншому\"), другі - отримують перевірені часом знання і " +
                    "безцінний досвід, а портал Usource служить сполучною ланкою між цими двома аудиторіями. ");
            sb.append("З повагою ");
            sb.append("Команда Usource");
        }
        return sb.toString();
    }

    /**
     * Returns the confirmation message based on the selected language
     *
     * @param language selected language
     */
    public static String getConfirmationMessage(Language language) {
        StringBuilder sb = new StringBuilder();
        if (language == Language.ENGLISH) {
            sb.append("Successful Sign Up! ");
            sb.append("Use the Login button to proceed");
        } else {
            sb.append("Реєстрація успішна! ");
            sb.append("Використовуйте кнопку Увійти щоб продовжити");
        }
        return sb.toString();
    }

    /**
     * Returns random generated string
     *
     * @param symbols Initial symbols set
     * @param length  Number of symbols in generated string
     */
    private static String getRandomString(String symbols, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(symbols.charAt(new Random().nextInt(symbols.length())));
        }
        return sb.toString();
    }
}
