package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {
    private Object[] collection;
    private int collectionSize = 0;

    public ImmutableArrayList() {
        this.collection = new Object[1];
    }

    public ImmutableArrayList(Object[] c) {
        if (c.length != 0) {
            this.collection = c;
        } else {
            this.collection = new Object[1];
        }

        for (Object e: this.collection) {
            if (e != null) {
                this.collectionSize++;
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

        Object[] objectsCopy = new Object[copyLength];
        System.arraycopy(this.collection, 0, objectsCopy, 0, this.collectionSize);
        objectsCopy[this.collectionSize] = e;

        return new ImmutableArrayList(objectsCopy);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (0 <= index && index < this.collectionSize) {
            int copyLength = this.collection.length;

            if (this.collection.length == this.collectionSize) {
                copyLength *= 2;
            }

            Object[] objectsCopy = new Object[copyLength];
            System.arraycopy(this.collection, 0, objectsCopy, 0, index);
            objectsCopy[index] = e;
            System.arraycopy(this.collection, index, objectsCopy, index++, this.collectionSize - index);

            return new ImmutableArrayList(objectsCopy);
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        ImmutableArrayList immutableArrayListCopy = this;

        for (Object e: c) {
            immutableArrayListCopy = immutableArrayListCopy.add(e);
        }

        return immutableArrayListCopy;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (0 <= index && index < this.collectionSize) {
            ImmutableArrayList immutableArrayListCopy = this;

            for (int i = 0; i < c.length; i++) {
                immutableArrayListCopy = immutableArrayListCopy.add(index + i, c[i]);
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
            Object[] objectsCopy = new Object[this.collection.length];
            System.arraycopy(this.collection, 0, objectsCopy, 0, index);
            System.arraycopy(this.collection, index++, objectsCopy, index, this.collectionSize - index - 1);

            return new ImmutableArrayList(objectsCopy);
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (0 <= index && index < this.collectionSize) {
            Object[] objectsCopy = new Object[this.collection.length];
            System.arraycopy(this.collection, 0, objectsCopy, 0, this.collectionSize);
            objectsCopy[index] = e;

            return new ImmutableArrayList(objectsCopy);
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public int indexOf(Object e) {
        for (int i =  0; i < this.collectionSize; i++) {
            if (this.collection[i] == e) {
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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.collectionSize; i++) {
            sb.append(this.collection[i]);

            if (i != this.collectionSize - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
