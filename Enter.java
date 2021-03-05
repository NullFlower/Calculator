import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Enter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入表达式，例如：1+2*3^(2*3-2+-1)");
//            System.out.println(symbolsIO.poland);
            System.out.println();
            try {
                polandCutString.start(sc.next());
            }catch (Exception e){
                System.out.println("输入错误，请检查符号大小写和括号数量是否正确。");
            }
            System.out.println();
            polandCutString.expression=new ArrayList();
            polandCutString.cutInput = new String[100];
            symbolsIO.poland = new ArrayList();
            symbolsIO.symbols = new Stack();
            Calculate.cal = new Stack();
        }
    }
}
