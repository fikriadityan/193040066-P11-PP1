/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author fikri aditya
 */
public class MyStack extends AbstractStack {
    public MyStack(int capacity) {
        super(capacity);
    }

    public void displayStack(String s) {
        System.out.println(s);
        System.out.println("Stack (bottom --> top):");
        for (int i = 0; i < size(); i++) {
            System.out.println(peekN(i));
            System.out.println(' ');
        }
        System.out.print("");
    }

    public int peekN(int n) {
        return arr[n];
    }

    @Override
    public void push(int data) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full");
        }
        arr[++top] = data;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return arr[top--];
    }
}