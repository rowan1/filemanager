package com.stcassessment.filemanager.task;

import java.util.Stack;

public class StcTest {
  public String reverseParentheses(String s) {
    return reverseParenthesis(s);
  }
  public static String reverseParenthesis(String str){
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      //if it's not a closing parenthesis push it to stack
      char ch = str.charAt(i);
      if(ch != ')'){
        stack.push(ch);
        continue;
      }
      //when ever we get a closing bracket
      //pop out all the elements until we get opening
      StringBuilder textToBeReversed = new StringBuilder();
      while (!stack.isEmpty() && stack.peek() != '('){
        textToBeReversed.append(stack.pop());
      }
      if(!stack.isEmpty()){
        stack.pop();
      }
      if(textToBeReversed.length() > 0){
        //push the character back to stack
        //one by one
        for (int j = 0; j < textToBeReversed.length(); j++) {
          stack.push(textToBeReversed.charAt(j));
        }
      }
    }
    //now pop out all the characters from stack
    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()){
      res.append(stack.pop());
    }
    return res.reverse().toString();
  }

  public static void main(String args[]){
    StcTest test = new StcTest();

    System.out.println("Input: (abcd), output: "+test.reverseParentheses("(abcd)"));
    System.out.println("Input: (u(love)i), output: "+test.reverseParentheses("(u(love)i)"));
    System.out.println("Input: (ed(et(oc))el), output: "+test.reverseParentheses("(ed(et(oc))el)"));
  }
}


// Query
//  select users.user_id, users.user_name, training_details.training_id, training_details.training_date, COUNT(users.user_id) as count from users inner join training_details
//        on users.user_id = training_details.user_id group by(users.user_id,training_details.training_id, training_details.training_date) HAVING COUNT(users.user_id) > 1 order by (training_details.training_date) desc;

// user_id |  user_name  | training_id | training_date | count
//       ---------+-------------+-------------+---------------+-------
//       4 | Lisa Romero |           2 | 2015-08-04    |     2
//       4 | Lisa Romero |           3 | 2015-08-03    |     2
//       1 | John Doe    |           1 | 2015-08-02    |     3
//       3 | Alice Jones |           2 | 2015-08-02    |     2
