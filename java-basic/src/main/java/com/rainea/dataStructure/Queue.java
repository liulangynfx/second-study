package com.rainea.dataStructure;

/**
 * 队列的链表实现
 */
public class Queue {
    //头指针，返回时用到
    private Node head = null;
    //尾部指针，插入时候用到
    private Node tail = null;

    class Node {
        private String key= null;
        private Node next = null;

        public Node(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * 出列
     * @return
     */
    public String out() {
        if (head == null) {
            return null;
        }
        Node node = head;
        head = node.getNext();
        if (head == null) {
            tail = null;
        }
        return head.getKey();

    }

    /**
     * 入列
     */
    public void in(String key) {
        Node node = new Node(key);
        if (tail == null) {
            tail = head = node;
            return;
        }
        tail.setNext(node);
        tail = node;

    }

    public void printQueue() {
        while(head != null) {
            System.out.println(head.getKey() + ",");
            head = head.getNext();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.in("1");
        queue.in("2");
        queue.in("3");

        System.out.println("out :" + queue.out());
        queue.in("4");
        System.out.println("out :" + queue.out());
        queue.in("5");
        queue.printQueue();
    }
}
