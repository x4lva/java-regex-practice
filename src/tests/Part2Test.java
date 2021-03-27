package tests;

import junit.framework.TestCase;
import main.Part2;
import main.Util;
import org.junit.Assert;
import org.junit.Test;

public class Part2Test extends TestCase {

    private static final String data = Util.getInput("part2.txt");

    @Test
    public void testConvert() {
        String expected = "Min: I, s, m\n" +
                "Max: younger, anybody, assured, changed";

        String actual = Part2.convert(data);
        Assert.assertEquals(expected, actual);
    }
}