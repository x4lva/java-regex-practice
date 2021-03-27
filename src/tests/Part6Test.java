package tests;

import junit.framework.TestCase;
import main.Part6;
import org.junit.Test;

public class Part6Test extends TestCase {

    @Test
    public void testConvert() {
        String data = "This is a test\n" +
                "And this is also a test\n" +
                "And these are also tests\n" +
                "test ��� ����\n" +
                "��� ����� ����\n" +
                "� ��� ����� �����";
        String expected = "This _is _a _test\n" +
                "_And this _is _also _a _test\n" +
                "_And these are _also tests\n" +
                "_test _��� _����\n" +
                "_��� _����� _����\n" +
                "� ��� _����� �����";
        String actual = Part6.convert(data);
        assertEquals(expected, actual);
    }
}