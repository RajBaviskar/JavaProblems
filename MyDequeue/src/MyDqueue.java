class Node{
    public int val;
    Node next;
    Node prev;
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
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // O(1)
    public int poll(){
        if(head == null || tail == null){
            System.out.println("Queue is empty");
            return -1;
        }


        if(head.next == null){
            int value = head.val;
            head = null;
            tail = null;
            return value;
        }

        int value = head.val;
        Node newHead = head.next;
        head.next = null;
        head = newHead;
        head.prev = null;
        return value;
    }


    public void printQueue(){
        Node cur = head;
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
        Node temp = tail;
        tail = tail.prev;
        temp = null;
        return value;
    }


    public static void main(String[] args){
        // Deque<Integer> q = new LinkedList<>();
        MyDqueue q = new MyDqueue();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);


 //       q.printQueue();

//        System.out.println("Polled = " + q.poll());
//        System.out.println("Polled = " + q.poll());
//        System.out.println("Polled = " + q.poll());
//        System.out.println("Polled = " + q.poll());
//        System.out.println("Polled = " + q.poll());

            q.push(1);
            q.push(2);
            q.push(3);
            q.push(4);


        q.printQueue();


        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());
        System.out.println("poped = " + q.pop());



    }
}
