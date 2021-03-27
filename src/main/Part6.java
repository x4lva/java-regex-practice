package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String res = Util.getInput("part6.txt");
        System.out.println(convert(res));
    }

    public static String convert(String input) {
        StringBuilder res  = new StringBuilder();
        Pattern pattern = Pattern.compile("[\\p{javaAlphabetic}]+\r?\n? ?");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            pattern = Pattern.compile("[ \0\n]"+matcher.group().replaceAll("[\\s]", "")+"[ \0\n\r]");
            Matcher word = pattern.matcher(input);
            int count = 0;
            while (word.find()){
                count++;
            }
            if(count>=2){
                res.append("_");
            }
            res.append(matcher.group());
        }

        return res.toString();
    }
}
