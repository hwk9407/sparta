package algorithm.practice001;

import java.util.Stack;

public class Practice001 {

    /**
     * 그래프의 모든 노드 방문하기<br>
     * DFS 문제<br>
     * 첫 번째 줄 : 정점의 개수 1<=N<=100<br>
     * 두 번째 줄 : 간선의 개수 0<=M<=100<br>
     * 다음 M 줄 : 각 전선에 대한 두 정수 u,v (1<= u, v<=N)
     */
    public static void main(String[] args) {
        int N = 5;
        int M = 4;
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}};
        StringBuilder sb = new StringBuilder();

        sb.append(edges[0][0]);
        Stack<Integer> stack = new Stack<>();
        Stack<boolean[]> visited = new Stack<>();
        stack.push(edges[0][0]);
        visited.push(new boolean[edges.length]);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            boolean[] visitFlag = visited.pop();
            for (int i = 0; i < edges.length; i++) {
                if (!visitFlag[i] && edges[i][0] == current) {
                    visitFlag[i] = true;
                    stack.push(edges[i][1]);
                    visited.push(visitFlag.clone());
                    sb.append(" ").append(edges[i][1]);

                    visitFlag[i] = false;
                }

            }
        }
        sb.trimToSize();
        System.out.println(sb);
    }
}
