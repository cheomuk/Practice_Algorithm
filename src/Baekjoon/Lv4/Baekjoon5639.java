package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon5639 {

    static List<Integer> preorder = new ArrayList<>();

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            preorder.add(Integer.parseInt(line));
        }

        Node root = constructBST(0, preorder.size() - 1);
        postOrder(root);

        br.close();
    }

    static Node constructBST(int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(preorder.get(start));
        int i;

        for (i = start + 1; i <= end; i++) {
            if (preorder.get(i) > node.data) break;
        }

        node.left = constructBST(start + 1, i - 1);
        node.right = constructBST(i, end);

        return node;
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.println(node.data);
    }
}
