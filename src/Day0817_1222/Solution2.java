package Day0817_1222;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) throws FileNotFoundException {
    	// 입력 리디렉션: 파일에서 입력을 읽기 위해 사용
        System.setIn(new FileInputStream("src/Day0817_1222/input_1222.txt"));
        Scanner sc = new Scanner(System.in);
       
        // 테스트 케이스 개수를 입력받음
        int t = sc.nextInt();
        
        // 개행 문자를 제거해줌
        sc.nextLine();

        // 각 테스트 케이스에 대해 반복
        for (int tc = 1; tc <= t; tc++) {
            // 중위 표기식 입력받음
            String infixExpression = sc.nextLine();

            // 중위 표기식을 후위 표기식으로 변환
            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);

            // 후위 표기식을 평가하여 결과 출력
            double result = evaluatePostfix(postfixExpression);
            System.out.println("Evaluation Result: " + result);
        }

    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        String[] tokens = infix.split(" ");
        for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c)) {
                postfix.append(token).append(" "); // 숫자는 그대로 결과 문자열에 추가
            } else if (c == '(') {
                operatorStack.push(c); // 여는 괄호는 스택에 추가
            } else if (c == ')') {
                // 닫는 괄호를 만날 때까지 연산자를 스택에서 꺼내 결과 문자열에 추가
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop(); // '(' 제거
            } else {
                // 연산자 우선순위를 비교하여 스택의 연산자를 꺼내 결과 문자열에 추가
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c); // 현재 연산자를 스택에 추가
            }
        }

        // 스택에 남은 연산자들을 결과 문자열에 추가
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0; // 연산자가 아닌 경우는 우선순위 0
        }
    }

    public static double evaluatePostfix(String postfix) {
        Stack<Double> operandStack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Double.parseDouble(token)); // 숫자를 스택에 추가
            } else {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(token.charAt(0), operand1, operand2);
                operandStack.push(result); // 연산 결과를 스택에 추가
            }
        }

        return operandStack.pop(); // 최종 결과값 반환
    }

    public static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
