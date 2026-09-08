#include <stdio.h>
#include <stdlib.h>


struct ListNode* swapPairs(struct ListNode* head) {
    // A pointer pointing to the address of the pointer we want to modify
    struct ListNode** pp = &head;
    
    // Ensure there are at least two nodes left to swap
    while (*pp && (*pp)->next) {
        struct ListNode* first = *pp;
        struct ListNode* second = first->next;
        
        // Rearrange pointers to execute the swap
        first->next = second->next;
        second->next = first;
        
        // Update the pointer that points to this pair
        *pp = second;
        
        // Step forward by moving the pointer-to-pointer to 'first->next'
        pp = &(first->next);
    }
    
    return head;
}
