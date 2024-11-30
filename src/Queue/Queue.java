package Queue;


public class Queue {
    private int size;
    private Node front;
    private Node rear;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public void enqueue(int data){
        Node node = new Node(data);
        if (isEmpty()){
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.print("Очередь пуста ");
            return -1;
        }
        int data = front.data;
        front = front.next;
        size--;
        if (isEmpty()){
            front = null;
            rear = null;
        }
        return data;
    }

    public int peek(){
        if (isEmpty()){
            System.out.print("Очередь пуста ");
            return -1;
        }
        return front.data;
    }

    public int size(){
        return size;
    }

    public void clear(){
        front = null;
        rear = null;
        size = 0;
    }

    public boolean contains(int data){
        if (isEmpty()){
            System.out.print("Очередь пуста ");
            return false;
        }
        Node current = front;
        while (current != null){
            if (current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int search(int data){
        if (isEmpty()){
            System.out.print("Очередь пуста ");
            return -1;
        }
        Node current = front;
        int num = 1;
        while (current != null){
            if (current.data == data){
                return num;
            }
            current = current.next;
            num++;
        }
        return -1;
    }

    public void print(){
        if (isEmpty()){
            System.out.print("Очередь пуста ");
        }
        else if (front.next == null){
            System.out.println(front.data);
            return;
        }
        Node current = front;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}
