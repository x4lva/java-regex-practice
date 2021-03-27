package tests;

import junit.framework.TestCase;
import main.Part3;
import main.Util;
import org.junit.Assert;
import org.junit.Test;

public class Part3Test extends TestCase {

    private static final String data = Util.getInput("part3.txt");

    @Test
    public void testConvert() {
        String expected = "when I Was Younger\n" +
                "I Never Needed";

        String actual = Part3.convert("When I was younger\n" +
                "I never needed");
        Assert.assertEquals(expected, actual);
    }
}