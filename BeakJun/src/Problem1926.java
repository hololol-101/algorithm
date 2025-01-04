import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1926 {
    public static void main(String[] args) throws IOException {
        int r = readInt();
        int c = readInt();
        int [][]arr = new int[r+2][c+2];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                arr[i][j] = readInt();
            }
        }

        //test
        int answer = 0;
        int max = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (arr[i][j]==1) {
                    max = Math.max(max,dfs(arr, i, j));
                    answer++;
                }
            }
        }

        // output
        System.out.println(answer);
        System.out.println(max);
    }

    static int dfs(int[][]arr, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int result = 1;

        arr[i][j] = 0;
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(arr[x+1][y] == 1) {
                arr[x+1][y] = 0;
                q.add(new int[]{x+1, y});
                result++;
            }
            if(arr[x-1][y] == 1) {
                arr[x-1][y] = 0;
                q.add(new int[]{x-1, y});
                result++;
            }
            if(arr[x][y+1] == 1) {
                arr[x][y+1] = 0;
                q.add(new int[]{x, y+1});
                result++;
            }
            if(arr[x][y-1] == 1) {
                arr[x][y-1] = 0;
                q.add(new int[]{x, y-1});
                result++;
            }
        }
        return result;
    }
    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}
