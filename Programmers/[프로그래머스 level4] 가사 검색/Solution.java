import java.util.HashMap;
import java.util.Map;

class Solution {

    static TrieNode[] front;
    static TrieNode[] back;

    static class TrieNode{
        private Map<Character, TrieNode> chileNodes = new HashMap<>();
        private boolean isLastNode;
        int count = 0;

        Map<Character, TrieNode> getChileNode(){
            return this.chileNodes;
        }
        boolean getIsLastNode(){
            return this.isLastNode;
        }

        void setIsLastNode(boolean isLastNode){
            this.isLastNode = isLastNode;
        }
    }
    static void insert(String word){
        insertFront(word);
        insertBack(word);
    }
    static void insertFront(String word){
        TrieNode thisNode = front[word.length()];
        for(int i = 0; i<word.length(); i++){
            thisNode.count++;
            thisNode = thisNode.getChileNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastNode(true);
    }

    static void insertBack(String word){
        TrieNode thisNode = back[word.length()];
        for(int i = word.length()-1; i>=0; i--){
            thisNode.count++;
            thisNode = thisNode.getChileNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastNode(true);
    }

    static int contains(String query){
        if (query.charAt(0) == '?')
            return containsBack(query);
        return containsFront(query);
    }

    static int containsFront(String query){
        TrieNode thisNode = front[query.length()];
        if(thisNode == null)
            return 0;
        for(int i = 0; i<query.length(); i++){
            if(query.charAt(i) == '?')
                break;
            if(!thisNode.getChileNode().containsKey(query.charAt(i)))
                return 0;
            thisNode = thisNode.getChileNode().get(query.charAt(i));
        }
        return thisNode.count;
    }

    static int containsBack(String query){
        TrieNode thisNode = back[query.length()];
        if(thisNode == null)
            return 0;
        for(int i = query.length()-1; i>=0; i--){
            if(query.charAt(i) == '?')
                break;
            if(!thisNode.getChileNode().containsKey(query.charAt(i)))
                return 0;
            thisNode = thisNode.getChileNode().get(query.charAt(i));
        }
        return thisNode.count;
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        front = new TrieNode[10001];
        back = new TrieNode[10001];

        for(String word : words){
            int len = word.length();
            if(front[len] == null)
                front[len] = new TrieNode();
            if(back[len] == null)
                back[len] = new TrieNode();
            insert(word);
        }

        for(int i = 0; i<queries.length; i++){
            int len = queries[i].length();

            answer[i] = contains(queries[i]);
            System.out.println(answer[i]);
        }
        return answer;
    }
}