class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        // Count frequencies of digits 0-9 for unmatched positions
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            char sChar = secret.charAt(i);
            char gChar = guess.charAt(i);
            
            if (sChar == gChar) {
                bulls++; // Perfect match
            } else {
                // If they don't match, record them in their respective buckets
                secretCounts[sChar - '0']++;
                guessCounts[gChar - '0']++;
            }
        }
        
        // Overlap of mismatched digits tells us exactly how many cows exist
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }
        
        return bulls + "A" + cows + "B";
    }
}
