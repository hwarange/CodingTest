import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(!stack.empty() && stack.peek() != s.charAt(i)){
                if(stack.size() == 1 && stack.peek() == ')') break;
                stack.pop();
                continue;
            }
            
            stack.push(s.charAt(i));
        }
        
        if(!stack.empty()) answer = false;

        return answer;
    }
}