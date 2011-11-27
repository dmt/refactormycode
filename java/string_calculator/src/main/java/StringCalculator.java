public class StringCalculator {

    static final String DELIMITER_DECLARATION = "//";

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int result = 0;
        if (declaresSpecialDelimiter(input)) {
            for (String nextNumber : input.substring(4).split("[\n"+ parseDelimiter(input) +"]")) {
                result += Integer.parseInt(nextNumber);
            }
        } else {
            for (String nextNumber : input.split("[\n,]")) {
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
