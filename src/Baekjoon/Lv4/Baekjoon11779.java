package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11779 {

    static int N, M, start, end;
    static List<ArrayList<Node>> graph;
    static int[] dist, prev;
    static boolean[] visited;

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        prev = new int[N + 1];
        visited = new boolean[N + 1];

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 최소 거리 정보를 담을 배열 초기화
        for (int i = 0; i <= N; i++) {
            // 출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        Dijkstra();

        // 경로 복원
        List<Integer> path = new ArrayList<>();

        for (int i = end; i != 0; i = prev[i]) {
            path.add(i);
        }

        Collections.reverse(path);

        sb.append(dist[end]).append("\n");
        sb.append(path.size()).append("\n");

        for (int node : path) {
            sb.append(node).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    private static void Dijkstra() {
        for (int i = 0; i < N; i++) {
            // 현재 거리 비용 중 최소인 지점 선택
            int nodeValue = Integer.MAX_VALUE;  // 해당 노드가 가지고 있는 현재 비용.
            int nodeIdx = 0;    // 해당 노드의 인덱스(번호).

            for (int j = 1; j <= N; j++) {
                // 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            // 최종 선택된 노드를 방문처리 함.
            visited[nodeIdx] = true;

            // 해당 지점을 기준으로 인접 노드의 최소 거리 값 갱신
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);   // 인접 노드 선택
                // 인접 노드가 현재 가지는 최소 비용과
                // 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신함.
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                    prev[adjNode.idx] = nodeIdx;    // 이전 노드의 인덱스를 저장.
                }
            }
        }
    }
}
