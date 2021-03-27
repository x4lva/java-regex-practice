package tests;

import junit.framework.TestCase;
import main.Part4;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class Part4Test extends TestCase {

    @Test
    public void testHash() throws NoSuchAlgorithmException {
        String expected = "912EC803B2CE49E4A541068D495AB570";
        String actual = Part4.hash("asdf", "MD5");
        assertEquals(expected, actual);
        expected="F0E4C2F76C58916EC258F246851BEA091D14D4247A2FC3E18694461B1816E13B";
        actual = Part4.hash("asdf", "SHA-256");
        assertEquals(expected, actual);
    }
}