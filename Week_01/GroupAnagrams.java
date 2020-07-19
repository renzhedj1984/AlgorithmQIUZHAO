import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> ls = anagrams.get(key);
            if (ls == null) {
                ls = new ArrayList<>();
                anagrams.put(key,ls);
            }
            ls.add(str);
        }
        for(Map.Entry<String,List<String>> entry : anagrams.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"ebt", "tbe", "int", "tni", "eebt"};
        new GroupAnagrams().groupAnagrams(strs);
        System.out.println();
    }
}
