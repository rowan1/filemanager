package com.stcassessment.filemanager.task;

public class ReverseWithinParentheses {

  public String reverseParentheses(String input){
    StringBuilder output = new StringBuilder();
    StringBuilder toBeReversed = new StringBuilder();
    boolean withinParentheses = false;

    for (char c : input.toCharArray()) {
      if (c == '(') {
        withinParentheses = true;
        output.append(c);
      } else if (c == ')') {
        withinParentheses = false;
        output.append(toBeReversed.reverse());
        output.append(c);
        toBeReversed = new StringBuilder();
      } else {
        if (withinParentheses) {
          toBeReversed.append(c);
        } else {
          output.append(c);
        }
      }
    }
    return output.toString();
  }
  public static void main(String args[]){
    ReverseWithinParentheses test = new ReverseWithinParentheses();

    System.out.println("Input: abd(jnb)asdf, Output: "+test.reverseParentheses("abd(jnb)asdf"));
    System.out.println("Input: abdjnbasdf, Output: "+test.reverseParentheses("abdjnbasdf"));
    System.out.println("Input: dd(df)a(ghhh), Output: "+test.reverseParentheses("dd(df)a(ghhh)"));
  }
}