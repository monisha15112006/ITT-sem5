import java.util.*;
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(
            (a, b) -> capital[a] - capital[b]
        );
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(
            (a, b) -> profits[b] - profits[a]
        );
        for (int i = 0; i < n; i++) {
            minCapitalHeap.add(i);
        }
        for (int j = 0; j < k; j++) {
            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= w) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            int bestProjectIndex = maxProfitHeap.poll();
            w += profits[bestProjectIndex];
        }
        
        return w;
    }
}
