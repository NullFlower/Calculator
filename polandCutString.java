import java.util.ArrayList;
import java.util.Scanner;

public class polandCutString {
    static ArrayList expression = new ArrayList();
    static String[] cutInput = new String[100];
    static String input = new String("");


    public static int getNumber(int x, int y) {
        String temp = "";
        for (int i = x; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))||input.charAt(i)=='.') {
                temp += input.charAt(i);
            } else {
                cutInput[y] += temp;
                return i - 1;
            }
        }
        cutInput[y] += temp;
        return input.length() - 1;
    }

    public static void cutString() {
        int t = 0, t2 = 0;
        if (input.charAt(0) == '-') {
            cutInput[0] += '-';
            t2 = getNumber(1, 0) + 1;
            t = 1;
        }//特殊情况特殊处理，第一个数字是负数。
        for (int i = t2; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))||input.charAt(i)=='.') {

                i = getNumber(i, t);
                t++;
            } else if (i < input.length() - 1) {


                if (input.charAt(i + 1) == '-'&&input.charAt(i)!=')') {
                    cutInput[t] += input.charAt(i);
                    cutInput[t + 1] += '-';
                    i++;
                    t++;
                } else {
                    cutInput[t] += input.charAt(i);
                    t++;
                }
            } else {

                cutInput[t] += input.charAt(i);
                t++;
            }
        }
    }

    public static void getString() {
        for (int i = 0; i < cutInput.length; i++) {
            System.out.print(cutInput[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void setString() {
        for (int i = 0; i < cutInput.length; i++) {
            cutInput[i] = "";
        }
    }

    public static void setExpression() {
        for (int i = 0; i < cutInput.length; i++) {
            if (cutInput[i] != "") {
                expression.add(cutInput[i]);
            }
        }
    }

    public static void getExpression() {
        for (int i = 0; i < expression.size(); i++) {
            System.out.print(expression.get(i));
        }
    }

    public static void start(String enter) {
//        input = "(100+500*(100-600--300*((-1+-1)*2))+10)";
        input=enter;
        setString();
        cutString();
//        getString();
        setExpression();
//        getExpression();
        System.out.println();
        System.out.println();
        symbolsIO.checkSymbol();

        Calculate.calculate();
        System.out.println(Calculate.cal.peek());


    }
}
