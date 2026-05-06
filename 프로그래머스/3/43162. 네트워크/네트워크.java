class Solution {
    // DFS??
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 방문 배열

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, visited, n);
            }
        }

        return answer;
    }

    private void dfs(int node, int[][] computers, boolean[] visited, int n) {
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited, n);
            }
        }
    }
}