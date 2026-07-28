import java.util.*;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        
        for (String word : words) {
            // An empty string cannot be a concatenated word
            if (word.isEmpty()) continue; 
            
            // Temporarily remove to avoid the word matching itself
            wordSet.remove(word); 
            
            // Check if it can be formed by the remaining words
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            
            // Restore it back to the set
            wordSet.add(word); 
        }
        
        return result;
    }
    
    private boolean canForm(String word, Set<String> wordSet) {
        int n = word.length();
        if (n == 0) return false;
        
        // dp[i] represents if the prefix of length i can be formed
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: empty string
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If the left segment is valid and the right segment is a dictionary word
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a valid split for length i
                }
            }
        }
        
        return dp[n];
    }
}
