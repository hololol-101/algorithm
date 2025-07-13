import java.io.IOException;

public class Problem11724 {

    public static void main(String[] args) throws IOException {
        int size = readInt();
        int lines = readInt();
        int []arr = new int[size+1];
        int answer = 0;
        int cnt = 0;
        for( int i=0; i<lines; i++ ) {
            int h = readInt();
            int t = readInt();

            if(arr[h]==0&&arr[t]==0) {
                answer++;
                cnt++;
                arr[h] = cnt;
                arr[t] = cnt;
            }else if (arr[h]!=0 && arr[t]==0) {
                arr[t] = arr[h];
            }else if (arr[h]==0 && arr[t]!=0) {
                arr[h] = arr[t];
            }else{
                if (arr[h]!=arr[t]){
                    answer--;
                    int min = Math.min(arr[h],arr[t]);
                    int max = Math.max(arr[h],arr[t]);
                    for(int j=0; j<arr.length; j++) {
                        if(arr[j]==max){
                            arr[j]=min;
                        }
                    }
                }
            }
        }

        for(int j=1; j<arr.length; j++) {
            if(arr[j]==0) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    static int readInt() throws IOException {

        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n;

    }
}
