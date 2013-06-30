import java.io.*;

public class Solution {

  public static int matrix(int i, int j)// length i, start from j
	{

		if (i == 1)
			return 1;
		int sum = 0;
		while (j <= 25) {
			sum += matrix(i - 1, j);
			j++;
		}

		return sum;

	}

	public static int numberatlen(int n) {
		int sum = 0;
		for (int i = 25; i >= 0; i--) {
			sum += matrix(n, i);
		}
		return sum;
	}

	public static int callen(int n) {
		int len = 1;

		while (n >= 0) {
			n -= numberatlen(len);
			len++;
		}
		return len - 1;
	}

	public static void tostring(int a) {

		int aa = a;
		int len = callen(aa);

		String s = "";

		int temp = aa;

		while (aa >= 0) {

			temp = aa;
			int index = 0;

			if (temp <= 25) {
				if (!s.isEmpty()) {
					s += (char) (s.charAt(s.length() - 1) + temp);
					len--;
					aa = 0;
					break;
				} else {
					s += (char) ('a' + temp);
					break;
				}
			}

			int sumprevious = 0;
			for (int i = 1; i < len; i++) {
				sumprevious += numberatlen(i);
				temp -= numberatlen(i) - 1;
			}
			while (temp > 0) {
				temp -= matrix(len, index);
				index++;
			}
			index--;
			if (temp == 0) {
				s += (char) ('a' + index);

				while (index > 0) {
					aa = aa - (matrix(len, index - 1));
					index--;
				}

				aa = aa - sumprevious + (sumprevious - numberatlen(len - 1));

				len--;
				continue;
			}

			s += (char) ('a' + index);

			while (index > 0) {
				aa = aa - (matrix(len, index - 1));
				index--;
			}

			aa = aa - sumprevious + sumprevious - numberatlen(len - 1);

			len--;

		}

		System.out.println(s);

	}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		 BufferedReader br = new BufferedReader(new
		 InputStreamReader(System.in)); String line = br.readLine(); int
		 current = Integer.parseInt(line); 
		 while (line != null) 
		 {
		 tostring(current); 
		 line = br.readLine(); 
		 current = Integer.parseInt(line);
		 }
		 
	}
}
