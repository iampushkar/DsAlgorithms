class Solution {
    public boolean primeSubOperation(int[] nums) {
        int prev = 0;

        for (int n : nums) {
            int upperBound = n - prev;
            int largestPrime = 0;

            for (int p=upperBound-1; p>=2; p--) {
                if (isPrime(p)) {
                    largestPrime = p;
                    break;
                }
            }

            if (n - largestPrime <= prev) {
                return false;
            }
            prev = n - largestPrime;
        }

        return true;
    }

    private boolean isPrime(int n) {
        int upperFact = (int) Math.sqrt(n) + 1;
        for (int f=2; f < upperFact; f++) {
            if (n % f == 0) {
                return false;
            }
        }
        return true;
    }
}