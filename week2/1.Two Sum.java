import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: [Number -> Its Index]
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // The exact matching twin we need
            
            // If we already saw the twin earlier, we found our pair!
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, remember this number and its position for later
            map.put(nums[i], i);
        }
        
        return new int[] {}; // Default empty array if no match is found
    }
}
