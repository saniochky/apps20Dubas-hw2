package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAddMethod() {
        String[] arr = {"aaa", "aaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaaaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.add(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddMethodWithEmptyList() {
        String[] arr = {};
        String[] wordArr = {"aaa"};
        String word = "aaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.add(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddMethodWithIndex() {
        String[] arr = {"aaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.add(1, word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddMethodWithIndexOutOfBounds() {
        String[] arr = {"aaa", "aaaaa"};
        String word = "aaaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.add(2, word);
    }

    @Test
    public void testAddAllMethod() {
        String[] arr = {"aaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String[] addWordArr = {"aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        System.out.println(list.toString());
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        System.out.println(expectedResult.toString());
        ImmutableArrayList actualResult = list.add(addWordArr);
        System.out.println(Arrays.toString(actualResult.toArray()));

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }


}
