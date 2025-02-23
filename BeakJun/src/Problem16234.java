import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class Problem16234 {
    private static int n;
    private static int r;
    private static int l;
    private static int[][] arr;
    private static boolean[][] visited;
    private static LinkedList<int[]> list;
    public static void main(String[] args) throws IOException {
        n = readInt();
        l = readInt();
        r = readInt();

        arr = new int[n][n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = readInt();
            }
        }

        boolean changed = false;
        do{
            visited = new boolean[n][n];
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        boolean rt = solution(i,j);

                        if(!changed && rt){
                            changed = true;
                            ans++;
                        }
                    }
                }
            }

        }while(changed);


        System.out.println(ans);
    }

    static boolean solution(int ix, int iy) {
        int sum = arr[ix][iy];
        list = new LinkedList<>();
        list.add(new int[]{ix, iy});
        visited[ix][iy] = true;

        for(int i=0; i<list.size(); i++){
            int tx = list.get(i)[0];
            int ty = list.get(i)[1];
            int diff = 0;
            if(tx+1<n){
                if(!visited[tx+1][ty]) {
                    diff = Math.abs(arr[tx][ty] - arr[tx + 1][ty]);
                    if (diff >= l && diff <= r) {
                        sum += arr[tx + 1][ty];
                        visited[tx + 1][ty] = true;
                        list.add(new int[]{tx + 1, ty});
                    }
                }
            }
            if(tx-1>=0){
                if(!visited[tx-1][ty]) {
                    diff = Math.abs(arr[tx][ty] - arr[tx - 1][ty]);
                    if (diff >= l && diff <= r) {
                        sum += arr[tx - 1][ty];
                        visited[tx - 1][ty] = true;
                        list.add(new int[]{tx - 1, ty});
                    }
                }
            }

            if(ty+1<n){
                if(!visited[tx][ty+1]) {
                    diff = Math.abs(arr[tx][ty]-arr[tx][ty+1]);
                    if(diff>=l && diff<=r){
                        sum += arr[tx][ty+1];
                        visited[tx][ty+1] = true;
                        list.add(new int[]{tx, ty+1});
                    }
                }
            }
            if(ty-1>=0){
                if(!visited[tx][ty-1]) {
                    diff = Math.abs(arr[tx][ty]-arr[tx][ty-1]);
                    if(diff>=l && diff<=r){
                        sum += arr[tx][ty-1];
                        visited[tx][ty-1] = true;
                        list.add(new int[]{tx, ty-1});
                    }
                }
            }
        }

        if(list.size()==1){
            return false;
        }
        else{
            for(int i=0; i<list.size(); i++){
                int[] t = list.get(i);
                arr[t[0]][t[1]] = (int)(sum / list.size());
            }
            return true;
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
