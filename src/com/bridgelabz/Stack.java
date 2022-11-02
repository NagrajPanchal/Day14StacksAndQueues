package com.bridgelabz;

public class Stack<E>
{
    LinkedList<E> linkedList = new LinkedList<>();
    public Stack()
    {

    }
    public Stack(LinkedList<E> linkedList)
    {
        this.linkedList = linkedList;
    }
    public void push(E data)
    {
        linkedList.push(data);
    }
    public void display()
    {
        linkedList.display();
    }
    public static void main(String[] args) {
        System.out.println("Create Stack Using Linked list methods ");
        System.out.println("Push elements into the Stack ");
        Stack<Integer> stackObject = new Stack<>();
        stackObject.push(70);
        stackObject.push(30);
        stackObject.push(56);
        stackObject.display();
    }
}
