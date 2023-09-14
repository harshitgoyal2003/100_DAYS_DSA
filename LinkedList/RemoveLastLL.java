public class RemoveLastLL{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    //to find the size of the ll
    public static int size;
    
    public void addFirst(int data){
        //step1 = creates new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 - newNode next = head;
        newNode.next = head;  //link

        //step3 - head = newNode
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){  //0(n)
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int index, int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
 
        while(i < index - 1){
            temp = temp.next;
            i++;
        }

        // i = idx - 1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
       if(size == 0){
        System.out.println("LL is Empty");
        return Integer.MIN_VALUE;
       }
       if(size == 1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
       }

       Node prev = head;
       for(int i=0; i<size-2; i++){
        prev = prev.next;
       }

       int val = prev.next.data;  //tail data
       prev.next = null;
       tail = prev;
       size--;
       return val;

    }

    public static void main(String args[]){
        RemoveLastLL ll = new RemoveLastLL();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMiddle(2, 3); 

        ll.print();//1->2->3->4->5
        // System.out.println(ll.size);

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();
        System.out.println(ll.size);
    }
}