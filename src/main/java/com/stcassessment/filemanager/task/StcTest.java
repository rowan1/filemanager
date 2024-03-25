package com.stcassessment.filemanager.task;

import java.util.Stack;

public class StcTest {
  public String reverseParentheses(String s) {
    return reverseParenthesis(s);
  }
  public static String reverseParenthesis(String str){
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(ch != ')'){
        stack.push(ch);
        continue;
      }
      StringBuilder textToBeReversed = new StringBuilder();
      while (!stack.isEmpty() && stack.peek() != '('){
        textToBeReversed.append(stack.pop());
      }
      if(!stack.isEmpty()){
        stack.pop();
      }
      if(textToBeReversed.length() > 0){
        for (int j = 0; j < textToBeReversed.length(); j++) {
          stack.push(textToBeReversed.charAt(j));
        }
      }
    }
    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()){
      res.append(stack.pop());
    }
    return res.reverse().toString();
  }

  public static void main(String args[]){
    StcTest test = new StcTest();

    System.out.println("Input: abd(jnb)asdf, output: "+test.reverseParentheses("abd(jnb)asdf"));
    System.out.println("Input: abdjnbasdf, output: "+test.reverseParentheses("abdjnbasdf"));
    System.out.println("Input: dd(df)a(ghhh), output: "+test.reverseParentheses("dd(df)a(ghhh)"));
  }
}