public class StringCalculator {

    static final String DELIMITER_DECLARATION = "//";
    static final char DEFAULT_DELIMITER = ',';

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        char delimiter = DEFAULT_DELIMITER;
        String inputData = input;
        if (declaresSpecialDelimiter(input)) {
            delimiter = parseDelimiter(input);
            inputData = removeDelimiterDeclaration(input);
        }
        String[] inputTokens = splitInputTokens(inputData, delimiter);
        return sumUpTokens(inputTokens);
    }

    private String removeDelimiterDeclaration(final String input) {
        return input.substring((DELIMITER_DECLARATION+DEFAULT_DELIMITER+'\n').length());
    }

    private int sumUpTokens(final String[] inputTokens) {
        int result = 0;
        for (String nextNumber : inputTokens) {
            result += Integer.parseInt(nextNumber);
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
