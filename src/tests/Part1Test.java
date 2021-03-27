package tests;

import junit.framework.TestCase;
import main.Part1;
import main.Util;
import org.junit.Assert;
import org.junit.Test;

public class Part1Test extends TestCase {

    private static final String data = Util.getInput("part1.txt");

    @Test
    public void testConvert1() {
        String expected = "ivanov: ivanov@mail.com\n" +
                "петров: petrov@google.com\n" +
                "obama: obama@google.com\n" +
                "bush: bush@mail.com\n";

        String actual = Part1.convert1(data);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvert2() {
        String expected = "Ivanov Ivan (email: ivanov@mail.com)\n" +
                "Петров Петр (email: petrov@google.com)\n" +
                "Obama Barack (email: obama@google.com)\n" +
                "Буш Джордж (email: bush@mail.com)\n";

        String actual = Part1.convert2(data);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvert3() {
        String expected = "mail.com ==> ivanov, bush\n" +
                "google.com ==> петров, obama\n";

        String actual = Part1.convert3(data);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvert4() {
        String expected = "Login;Name;Email;Password\n" +
                "ivanov;Ivan Ivanov;ivanov@mail.com;1707\n" +
                "петров;Петр Петров;petrov@google.com;9321\n" +
                "obama;Barack Obama;obama@google.com;4623\n" +
                "bush;Джордж Буш;bush@mail.com;7514\n";

        String actual = Part1.convert4(data);
        int count = 0;
        for (int i = 0, len = actual.length(); i < len; i++) {
            if (Character.isDigit(actual.charAt(i))) {
                count++;
            }
        }
        Assert.assertEquals(16, count);
    }

}