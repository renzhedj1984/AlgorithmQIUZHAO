package week3;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> map = new HashMap();

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        initMap();
        backTrace(0, 0, digits, new StringBuilder());
        return res;
    }

    private void backTrace(int out, int inner, String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = out; i < digits.length(); i++) {
            String words = map.get(digits.charAt(i));
            for (int j = 0; j < words.length(); j++) {
                sb.append(words.charAt(j));
                backTrace(i + 1, j, digits, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void initMap() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }
}
