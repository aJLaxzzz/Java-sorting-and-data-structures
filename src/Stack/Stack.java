package Stack;

public class Stack {
    private int size;
    private int[] stack;
    private int top;

    public Stack(int size){
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int top(){
        if (!isEmpty()){
            return stack[top];
        }
        System.out.print("Стэк пуст ");
        return -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public boolean push(int data){
        if (isFull()){
            System.out.println(" Переполненеи стэка");
            return false;
        }
        stack[++top] = data;
        return true;

    }

    public int pop(){
        if (!isEmpty()){
            return stack[top--];
        }
        System.out.print("Стэк пуст ");
        return -1;
    }

    public int size(){
        return top+1;
    }

    public void clear(){
        top = -1;
    }

    public boolean contains(int data){
        for (int i = 0; i <= top;++i){
            if (stack[i] == data){
                return true;
            }
        }
        return false;
    }


    public int search(int data){
        for (int i = 0; i <= top;++i){
            if (stack[i] == data){
                return i+1;
            }
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i <= top;++i){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }


}
