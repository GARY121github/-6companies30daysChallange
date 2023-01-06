package Microsoft;

import java.util.*;
public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        int answer = 0;
        String operators = "+-*/";


        for(String op : tokens){
            int index = operators.indexOf(op);

            if(index == -1){
                operands.push(Integer.valueOf(op));
            }
            else{
                if(operands.size() < 2){
                    return 0;
                }

                int op2 = operands.pop();
                int op1 = operands.pop();


                switch (index){
                    case 0: answer = op1 + op2;
                        break;
                    case 1: answer = op1 - op2;
                        break;
                    case 2: answer = op1 * op2;
                        break;
                    case 3:
                        if(op2 == 0){
                            return 0;
                        }

                        answer = op1 / op2;

                        break;
                    default:
                        return 0;

                }
                operands.push(answer);
            }
        }
        return operands.pop();
    }
}
