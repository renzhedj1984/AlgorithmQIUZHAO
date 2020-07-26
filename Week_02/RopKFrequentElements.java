package week2;

import java.util.*;

public class RopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> frequencyMap.get(o2) - frequencyMap.get(o1));
        for (int key : frequencyMap.keySet()) {
            priorityQueue.add(key);
        }
        while (k > 0) {
            res.add(priorityQueue.poll());
            k--;
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        new RopKFrequentElements().topKFrequent(new int[]{1, 2, 2, 3}, 3);
    }
}
