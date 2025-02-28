import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Problem14502 {
    static int row = 0;
    static int col = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        row = readInt();
        col = readInt();
        map = new int[row][col];
        int ans = Integer.MIN_VALUE;
        int wall = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = readInt();
                if(map[i][j] == 1) {
                    wall++;
                }
            }
        }

        for (int i = 0; i < row*col; i++) {
            if(map[i/col][i%col] == 0) {
                //첫번째 벽 세우기
                map[i/col][i%col] = 1;

                for (int j = i+1; j < row*col; j++) {
                    if(map[j/col][j%col] == 0) {
                        //두번째 벽 세우기
                        map[j/col][j%col] = 1;

                        for (int k = j+1; k < row*col; k++) {
                            if(map[k/col][k%col] == 0) {
                                //세번째 벽 세우기
                                map[k/col][k%col] = 1;

                                //안전지대 구하기
                                ans = Math.max(ans, getVirus());

                                //세번째 벽 허물기
                                map[k/col][k%col] = 0;
                            }else{
                                continue;
                            }
                        }
                        //두번째 벽 허물기
                        map[j/col][j%col] = 0;
                    }

                }
                //첫번째 벽 허물기
                map[i/col][i%col] = 0;
            }
        }
        System.out.println(ans);
    }

    static int getVirus() {
        boolean [][]visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == 2) {
                    dfs(visited, i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
    static void dfs(boolean[][] visited, int x, int y) {
        if(x<0 || x>=row || y<0 || y>=col || map[x][y] == 1 || visited[x][y]) {
            return;
        }
        if(map[x][y] != 1 && !visited[x][y]) {
            visited[x][y] = true;
            dfs(visited, x-1, y);
            dfs(visited, x+1, y);
            dfs(visited, x, y-1);
            dfs(visited, x, y+1);

        }
    }
    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }

}
