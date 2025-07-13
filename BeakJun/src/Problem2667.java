import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Problem2667 {
    private static int size = 0;
    private static boolean [][]map;


    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new boolean[size][size];

        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            char []tmp = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                if(tmp[j] == '1'){
                    map[i][j] = true;
                }
            }
        }
        br.close();


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == true){
                   arrList.add(bfs(i,j));
                }
            }
        }

        Collections.sort(arrList);
        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(arrList.size() + "\n");
        for (int i = 0; i < arrList.size(); i++) {
            bw.append(arrList.get(i) + "\n");
        }
        bw.flush();
        bw.close();



    }

    public static int bfs(int x, int y){
        int []ix = {0, 0, 1, -1};
        int []iy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        q.add(new int[]{x, y});
        count++;
        map[x][y] = false;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++){
                int nx = cur[0] + ix[k];
                int ny = cur[1] + iy[k];
                if(nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }
                if(map[nx][ny] == true){
                    q.add(new int[]{nx, ny});
                    count++;
                    map[nx][ny] = false;

                }
            }

        }
        return count;
    }
}
