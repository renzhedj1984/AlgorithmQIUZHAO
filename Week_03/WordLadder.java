package week3;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    private int stepLen = 0;
    private List<String> wordList;
    private String endWord;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return stepLen;
        this.wordList = wordList;
        this.endWord = endWord;
        recursion(beginWord, new ArrayList());
        return stepLen;
    }

    /**
     * 深度优先算法貌似不行，不是该题目的正解
     * @param word
     * @param stepList
     */
    private void recursion(String word, ArrayList<String> stepList) {
        if (word.equals(this.endWord)) {
            //完成一次转换
            if (stepLen == 0)
                stepLen = stepList.size() + 1;
            else
                stepLen = Math.min(stepLen, stepList.size() + 1);
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            String target = wordList.get(i);
            if (!stepList.contains(target) && isChangeOneWord(word, target)) {
                stepList.add(target);
                recursion(target, stepList);
                stepList.remove(target);
            }
        }
    }

    private boolean isChangeOneWord(String word, String target) {
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i))
                count--;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        new WordLadder().ladderLength("hit", "cog", wordList);
    }
}
