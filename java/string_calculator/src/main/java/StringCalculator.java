import ch.lambdaj.function.closure.Closure1;
import ch.lambdaj.function.convert.Converter;

import java.util.Arrays;

import static ch.lambdaj.Lambda.*;

public class StringCalculator {

    static final String DELIMITER_DECLARATION = "//";
    static final char DEFAULT_DELIMITER = ',';

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] inputTokens = tokenizeInput(input);
        Iterable<Integer> numbers = parseInts(inputTokens);
        return sumUpTokens(numbers);
    }

    private Iterable<Integer> parseInts(final String[] inputTokens) {
        Closure1<String> parseIntClosure = closure(String.class).of(Integer.class, "parseInt", var(String.class));
        Converter parseIntConverter = parseIntClosure.cast(Converter.class);
        return convert(Arrays.asList(inputTokens), parseIntConverter);
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
        return input.substring((DELIMITER_DECLARATION + DEFAULT_DELIMITER + '\n').length());
    }

    private int sumUpTokens(final Iterable<Integer> numbers) {
        return sum(numbers).intValue();
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
