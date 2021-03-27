package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String res = Util.getInput("part3.txt");
        System.out.println(convert(res));
    }

    public static String convert(String input) {
        StringBuilder res  = new StringBuilder(input);
        Pattern pattern = Pattern.compile("[\\p{javaAlphabetic}]{3,}");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            StringBuilder replaced = new StringBuilder(res.substring(matcher.start(), matcher.end()));
            if (Character.isUpperCase(replaced.charAt(0))){
                replaced.setCharAt(0, Character.toLowerCase(replaced.charAt(0)));
            }else{
                replaced.setCharAt(0, Character.toUpperCase(replaced.charAt(0)));
            }
            res.replace(matcher.start(), matcher.end(), replaced.toString());
        }

        return res.toString();
    }
}
