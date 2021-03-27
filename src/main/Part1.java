package main;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String REGEX_EMAIL_PARSE = "(?<email>\\p{javaAlphabetic}[\\p{javaAlphabetic}\\d._]+@([a-zA-Z.])+((net)|(com)|(org)))";
    private static final String REGEX_USERNAME_PARSE = "(?<username>[\\p{javaAlphabetic}\\w]+)";

    public static void main(String[] args) {
        String res = Util.getInput("part1.txt");
        System.out.println(convert1(res));
        System.out.println(convert2(res));
        System.out.println(convert3(res));
        System.out.println(convert4(res));
    }

    public static String convert1(String input) {
        StringBuilder res  = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX_USERNAME_PARSE+";.+;"+REGEX_EMAIL_PARSE);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            res.append(matcher.group("username")).append(": ").append(matcher.group("email")).append("\n");
        }
        return res.toString();
    }

    public static String convert2(String input) {
        StringBuilder res  = new StringBuilder();
        Pattern pattern = Pattern.compile(".+;(?<firstname>\\p{javaAlphabetic}+) (?<surname>\\p{javaAlphabetic}+);"+REGEX_EMAIL_PARSE);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            res.append(matcher.group("surname")).append(" ").append(matcher.group("firstname")).append(" (email: ").append(matcher.group("email")).append(")\n");
        }
        return res.toString();
    }

    public static String convert3(String input) {
        StringBuilder res  = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\b@(?<domain>.+)\\b)(?![\\s\\S]*\\b\\1\\b)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            res.append(matcher.group("domain")).append(" ==> ");
            pattern = Pattern.compile("(?<username>.+);.+;.+(?<domain>"+matcher.group("domain")+")");
            Matcher user = pattern.matcher(input);
            while (user.find()){
                res.append(user.group("username")).append(", ");
            }
            res.replace(res.length()-2, res.length(), "");
            res.append("\n");
        }

        String[] lines = res.toString().split("\n");

        res.setLength(0);

        for (int i = lines.length-1; i >= 0 ; i--) {
            res.append(lines[i]);
            res.append("\n");
        }

        return res.toString();
    }

    public static String convert4(String input) {
        StringBuilder res = new StringBuilder();
        Pattern pattern = Pattern.compile("(.+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            res.append(matcher.group()).append(";");
            if (matcher.group().contains("@")){
                SecureRandom random = new SecureRandom();
                res.append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10));
            }else {
                res.append("Password");
            }
            res.append("\n");
        }

        return res.toString();
    }
}