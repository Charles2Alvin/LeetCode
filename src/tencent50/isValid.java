package tencent50;

import java.util.HashMap;
import java.util.Stack;

class isValid {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                char top;
                if (!stack.isEmpty())
                    top = stack.pop();
                else return false;
                if (map.get(top) != s.charAt(i))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}