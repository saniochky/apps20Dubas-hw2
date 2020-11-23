package ua.edu.ucu.collections.immutable;

import org.junit.Test;

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

    @Test
    public void testAddMethodWithIndexTwoObjets() {
        String[] arr = {"aaa", "aaaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa", "aaaaaa"};
        String word1 = "aaaa";
        String word2 = "aaaaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        list = list.add(1, word1);
        ImmutableArrayList actualResult = list.add(2, word2);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddMethodWithIndexOutOfBounds() {
        String[] arr = {"aaa", "aaaaa"};
        String word = "aaaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.add(2, word);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddMethodWithIndexLessThanZero() {
        String[] arr = {"aaa", "aaaaa"};
        String word = "aaaa";

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.add(-3, word);
    }

    @Test
    public void testAddAllMethod() {
        String[] arr = {"aaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String[] addWordArr = {"aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.addAll(addWordArr);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testAddAllMethodWithIndex() {
        String[] arr = {"aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};
        String[] addWordArr = {"aaa", "aaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.addAll(0, addWordArr);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllMethodWithIndexOutOfBounds() {
        String[] arr = {"aaaaa"};
        String[] addWordArr = {"aaa", "aaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.addAll(4, addWordArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllMethodWithIndexLessThanZero() {
        String[] arr = {"aaaaa"};
        String[] addWordArr = {"aaa", "aaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.addAll(-5, addWordArr);
    }

    @Test
    public void testGetMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        String expectedResult = "aaaa";
        Object actualResult = list.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodWithIndexOutOfBounds() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.get(8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodWithIndexLessThanZero() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.get(-7);
    }

    @Test
    public void testRemoveMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.remove(2);

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethodWithIndexOutOfBounds() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.remove(8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethodWithIndexLessThanZero() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.remove(-6);
    }

    @Test
    public void testSetMethod() {
        String[] arr = {"bbb", "aaaa", "aaaaa"};
        String[] wordArr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList(wordArr);
        ImmutableArrayList actualResult = list.set(0, "aaa");

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetMethodWithIndexOutOfBounds() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.set(8, "bbb");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetMethodWithIndexLessThanZero() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        list.set(-1, "bbb");
    }

    @Test
    public void testIndexOfMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        int expectedResult = 1;
        int actualResult = list.indexOf("aaaa");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOfMethodWithEmptyList() {
        ImmutableArrayList list = new ImmutableArrayList();
        int expectedResult = -1;
        int actualResult = list.indexOf("aaaa");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOfMethodWithNoSameElement() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        int expectedResult = -1;
        int actualResult = list.indexOf("bbb");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSizeMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        int expectedResult = 3;
        int actualResult = list.size();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testClearMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList expectedResult = new ImmutableArrayList();
        ImmutableArrayList actualResult = list.clear();

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void testIsEmptyMethodFalse() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyMethodTrue() {
        ImmutableArrayList list = new ImmutableArrayList();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testToStringMethod() {
        String[] arr = {"aaa", "aaaa", "aaaaa"};

        ImmutableArrayList list = new ImmutableArrayList(arr);
        String expectedResult = "aaa, aaaa, aaaaa";
        String actualResult = list.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testToStringMethodWithEmptyList() {
        ImmutableArrayList list = new ImmutableArrayList();
        String expectedResult = "";
        String actualResult = list.toString();

        assertEquals(expectedResult, actualResult);
    }
}
