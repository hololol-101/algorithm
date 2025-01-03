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

        boolean[][] visited = new boolean[r+2][c+2];

        //test
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (visited[i][j] == true) {
                    dfs(arr, visited, i, j);
                }
            }
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append("");
        bw.flush();
        bw.close();

    }

    static boolean dfs(int[][]arr, boolean[][] visited, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(arr[cur[0]+1][cur[1]] == 1 && !visited[cur[0]+1][cur[1]]) {}
            if(arr[cur[0]-1][cur[1]] == 1 ) {}
            if(arr[cur[0]][cur[1]+1] == 1){}
            if(arr[cur[0]][cur[1]-1] == 1){}
        }
        return true;
    }
    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}
