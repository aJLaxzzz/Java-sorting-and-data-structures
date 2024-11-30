package LinkedList;

public class LinkedList {
    private Node head;

    public LinkedList(){
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        if (isEmpty()){
            return;
        }
        else if (head.next == null){
            System.out.println(head.data);
            return;
        }
        Node current = head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void add(int data){
        Node node = new Node(data);
        if (isEmpty()){
            head = node;
        }
        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    public void addAtHead(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void delete(int data){
        if (isEmpty()){
            return;
        }
        if (head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null){
            if (current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void deleteAtHead(){
        if (!isEmpty()){
            head = head.next;
        }
    }

    public boolean search(int data){
        if (isEmpty()){
            return false;
        }
        Node current = head;
        while (current != null){
            if (current.data == data){
                return true;
            }
            current = current.next;
        }

        return false;
    }
}


