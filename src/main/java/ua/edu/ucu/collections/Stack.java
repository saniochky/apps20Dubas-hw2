package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public Object peek() {
        if (this.stack.size() > 0) {
            return this.stack.getLast();
        }

        return null;
    }

    public Object pop() {
        if (this.stack.size() > 0) {
            Object popped = this.peek();
            this.stack = this.stack.removeLast();

            return popped;
        }

        return null;
    }

    public void push(Object e) {
        this.stack = this.stack.add(e);
    }
}
