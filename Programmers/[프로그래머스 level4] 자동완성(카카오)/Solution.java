import java.util.*;

class Solution {
    static TrieNode rootNode;

    static class TrieNode{
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastNode;

    }

    public void insert(String word){
        TrieNode thisNode = rootNode;

        for(int i = 0; i<word.length(); i++){
            thisNode = thisNode.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        thisNode.isLastNode = true;
    }

    public int check(String word){
        TrieNode thisNode = rootNode;
        int result = 1;
        for(int i = 0; i<word.length(); i++){
            thisNode = thisNode.childNodes.get(word.charAt(i));
            if(thisNode.childNodes.size() > 1){
                result = i+2;
            }
            if(thisNode.isLastNode && i != word.length() - 1){
                result = i+2;
            }

            if(i == word.length() - 1 && !thisNode.childNodes.isEmpty()){
                result = word.length();
            }

        }
        return result;
    }
    public int solution(String[] words) {
        int answer = 0;
        rootNode = new TrieNode();
        for(String word : words){
            insert(word);
        }

        for(String word : words){
            answer += check(word);
        }
        return answer;
    }
}