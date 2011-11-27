public class StringCalculator {

    static final String DELIMITER_DECLARATION = "//";
    static final char DEFAULT_DELIMITER = ',';

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int result = 0;
        char delimiter = DEFAULT_DELIMITER;
        if (declaresSpecialDelimiter(input)) {
            delimiter = parseDelimiter(input);
            for (String nextNumber : input.substring(4).split("[\n"+ delimiter +"]")) {
                result += Integer.parseInt(nextNumber);
            }
        } else {
            for (String nextNumber : input.split("[\n"+delimiter+"]")) {
                result += Integer.parseInt(nextNumber);
            }
        }
        return result;
    }

    private char parseDelimiter(final String input) {
        return input.charAt(2);
    }

    private boolean declaresSpecialDelimiter(final String input) {
        return input.startsWith(DELIMITER_DECLARATION);
    }
}
