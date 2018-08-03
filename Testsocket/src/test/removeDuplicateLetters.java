package test;



import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class removeDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        int[] count = new int[256];
        Boolean[] visited = new Boolean[256];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }

        char[] cList = s.toCharArray();
        for (char cc : cList
                ) {
            count[cc]++;
        }

        String res = "";
        Stack<Character> stack = new Stack<>();
//        Queue<Character> queue = new PriorityQueue<>();
        //遍历
        for (char c : cList
                ) {
            count[c]--;
            //若已经遍历过，则跳过

            if(visited[c]) {
                continue;
            }

            if (!stack.isEmpty()){
                //若当前遍历字符比字符串尾部的字符小，而且未遍历的字符串中还有这个字符，则弹出
                //Character peek = stack.peek();
                while (!stack.isEmpty() && c < stack.peek() && count[stack.peek()] != 0) {
                    visited[stack.peek()] = false;
                    stack.pop();

                }
            }


            stack.push(c);
            visited[c] = true;
        }

        for (char ss : stack
             ) {
            res += ss;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(s.length());
        removeDuplicateLetters removeDuplicateLetters = new removeDuplicateLetters();
        String s1 = removeDuplicateLetters.removeDuplicateLetters(s);
        System.out.println(s1);
    }

}
