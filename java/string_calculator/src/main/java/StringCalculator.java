import com.google.common.base.Function;
import com.google.common.collect.Iterables;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    static final String DELIMITER_DECLARATION = "//";
    static final char DEFAULT_DELIMITER = ',';

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] inputTokens = tokenizeInput(input);
        Iterable<Integer> numbers = parseInts(inputTokens);
        return sumUpTokens(inputTokens);
    }

    private Iterable<Integer> parseInts(final String[] inputTokens) {
        return Iterables.transform(Arrays.asList(inputTokens), new Function<String, Integer>() {
            public Integer apply(final String input) {
                return Integer.parseInt(input);
            }
        });
    }

    private String[] tokenizeInput(final String input) {
        char delimiter = DEFAULT_DELIMITER;
        String inputData = input;
        if (declaresSpecialDelimiter(input)) {
            delimiter = parseDelimiter(input);
            inputData = removeDelimiterDeclaration(input);
        }
        return splitInputTokens(inputData, delimiter);
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
