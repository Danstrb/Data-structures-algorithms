package com.utgard.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionMy {
    public boolean isBalanced (String input) {
        if (input == null || input == "") throw new IllegalArgumentException();

        Stack<Character> stack = new Stack();
        List<Character> leftBrackets = Arrays.asList('[', '(', '{', '<');
        List<Character> rightBrackets = Arrays.asList(']', ')', '}', '>');

        for (char ch : input.toCharArray()) {
            if (!stack.empty() && rightBrackets.contains(ch) && leftBrackets.indexOf(stack.peek()) == rightBrackets.indexOf(ch))
                stack.pop();
            else if (leftBrackets.contains(ch))
                stack.push(ch);
            else if (rightBrackets.contains(ch)) return false;
            }

        return stack.empty();
    }
}

//    public boolean isBalanced (String input) {
//        if (input == null || input == "") throw new IllegalArgumentException();
//
//        Stack stack = new Stack();
//        List<Character> allowedCharacters = Arrays.asList('[', ']', '(', ')', '{', '}', '<', '>');
//
//        for (char ch : input.toCharArray()) {
//            if (!stack.empty() && allowedCharacters.contains(ch) && stack.peek() == allowedCharacters.get(allowedCharacters.indexOf(ch) - 1))
//                stack.pop();
//            else if (allowedCharacters.contains(ch))
//                stack.push(ch);
//        }
//        return stack.empty();
//    }
//}