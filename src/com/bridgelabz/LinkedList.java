package com.bridgelabz;

public class LinkedList <T> {
    Node<T> head;
    Node<T> tail;

    public void display() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("Linked list is Empty");
        }
        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public Node<T> search(T searchData) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getData().equals(searchData))
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    public boolean insertAfter(T searchData, T insertData) {
        if (search(searchData) != null) {
            Node<T> nextNode = search(searchData).getNext();
            Node<T> newNode = new Node<>(insertData);
            search(searchData).setNext(newNode);
            newNode.setNext(nextNode);
            return true;
        } else
            System.out.println("Node not found unable to insert New Node ");
        return false;
    }

    public T pop() {
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    public T popLast() {
        T data = tail.getData();  // tail data
        Node<T> secondLast = head; // Consider new node variable secondLast as Head
        while (secondLast.getNext() != tail) // loop the condition up to secondlast node is not a tail
        {
            secondLast = secondLast.getNext(); // after loop is satisfy we found second Last Node
        }
        tail = secondLast; // Now we make it as second last node is tail
        tail.setNext(null); // set a next is null because of tail point out reference always null
        return data; // returned old tail data or popped element
    }
    public boolean popSearchNode(T searchDeleteData)
    {
        if (search(searchDeleteData) != null) {
            T data = tail.getData();
            Node<T> previousNode = head;
            Node<T> nextNode = search(searchDeleteData).getNext();
            while (previousNode.getNext() != nextNode) {
                previousNode = previousNode.getNext();
            }
//            previousNode.setNext(nextNode);
//            nextNode.setNext(null);
            nextNode = previousNode;
            nextNode.setNext(nextNode);
            return true;
        }
        return true;
    }

    public void delete(int pos, T value)
    {
        if (pos == 0) {
            head = head.getNext();
            return;
        }
        Node previous = head;
        for (int i = 0; i < pos - 1; i++) {
            previous = previous.getNext();
        }
        previous = previous.getNext().getNext();
    }
}
