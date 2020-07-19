import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char [] arrayA = s.toCharArray();
        char [] arrayB = t.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        return Arrays.equals(arrayA,arrayB);
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("abcd","bca"));
    }
}
