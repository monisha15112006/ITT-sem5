#include <stdbool.h>

int lastRemaining(int n) {
    int head = 1;
    int step = 1;
    int remaining = n;
    bool left_to_right = true;

    // Continue eliminating until only one element is left
    while (remaining > 1) {
        // Condition where the head gets eliminated and must move forward
        if (left_to_right || (remaining % 2 == 1)) {
            head += step;
        }

        // Each round cuts the remaining numbers in half
        remaining /= 2;
        // The step distance doubles every single round
        step *= 2;
        // Flip the direction for the next turn
        left_to_right = !left_to_right;
    }

    return head;
}
