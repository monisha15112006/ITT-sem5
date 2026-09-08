#include <stdio.h>

double myPow(double x, int n) {
    // Cast to long long to safely handle the INT_MIN overflow edge case
    long long N = n;
    
    // Handle negative exponents: x^(-N) = (1/x)^N
    if (N < 0) {
        x = 1.0 / x;
        N = -N;
    }
    
    double result = 1.0;
    double current_product = x;
    
    // Binary Exponentiation Loop
    while (N > 0) {
        // If N is odd, multiply the current product into the result
        if (N % 2 == 1) {
            result *= current_product;
        }
        // Square the base and halve the exponent
        current_product *= current_product;
        N /= 2;
    }
    
    return result;
}
