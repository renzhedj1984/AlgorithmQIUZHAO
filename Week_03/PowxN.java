package week3;

public class PowxN {
    public double myPow(double x, int n) {
        //2*2*2*2*2 5
        //4*4*2
        //16*2

        //2*2*2*2*2*2 6
        //4*4*4
        //16*4
        if (n == 0) return 1.0;
        x = n > 0 ? x : 1 / x;
        n = n > 0 ? n : -n;
        return loop(x, n);
    }

    private double loop(double x, long n) {
        double rs = 1.0;
        double tmp = x;
        while (n > 0) {
            if (n % 2 == 1) rs *= tmp;
            tmp *= tmp;
            n /= 2;
        }
        return rs;
    }

    private double recursion(double x, long n) {
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            double m = recursion(x, n / 2);
            return m * m;
        } else {
            double m = recursion(x, (int) n / 2);
            return m * m * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PowxN().myPow(2.0, 10));
    }
}
