public class asn1_a {
	public static void main(String args[]) {
		for (int i = 0; i < 11; i++) {
			System.out.println("F(" + i + ")" + " " + "is:" + " " + fib((i * 5) + 1, 0, 1));
		}
	}

	public static long fib(long n, long val, long prev) {
		if (n == 0) {
			return prev;
		}
		if (n == 1) {
			return val;
		}
		return fib(n - 1, prev, val + prev);
	}

}
