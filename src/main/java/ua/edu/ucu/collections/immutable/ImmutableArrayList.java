package ua.edu.ucu.collections.immutable;


import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] collection;
    private int collectionSize = 0;

    public ImmutableArrayList() {
        this.collection = new Object[1];
    }

    public ImmutableArrayList(Object[] c) {
        if (c.length != 0) {
            this.collectionSize = c.length;
            this.collection = new Object[this.collectionSize];
            System.arraycopy(c, 0, this.collection, 0, this.collectionSize);
        } else {
            this.collection = new Object[1];
        }

        for (int i = this.collectionSize - 1; i >= 0; i--) {
            if (this.collection[i] == null) {
                this.collectionSize--;
            } else {
                break;
            }
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        int copyLength = this.collection.length;

        if (this.collection.length == this.collectionSize) {
            copyLength *= 2;
        }

        Object[] collectionCopy = new Object[copyLength];
        System.arraycopy(this.collection, 0,
                collectionCopy, 0, this.collectionSize);
        collectionCopy[this.collectionSize] = e;

        return new ImmutableArrayList(collectionCopy);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (0 <= index && index < this.collectionSize) {
            int copyLength = this.collection.length;

            if (this.collection.length == this.collectionSize) {
                copyLength *= 2;
            }

            Object[] collectionCopy = new Object[copyLength];
            System.arraycopy(this.collection, 0, collectionCopy, 0, index);
            collectionCopy[index] = e;
            System.arraycopy(this.collection, index,collectionCopy, index + 1,
                    this.collectionSize - index);

            return new ImmutableArrayList(collectionCopy);
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] collectionCopy = new Object[this.collection.length];
        System.arraycopy(this.collection, 0,
                collectionCopy,0, this.collectionSize);
        ImmutableArrayList immutableArrayListCopy = new ImmutableArrayList(collectionCopy);

        for (Object e: c) {
            immutableArrayListCopy = immutableArrayListCopy.add(e);
        }

        return immutableArrayListCopy;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (0 <= index && index < this.collectionSize) {
            Object[] collectionCopy = new Object[this.collection.length];
            System.arraycopy(this.collection, 0,collectionCopy, 0, this.collectionSize);
            ImmutableArrayList immutableArrayListCopy =
                    new ImmutableArrayList(collectionCopy);

            for (int i = 0; i < c.length; i++) {
                immutableArrayListCopy =
                        immutableArrayListCopy.add(index + i, c[i]);
            }

            return immutableArrayListCopy;
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public Object get(int index) {
        if (0 <= index && index < this.collectionSize) {
            return this.collection[index];
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (0 <= index && index < this.collectionSize) {
            Object[] collectionCopy = new Object[this.collection.length];
            System.arraycopy(this.collection, 0, collectionCopy, 0, index);
            System.arraycopy(this.collection, index + 1, collectionCopy,
                    index, this.collectionSize - index - 1);

            return new ImmutableArrayList(collectionCopy);
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (0 <= index && index < this.collectionSize) {
            Object[] collectionCopy = new Object[this.collection.length];
            System.arraycopy(this.collection, 0,
                    collectionCopy, 0, this.collectionSize);
            collectionCopy[index] = e;

            return new ImmutableArrayList(collectionCopy);
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public int indexOf(Object e) {
        for (int i =  0; i < this.collectionSize; i++) {
            if (this.collection[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return this.collectionSize;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.collectionSize == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.collectionSize];
        System.arraycopy(this.collection, 0, arr, 0, this.collectionSize);

        return arr;
    }

    @Override
    public String toString() {
        String collectionString = Arrays.toString(this.toArray());
        return collectionString.substring(1, collectionString.length() - 1);
    }
}
