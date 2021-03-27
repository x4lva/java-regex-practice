package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        String res = Util.getInput("part2.txt");
        System.out.println(convert(res));
    }

    public static String convert(String input) {
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;

        StringBuilder res  = new StringBuilder();
        Pattern pattern = Pattern.compile("(?<word>[\\p{javaAlphabetic}]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            if (matcher.group("word").length() > maxLength){
                maxLength = matcher.group("word").length();
            }
            if (matcher.group("word").length() < minLength){
                minLength = matcher.group("word").length();
            }
        }

        res.append("Min: ").append(getWordsByLength(minLength, input)).append("\n");
        res.append("Max: ").append(getWordsByLength(maxLength, input));

        return res.toString();
    }

    public static String getWordsByLength(int length, String text){
        StringBuilder res = new StringBuilder();
        Pattern pattern =  Pattern.compile("(?<![\\p{javaAlphabetic}])(?<word>[\\p{javaAlphabetic}]{"+length+"})(?![\\p{javaAlphabetic}])");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            if (!res.toString().contains(matcher.group("word"))){
                res.append(matcher.group("word")).append(", ");
            }
        }
        return res.substring(0, res.length()-2);
    }

}
