import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 지방의 수
        int[] requests = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long maxRequest = 0;
        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            maxRequest = Math.max(maxRequest, requests[i]);
        }
        
        long totalBudget = Long.parseLong(br.readLine()); // 총 예산
        
        long low = 0;
        long high = maxRequest;
        long answer = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2; // 현재 설정한 상한액
            long currentSum = 0;
            
            for (int req : requests) {
                if (req > mid) currentSum += mid;
                else currentSum += req;
            }
            
            if (currentSum <= totalBudget) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}