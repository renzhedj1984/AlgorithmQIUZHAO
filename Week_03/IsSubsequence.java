package week3;

public class IsSubsequence {
    public boolean solution(String s, String t) {
        int i = 0, j = 0;
        int finds = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                finds++;
                i++;
            }
            j++;
        }
        return finds == s.length();
    }

    public static void main(String[] args) {

    }
}
