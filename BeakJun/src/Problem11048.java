import java.io.*;

public class Problem11048 {
    public static void main(String[] args) throws IOException {
        int row = readInt();
        int col = readInt();
        int[][]map = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                map[i][j] = readInt();
            }
        }

        //test
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                map[i][j] += Math.max(Math.max(map[i-1][j-1], map[i-1][j]), map[i][j-1]);


            }
        }
        // output
        System.out.println(map[row][col]);

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}
