package com.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedIteratorTest {

    @Test
    void hasNext_emptyListOfLists() {
        final SortedIterator sortedIterator = new SortedIterator(new ArrayList<>());
        assertFalse(sortedIterator.hasNext());
    }

    @Test
    void hasNext_listOfEmptyLists() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());

        final SortedIterator sortedIterator = new SortedIterator(new ArrayList<>());
        assertFalse(sortedIterator.hasNext());
    }

    @Test
    void hasNext_singleList() {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        lists.add(list);

        final SortedIterator sortedIterator = new SortedIterator(lists);
        assertTrue(sortedIterator.hasNext());
    }

    @Test
    void next_multipleNonEmptyLists() {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(14);

        lists.add(list1);
        lists.add(list2);

        final SortedIterator sortedIterator = new SortedIterator(lists);
        List<Integer> actual = new ArrayList<>();
        while (sortedIterator.hasNext()) {
            actual.add(sortedIterator.next());
        }

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(10);
        expected.add(14);
        expected.add(20);

        assertEquals(expected, actual);
    }

}