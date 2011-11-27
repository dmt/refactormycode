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
            for (String nextNumber : splitInputTokens(input.substring(4), delimiter)) {
                result += Integer.parseInt(nextNumber);
            }
        } else {
            for (String nextNumber : splitInputTokens(input, delimiter)) {
                result += Integer.parseInt(nextNumber);
            }
        }
        return result;
    }

    private String[] splitInputTokens(final String input, final char delimiter) {
        return input.split("[\n"+delimiter+"]");
    }

    private char parseDelimiter(final String input) {
        return input.charAt(2);
    }

    private boolean declaresSpecialDelimiter(final String input) {
        return input.startsWith(DELIMITER_DECLARATION);
    }
}
