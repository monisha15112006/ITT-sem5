import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        // Step 1: Find the last visible index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Track if a character is currently in our result stack
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        // Step 3: Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            // If we already used this character in its optimal position, skip it
            if (seen[idx]) continue;
            
            // Pop larger characters if they appear again later
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            
            // Add current character to stack and mark as seen
            stack.push(c);
            seen[idx] = true;
        }
        
        // Step 4: Build the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
