// Import your library
// Do not change the name of the Solution class
public class Solution {

    public static long fibonacci(long n) {
      if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long f0 = 0;
        long f1 = 1;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            
            if (Long.MAX_VALUE - f1 < f0) {
                return Long.MAX_VALUE;
            }
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }

        return fn;
    }
} 
