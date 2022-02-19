package com.geekbrains.lesson11_2.collections;

import java.util.ListIterator;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty())
            head = node;
        else
            tail.next = node;

        node.prev = tail;
        tail = node;
    }

    public void addLast(String s, MyLinkedList<T> data) {
        Node<T> node = new Node(s + data);
        if (isEmpty())
            head = node;
        else
            tail.next = node;

        node.prev = tail;
        tail = node;
    }

    public void addIndex(int index, T data) {
        Node<T> find = head;
        int c = 0;
        while (find != null && c != index) {
            find = find.next;
            c++;
        }

        Node<T> node = new Node<>(data);

        find.prev.next = node;
        node.prev = find.prev;
        find.prev = node;
        node.next = find;
    }

    public void setIndex(int index, T _data) {
        Node<T> find = head;
        int c = 0;
        while (find != null && c != index) {
            find = find.next;
            c++;
        }
        if (find != null) {
            find.data = _data;
        }
    }

    public T getIndex(int index) {
        Node<T> find = head;
        int c = 0;
        while (find != null && c != index) {
            find = find.next;
            c++;
        }

        assert find != null;
        return find.data;
    }

    public T getFirst() {
        Node<T> find = head;
        return find.data;
    }

    public T getLast() {
        Node<T> find = tail;
        return find.data;
    }

    public void setKeyAll(T key, T key1) {
        Node<T> find = head;
        while (find != null) {
            while (find.data != key) {
                find = find.next;
                if (find == null)
                    return;
            }
            find.data = key1;
            find = find.next;
        }
    }

    public void removeFirst() {
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }

        head = head.next;
    }

    public void removeLast() {
        if (head.next == null)
            head = null;
        else
            tail.prev.next = null;

        tail = tail.prev;
    }

    public void removeKeyAll(T key) {
        Node<T> find = head;
        while (find != null) {
            while (find.data != key) {
                find = find.next;
                if (find == null)
                    return;
            }

            if (find == head)
                removeFirst();
            else
                find.prev.next = find.next;

            if (find == tail)
                removeLast();
            else
                find.next.prev = find.prev;

            find = find.next;
        }
    }

    public void removeIndex(int index) {
        Node<T> find = head;
        int c = 0;
        while (find != null && c != index) {
            find = find.next;
            c++;
        }

        if (find == head)
            removeFirst();
        else
            find.prev.next = find.next;

        if (find == tail)
            removeLast();
        else
            find.next.prev = find.prev;

    }

    public int size() {
        Node<T> node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public void print() {
        Node<T> node = head;
        System.out.print("[");
        while (node != null) {
            if (node.next != null)
                System.out.print(node.data + " <-> ");
            else
                System.out.print(node.data);

            node = node.next;

        }
        System.out.print("]");
    }

        public void print1() {
        Node<T> node = tail;
        System.out.print("[");
        while (node != null) {
            if (node.prev != null) {

                System.out.print(node.data + " <-> ");

            } else {
                System.out.print(node.data);
            }
            node = node.prev;
        }
        System.out.print("]");
    }

    @Override
    public String toString() {
        Node<T> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[   ");
        int s = 0;
        while (node != null) {
            sb.append(node.data);
            if (node.next != null) {
                if ((s + 1) % 5 == 0)
                    sb.append(" <->\n    ");
                else
                    sb.append(" <-> ");

            }
            s++;
            node = node.next;
        }
        if (s == 0) {
            sb.append("    ] - MyLinkedList пуст фрукты разложены по соответствующим коробкам.\n");
        } else {
            sb.append("    ] - MyLinkedList содержит ").append(s).append(" элементов\n"); //(head.data).toString().substring(1, 9)
        }

        return sb.toString();
    }

    public ListIterator<T> listIterator() {

        return new ListIterator<T>() {

            private Node<T> n = head;

            public boolean hasNext() {
                return n.next != null;
            }

            public T next() {
                n = n.next;
                return n.data;
            }

            public T get() {
                return n.data;
            }

            //TODO
            public void remove() {
                removeFirst();
            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }

            public boolean hasPrevious() {
                return n == head;
            }

            public T previous() {
                n = n.prev;
                return n.data;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }
        };
    }
}
