package com.example.project;

import java.util.*;

class solution {
    public static boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int stacky(String[] tokens, int X) {
        Stack<String> stack = new Stack<String>();
        int x, y;
        String result = "";
        int get = 0;
        String choice="0";
        int value = 0;
        String p = "";
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("*") | tokens[i].equals("+") | tokens[i].equals("-") | tokens[i].equals("/")|tokens[i].equals("^")) {
                choice = tokens[i];
            } else if (isNumeric(tokens[i])) {
                stack.push(tokens[i]);
                continue;
            } else {
                stack.push(String.valueOf(X));
                continue;
            }
            if (choice.equals("*")) {
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                value = x * y;
                result = p + value;
                stack.push(result);
            }
            if (choice.equals("+")) {
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                value = x + y;
                result = p + value;
                stack.push(result);
            }
            if (choice.equals("/")) {
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                value = x / y;
                result = p + value;
                stack.push(result);
            }
            if (choice.equals("-")) {
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                value = x - y;
                result = p + value;
                stack.push(result);
            }
            if (choice.equals("^")) {
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                value = 1;
                for(int k = 0; k<x; k++) {
                    value = value * y;
                }
                result = p + value;
                stack.push(result);
            }
        }
        return Integer.parseInt(result);
    }
}
