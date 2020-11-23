package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testMutation() {
        String[] arr = {"aaa", "aaaa"};
        String[] wordArr = {"aaa", "aaaa"};
        String word = "aaaaa";

        ImmutableLinkedList actualResult = new ImmutableLinkedList(arr);
        actualResult.add(word);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }
    
    @Test
    public void testAddMethodOfEmptyList() {
        String[] arr = {};
        String[] wordArr = {"word"};
        String word = "word";

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.add(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddMethodOfNonEmptyList() {
        String[] arr = {"aaa", "aaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaaaa";

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.add(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddMethodWithIndexOfNonEmptyList() {
        String[] arr = {"aaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaaa";

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.add(1, word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddMethodWithIndexZeroOfNonEmptyList() {
        String[] arr = {"aaaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaa";

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.add(0, word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddMethodWithIndexOutOfBounds() {
        String[] wordArr = {"aaa", "aaaa"};
        String word = "aaaaa";

        ImmutableLinkedList list = new ImmutableLinkedList(wordArr);
        list.add(2, word);
    }

    @Test
    public void testAddAllMethod() {
        String[] arr = {"aaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String[] addWordArr = {"aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.addAll(addWordArr);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddAllMethodWithIndex() {
        String[] arr = {"aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String[] addWordArr = {"aaa", "aaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.addAll(0, addWordArr);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testGetMethod() {
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(wordArr);
        String expectedResult = "aaa";
        Object actualResult = list.get(0);

        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodWithIndexOutOfBounds() {
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(wordArr);
        list.get(-1);
    }

    @Test
    public void testRemoveMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa", "aaaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.remove(3);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethodWithIndexOutOfBounds() {
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(wordArr);
        list.get(3);
    }

    @Test
    public void testRemoveMethodWithIndexZeroAndSizeOne() {
        String[] arr = {"aaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList();
        ImmutableLinkedList actualResult = list.remove(0);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testRemoveMethodWithIndexZeroAndSizeNonOne() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};
        String[] wordArr = {"aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.remove(0);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testSetMethod() {
        String[] arr = {"bbb", "aaaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.set(0, "aaa");

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetMethodWithIndexOutOfBounds() {
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(wordArr);
        list.set(3, "bbbbbb");
    }

    @Test
    public void testIndexOfMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        int expectedResult = 0;
        int actualResult = list.indexOf("aaa");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOfMethodWithSameElements() {
        String[] arr = {"aaa", "aaa", "aaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        int expectedResult = 0;
        int actualResult = list.indexOf("aaa");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOfMethodWithNoElements() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int expectedResult = -1;
        int actualResult = list.indexOf("aaa");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOfMethodWithNoSameElement() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        int expectedResult = -1;
        int actualResult = list.indexOf("bbb");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSizeMethod() {
        String[] arr = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        int expectedResult = 6;
        int actualResult = list.size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToStringMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        String expectedResult = "aaa, aaaa, aaaaa";
        String actualResult = list.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToStringMethodWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        String expectedResult = "";
        String actualResult = list.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToStringMethodWithOneElement() {
        String[] arr = {"aaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        String expectedResult = "aaa";
        String actualResult = list.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddFirstMethod() {
        String[] arr = {"aaaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaa";

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.addFirst(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddFirstMethodWithEmptyList() {
        String[] wordArr = {"aaa"};
        String word = "aaa";

        ImmutableLinkedList list = new ImmutableLinkedList();
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.addFirst(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddLastMethod() {
        String[] arr = {"aaa", "aaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String word = "aaaaa";

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.addLast(word);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testGetFirstMethod() {
        String[] arr = {"aaa", "aaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        String expectedResult = "aaa";
        Object actualResult = list.getFirst();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetLastMethod() {
        String[] arr = {"aaa", "aaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        String expectedResult = "aaaa";
        Object actualResult = list.getLast();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemoveFirstMethod() {
        String[] arr = {"aa", "aaa", "aaaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.removeFirst();

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testRemoveLastMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa", "aaaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList expectedResult = new ImmutableLinkedList(wordArr);
        ImmutableLinkedList actualResult = list.removeLast();

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }
}
