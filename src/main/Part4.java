package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        digest.update(input.getBytes());

        byte[] hash = digest.digest();

        StringBuilder res = new StringBuilder();
        for (byte b : hash) {
            res.append(String.format("%02X", b));
        }

        return res.toString();
    }
}
