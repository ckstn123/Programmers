import java.util.*;
//길 찾기 게임
class Solution {

    class Node {
        Node(int id, int x, int y){
            this.id = id;
            this.x = x;
            this.y = y;
        }
        int id;
        int x,y;
        Node left;
        Node right;
    };

    void addNode(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null)
                parent.left = child;
            else
                addNode(parent.left, child);
        }
        else {
            if(parent.right == null)
                parent.right = child;
            else
                addNode(parent.right, child);
        }
    }
    List<Node> Nodes = new ArrayList<Node>();
    int index = 0;
    Comparator<Node> comp = new Comparator<Node>(){
        public int compare(Node a, Node b){
            if(a.y == b.y)
                return a.x - b.x;
            return b.y - a.y;
        }
    };

    public void preorder(int[][] answer, Node node) {
        if(node == null)
            return;
        answer[0][index++] = node.id;
        preorder(answer, node.left);
        preorder(answer, node.right);

    }

    public void postorder(int[][] answer, Node node) {
        if(node == null)
            return;

        postorder(answer, node.left);
        postorder(answer, node.right);
        answer[1][index++] = node.id;
    }

    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;
        for(int i = 0; i<size; i++){
            Nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Nodes.sort(comp);
        Node root = Nodes.get(0);
        for(int i = 1; i<size; i++){
            addNode(root,Nodes.get(i));
        }
        int[][] answer = new int[2][size];
        preorder(answer, root);
        index = 0;
        postorder(answer, root);
        return answer;
    }
}