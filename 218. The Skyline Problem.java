import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> bPoints = new ArrayList<>();

        // 1. Convert buildings into critical start/end event points
        for (int[] b : buildings) {
            // Start point: represented with negative height to distinguish it
            bPoints.add(new int[]{b[0], -b[2]});
            // End point: represented with positive height
            bPoints.add(new int[]{b[1], b[2]});
        }

        // 2. Sort the points based on specific sweep-line rules
        Collections.sort(bPoints, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // Sort by x-coordinate ascending
            }
            // If x-coordinates are identical, apply tie-breaking rules:
            // - Two starts: taller building first (negative heights -> smaller number first)
            // - Two ends: shorter building first (positive heights -> smaller number first)
            // - One start, one end: start point first (negative height comes before positive)
            return a[1] - b[1];
        });

        // 3. Use a TreeMap as a Max-Heap to track active heights and their frequencies
        // Key: Height, Value: Count of buildings currently at this height
        TreeMap<Integer, Integer> mq = new TreeMap<>();
        mq.put(0, 1); // Initialize with ground height 0

        int prevMaxHeight = 0;

        // 4. Sweep across all processed critical points
        for (int[] point : bPoints) {
            int x = point[0];
            int height = point[1];

            if (height < 0) { 
                // It's a start point; add/increment the height in our active tracker
                mq.put(-height, mq.getOrDefault(-height, 0) + 1);
            } else { 
                // It's an end point; decrement/remove the height from our active tracker
                int count = mq.get(height);
                if (count == 1) {
                    mq.remove(height);
                } else {
                    mq.put(height, count - 1);
                }
            }

            // Get the current max height among all active buildings
            int currentMaxHeight = mq.lastKey();

            // If the max height changes, we found a critical skyline contour point
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}
