/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author fikri aditya
 */
public class ParsePost {
    private MyStack stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
        stack = new MyStack(input.length()); // Menggunakan panjang input sebagai kapasitas stack
    }

    // Metode untuk mengevaluasi ekspresi postfix
    public int evaluatePostfix() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch)); // Push operand ke stack
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, ch);
                stack.push(result); // Push hasil operasi kembali ke stack
            }
        }
        return stack.pop(); // Hasil akhirnya adalah elemen terakhir di stack
    }

    // Metode untuk melakukan operasi aritmatika
    private int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    // Metode untuk memproses ekspresi postfix dan menghasilkan hasil perhitungan aritmatika
    public int doParse() {
        stack = new MyStack(20);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.displayStack("" + ch + " ");
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, ch);
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
