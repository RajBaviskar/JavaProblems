class Node{
    public int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class MyDqueue {
    Node head;
    Node tail;

    MyDqueue(){
    }

    // O(1) adding to tail
    public void add(int val){
        if(head == null){
            head = new Node(val);
            tail = head;
            return;
        }

        Node newNode = new Node(val);
        newNode.next = tail;
        tail = newNode;
    }

    // O(n)
    public int poll(){
        if(head == null || tail == null){
            System.out.println("Queue is empty");
            return -1;
        }


        if(tail.next == null){
            int value = head.val;
            head = null;
            tail = null;
            return value;
        }

        int value = head.val;
        Node cur = tail;
        while(cur.next != null && cur.next.val != head.val){
            cur = cur.next;
        }
        cur.next = null;
        head = cur;
        return value;
    }


    public void printQueue(){
        Node cur = tail;
        while (cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void push(int val){
        add(val);
    }

    public int pop(){
        if(tail == null){
            System.out.println("Stack is empty");
            return -1;
        }

        int value = tail.val;
        tail = tail.next;
        return value;
    }


    public static void main(String[] args){
        MyDqueue q = new MyDqueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.printQueue();

        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());

        System.out.println("Polled = " + q.poll());

        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());

        System.out.println("Polled = " + q.poll());
        System.out.println("Polled = " + q.poll());




        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());



    }
}
