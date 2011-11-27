public class StringCalculator {

    static final String DELIMITER_DECLARATION = "//";
    static final char DEFAULT_DELIMITER = ',';

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int result = 0;
        char delimiter = DEFAULT_DELIMITER;
        String[] inputTokens;
        if (declaresSpecialDelimiter(input)) {
            delimiter = parseDelimiter(input);
            inputTokens = splitInputTokens(input.substring(4), delimiter);
            for (String nextNumber : inputTokens) {
                result += Integer.parseInt(nextNumber);
            }
        } else {
            inputTokens = splitInputTokens(input, delimiter);
            for (String nextNumber : inputTokens) {
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
