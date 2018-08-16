package com.datastructure;

public class Stack {
    private int[] elements;
    private int size = 0;

    public Stack() {
        elements = new int[100];
    }

    public void push(int value) {
        if (size == elements.length) {
            int[] temp = elements.clone();
            elements = new int[size + size];
            for (int i = 0; i < size; i++) {
                elements[i] = temp[i];
            }
        }
        elements[size] = value;
        size++;
    }

    public int pop() {
        if (size > 0) {
            return elements[--size];
        } else {
            System.out.println("Stack is empty");
            return 0;
        }
    }

    public int top() {
        if (size > 0) {
            return elements[size - 1];
        } else {
            System.out.println("Stack is empty");
            return 0;
        }

    }

    public void clear() {
        size = 0;
    }

    public int[] getAllValues() {
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(elements[i]).append(',');
        }
        return result.toString();
    }
}
