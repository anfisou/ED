public class ED195 {
    public static boolean balanced(String s){
        MyStack<Character> stack = new LinkedListStack<Character>();
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')'){
                if (stack.size() <= 0){return false;}
                else if (stack.top() == '('){stack.pop();}
                else{return false;}
            }
            else if (s.charAt(i) == ']'){
                if (stack.size() <= 0){return false;}
                else if (stack.top() == '['){stack.pop();}
                else{return false;}
            }
        }
        if (stack.size() != 0){return false;}
        return true;
    }    
}
