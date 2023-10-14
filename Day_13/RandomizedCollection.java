package Day_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> idxMap;
    private Random random;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean response = !idxMap.containsKey(val);

        if (response) {
            idxMap.put(val, new HashSet<>());
        }
        idxMap.get(val).add(nums.size());
        nums.add(val);

        return response;
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }

        Set<Integer> idxSet = idxMap.get(val);
        int idxToBeRemoved = idxSet.iterator().next();
        if (idxSet.size() == 1) {
            idxMap.remove(val);
        } else {
            idxSet.remove(idxToBeRemoved);
        }

        int lastIdx = nums.size() - 1;
        if (idxToBeRemoved != lastIdx) {
            int lastVal = nums.get(lastIdx);
            Set<Integer> lastIdxSet = idxMap.get(lastVal);
            lastIdxSet.add(idxToBeRemoved);
            lastIdxSet.remove(lastIdx);
            nums.set(idxToBeRemoved, lastVal);
        }

        nums.remove(lastIdx);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1)); // true
        System.out.println(collection.insert(1)); // false
        System.out.println(collection.insert(2)); // true
        System.out.println(collection.getRandom()); // 1 or 2 (random)
        System.out.println(collection.remove(1)); // true
        System.out.println(collection.getRandom()); // 1 or 2 (random)
    }
}
