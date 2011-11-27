import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void treatsEmptyStringsAsZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addsSingleNumbers() {
        assertEquals(17, stringCalculator.add("17"));
    }

    @Test
    public void addsCommaSeparatedNumbers() {
        assertEquals(2356, stringCalculator.add("2341,15"));
    }

    @Test
    public void treatsNewLineAsSeparator() {
        assertEquals(35, stringCalculator.add("34\n1"));
    }

    @Test
    public void supportsCustomSeparators() throws Exception {
        assertEquals(7, stringCalculator.add("//;\n5;2"));
    }
}
