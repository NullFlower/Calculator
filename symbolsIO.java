import java.util.ArrayList;
import java.util.Stack;

public class symbolsIO {
    static ArrayList poland = new ArrayList();
    static Stack symbols = new Stack();

    public static void stackOut() {
        int q = symbols.size();
        for (int t = 0; t < q; t++) {
            poland.add(symbols.pop());

        }
    }

    public static void checkSymbol() {
      for (int i = 0; i < polandCutString.expression.size(); i++) {
            switch (String.valueOf(polandCutString.expression.get(i))){
                case "(":{
                    symbols.push(polandCutString.expression.get(i));
                    continue;
                }
                case "+":
                case "-":
                {
                    int len=symbols.size();
                    for (int t=0;t<len;t++){
                        if (!symbols.peek().equals("(")){
                            poland.add(symbols.pop());
                        }else break;
                    }
                    symbols.push(polandCutString.expression.get(i));
                    continue;
                }
                case "*":
                case "/":{
                    int len=symbols.size();
                    for (int t=0;t<len;t++){
                        if (!symbols.peek().equals("(")&&!symbols.peek().equals("+")&&!symbols.peek().equals("-")){
                            poland.add(symbols.pop());
                        }else break;
                    }
                    symbols.push(polandCutString.expression.get(i));
                    continue;
                }
                case ")":{
                    int q = symbols.size();
                    for (int t = 0; t < q; t++) {
                        if (!symbols.peek().equals("(")) {
                            poland.add(symbols.pop());
                        } else {
                            symbols.pop();
                            break;
                        }
                    }
                    continue;
                }
                case "^":{
                    symbols.push(polandCutString.expression.get(i));
                    if (i<polandCutString.expression.size()-2) {
                        if (!polandCutString.expression.get(i + 1).equals("(") && !polandCutString.expression.get(i + 2).equals("^")) {
                            poland.add(polandCutString.expression.get(i + 1));
                            poland.add(symbols.pop());
                            i += 1;
                        } else if (polandCutString.expression.get(i + 2).equals("^")) {
                            continue;
                        } else {
                            symbols.push(polandCutString.expression.get(i + 1));
                            i += 1;
                            continue;
                        }

                        continue;
                    }else if (!polandCutString.expression.get(i + 1).equals("(")) {
                        poland.add(polandCutString.expression.get(i + 1));
                        poland.add(symbols.pop());
                        i += 1;
                        continue;
                    }
                }
                default:poland.add(polandCutString.expression.get(i));break;
            }
            stackOut();
        }
    }

}
