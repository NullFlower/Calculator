import java.util.Stack;

public class Calculate {
    static Stack cal = new Stack();

    public static void calculate(){
        double num1,num2;

        for (int i = 0;i<symbolsIO.poland.size();i++){
            switch ((String)symbolsIO.poland.get(i)){
                case "+":{
                    num1=Double.parseDouble((String) cal.pop());
                    num2=Double.parseDouble((String) cal.pop());
                    cal.push( String.valueOf(num1+num2));
//                    System.out.println(num1+"+"+num2+"="+cal.peek());
                    break;
                }
                case "-":{
                    num1=Double.parseDouble((String) cal.pop());
                    num2=Double.parseDouble((String) cal.pop());
                    cal.push( String.valueOf(num2-num1));
//                    System.out.println(num2+"-"+num1+"="+cal.peek());
                    break;
                }
                case "*":{
                    num1=Double.parseDouble((String) cal.pop());
                    num2=Double.parseDouble((String) cal.pop());
                    cal.push( String.valueOf(num1*num2));
//                    System.out.println(num1+"*"+num2+"="+cal.peek());
                    break;
                }
                case "/":{
                    num1=Double.parseDouble((String) cal.pop());
                    num2=Double.parseDouble((String) cal.pop());
                    cal.push( String.valueOf(num2/num1));
//                    System.out.println(num2+"/"+num1+"="+cal.peek());
                    break;
                }
                case "^":{
                    num1=Double.parseDouble((String) cal.pop());
                    num2=Double.parseDouble((String) cal.pop());
                    cal.push( String.valueOf(Math.pow(num2, num1)));
//                    System.out.println(num2+"/"+num1+"="+cal.peek());
                    break;
                }
                default:cal.push(symbolsIO.poland.get(i));break;
            }
        }
    }
}
