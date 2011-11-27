import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator s;

    @Before
    public void setUp() throws Exception {
        s = new StringCalculator();
    }

    @Test
    public void treatsEmptyStringsAsZero() {
        assertEquals(0, s.add(""));
    }

    @Test
    public void addsSingleNumbers() {
        assertEquals(17, s.add("17"));
    }

    @Test
    public void addsCommaSeparatedNumbers() {
        assertEquals(2356, s.add("2341,15"));
    }

    @Test
    public void treatsNewLineAsSeparator() {
        assertEquals(35, s.add("34\n1"));
    }

    @Test
    public void supportsCustomSeparators() throws Exception {
        assertEquals(7, s.add("//;\n5;2"));
    }
}
