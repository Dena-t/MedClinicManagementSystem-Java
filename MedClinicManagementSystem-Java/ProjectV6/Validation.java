package ProjectV6;

public class Validation {

    public static boolean validateName(String drName) {
        return drName.matches(
                "[a-zA-Z][a-zA-Z\\-' ]*[a-zA-Z ]");
    }

    public static boolean validatedrAdd(String drAdd) {
        return drAdd.matches(
                "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    public static boolean validatePhone(String phone) {
        return phone.matches("(?:\\([1-9]\\d{2}\\)\\ ?|[1-9]\\d{2}(?:\\-?|\\ ?))[1-9]\\d{2}[- ]?\\d{4}");
    }

    public static boolean validatedrBDate(String drBDate) {
        return drBDate.matches(
                "((19[0-9][0-9])|(20[0-2][0-9]))\\-((0?[1-9])|(1[0-2]))\\-((0?[1-9])|([1-2][0-9])|(3[0-1]))");
    }

    // public static boolean validatepName(String pName) {
    // return pName.matches(
    // "[a-zA-z]+(['-][a-zA-Z]+)*\t[a-zA-z]+(['-][a-zA-Z]+)*");
    // }

    public static boolean validatepAddress(String pAddress) {
        return pAddress.matches(
                "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // public static boolean validatepPhone(String pPhone) {
    // return pPhone.matches("n[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
    // }

    public static boolean validatepBDate(String pDateset) {
        return pDateset.matches(
                "((19[0-9][0-9])|(20[0-2][0-9]))\\-((0?[1-9])|(1[0-2]))\\-((0?[1-9])|([1-2][0-9])|(3[0-1]))");
    }

    public static boolean validateYear(int year) {
        String years = String.valueOf(year);
        return years.matches("((19[0-9][0-9])|(20[0-2][0-9]))");

    }

    public static boolean validateMonth(int Month) {
        String months = String.valueOf(Month);
        return months.matches("((0?[1-9])|(1[0-2]))");

    }

    public static boolean validateDay(int day) {
        String days = String.valueOf(day);
        return days.matches("((((0?[1-9])|([1-2][0-9])|(3[0-1]))))");

    }

}
