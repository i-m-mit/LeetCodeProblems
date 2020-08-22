package HashTable;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimesV1(int n) {
        boolean[] isNotPrime = new boolean[n];
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (isNotPrime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                isNotPrime[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes o = new CountPrimes();
        System.out.println(o.countPrimesV1(10));
    }
}