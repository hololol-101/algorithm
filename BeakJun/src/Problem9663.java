import java.io.*;
import java.util.HashSet;

public class Problem9663 {
    static int n;
    static boolean [] checkColSide;
    static boolean [] checkLeftSide;
    static boolean [] checkRightSide;
    static int offset = 0;

    public static void main(String[] args) throws IOException {

        //input 2 - 숫자와 스페이스, 엔터로만 이루어져 있을때
        n = readInt();
        checkColSide = new boolean[n];
        checkLeftSide = new boolean[2*n+1];
        checkRightSide = new boolean[2*n+1];
        offset = n+1;

        int result = queen( 0);

        System.out.println(result);
    }

    static int queen(int row){
        if(row==n){
            return 1;
        }
        int result = 0;
        for(int col=0; col<n; col++) {
            if( checkColSide[col] || checkLeftSide[row+col] || checkRightSide[col-row+n+1]){
                continue;
            }
            checkColSide[col]=true;
            checkLeftSide[row+col]=true;
            checkRightSide[offset + col-row]=true;

            result += queen(row+1);

            checkColSide[col]=false;
            checkLeftSide[row+col]=false;
            checkRightSide[offset + col-row]=false;

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
