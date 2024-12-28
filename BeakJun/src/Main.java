import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		br.close();

		//input 2 - 숫자와 스페이스, 엔터로만 이루어져 있을때
		readInt();


		//test	
				
		// output 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("");
		bw.flush();
		bw.close();

	}

	static int readInt() throws IOException {

		int c, n = System.in.read() & 15;

		boolean isNegative = n == 13;
		if (isNegative) n = System.in.read() & 15;

		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

		return isNegative ? ~n + 1 : n;

	}
}
