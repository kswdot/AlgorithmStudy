import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        M = Integer.parseInt(st.nextToken());  

        tree = new int[N]; 

        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > maxHeight) {
                maxHeight = tree[i];
            }
        }

        // 이진 탐색
        int low = 0, high = maxHeight;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long wood = 0;

           
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    wood += tree[i] - mid;
                }
            }

           
            if (wood >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}