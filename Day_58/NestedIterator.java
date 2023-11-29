import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    // public NestedInteger();

    // Constructor initializes a single integer.
    // public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    // public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    // public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    private LinkedList<Integer> flattenedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenedList = new LinkedList<>();
        flattenNestedList(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return flattenedList.poll();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return !flattenedList.isEmpty();
    }

    private void flattenNestedList(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                flattenedList.add(ni.getInteger());
            } else {
                flattenNestedList(ni.getList());
            }
        }
    }
}
