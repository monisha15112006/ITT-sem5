import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        // Push all digits of list 1 into stack 1
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        // Push all digits of list 2 into stack 2
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode head = null;
        int carry = 0;
        
        // Pop elements from the stacks to add from right to left
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int val1 = !s1.isEmpty() ? s1.pop() : 0;
            int val2 = !s2.isEmpty() ? s2.pop() : 0;
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            // Build the result list backwards (inserting at the head)
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
        }
        
        return head;
    }
}
