package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortedIterator implements Iterator<Integer> {

    private final List<Integer> mFlattenedList;
    private final Iterator<Integer> mIntegerIterator;

    SortedIterator(final List<List<Integer>> lists) {
        mFlattenedList = flattenLists(lists);
        mIntegerIterator = mFlattenedList.iterator();
    }

    private List<Integer> flattenLists(final List<List<Integer>> lists) {
        final List<Integer> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            for (int value : list) {
                result.add(value);
            }
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public boolean hasNext() {
        return mIntegerIterator.hasNext();
    }

    @Override
    public Integer next() {
        return mIntegerIterator.next();
    }
}
