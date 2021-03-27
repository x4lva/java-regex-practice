package tests;

import junit.framework.TestCase;
import main.Part5;

public class Part5Test extends TestCase {

    public void testDecimal2Roman() {
        assertEquals("XII", Part5.decimal2Roman(12));
        assertEquals("XLVII", Part5.decimal2Roman(47));
        assertEquals("LXXVIII", Part5.decimal2Roman(78));
    }

    public void testRoman2Decimal() {
        assertEquals(25, Part5.roman2Decimal("XXV"));
        assertEquals(56, Part5.roman2Decimal("LVI"));
        assertEquals(98, Part5.roman2Decimal("XCVIII"));
    }
}