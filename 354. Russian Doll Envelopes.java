import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        // 1. Sort by width ascending. If widths match, sort by height descending.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 2. Perform LIS on the heights using binary search
        int[] tails = new int[envelopes.length];
        int size = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int low = 0;
            int high = size;

            // Custom binary search to find insertion point
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tails[mid] < height) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            // Replace or append the height
            tails[low] = height;
            
            // If appended to the end, expand our active chain size
            if (low == size) {
                size++;
            }
        }

        return size;
    }
}
