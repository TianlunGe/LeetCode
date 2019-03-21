package leet.easy;

public class Leet374GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		if (guess(n) > 0) {
			return n;
		}
		if (guess(1) < 0) {
			return 1;
		}
		long lo = 1;
		long hi = n;
		long g = (1 + n) / 2;
		int res = guess((int) g);
		while (res != 0) {
			if (res > 0) {
				lo = g + 1;
			} else {
				hi = g - 1;
			}
			g = (lo + hi) / 2;
			res = guess((int) g);
		}
		return (int) g;
	}

	private int guess(int n) {
		if (n < 1702766719) {
			return 1;
		} else if (n > 1702766719) {
			return -1;
		} else {
			return 0;
		}
	}
}
