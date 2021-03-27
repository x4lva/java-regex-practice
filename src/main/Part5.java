package main;

public class Part5 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i+" --> "+decimal2Roman(i)+" --> "+roman2Decimal(decimal2Roman(i)));
        }
    }

    public static String decimal2Roman(int dec) {
        StringBuilder res = new StringBuilder();

        int numberLength = (int)(Math.log10(dec)+1);

        for (int i = 0; i < numberLength; i++) {
            int place = (int) Math.pow(10,(numberLength - i - 1));
            int firstNum = dec/place;

            if (firstNum == 4){
                res.append(getRomanLetter(place));
                res.append(getRomanLetter(place*5));
            }else if (firstNum == 9){
                res.append(getRomanLetter(place));
                res.append(getRomanLetter(place*10));
            }else {
                if(firstNum > 4){
                    res.append(getRomanLetter(place*5));
                }
                for (int j = 0; j < firstNum%5; j++) {
                    res.append(getRomanLetter(place));
                }
            }
            dec -= firstNum*place;
        }

        return res.toString();
    }

    public static int roman2Decimal(String roman) {
        int res = 0;
        int prev = 0;
        for(int i = roman.length()-1; i>=0 ; i--) {
            int temp = getRomanLetter(roman.charAt(i));
            if(temp < prev){
                res-=temp;
            } else{
                res+=temp;
            }
            prev = temp;
        }
        return res;
    }

    public static String getRomanLetter(int place){
        switch (place){
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return  "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            default:
                return "";
        }
    }
    public static int getRomanLetter(char letter){
        switch (letter){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
