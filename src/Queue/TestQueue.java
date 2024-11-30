package Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("Тестирование на пустой очереди:");
        System.out.println("Очередь пуста: " + queue.isEmpty());
        System.out.print("Удаление элемента: ");
        System.out.println(queue.dequeue());
        System.out.print("Первый элемент: ");
        System.out.println(queue.peek());
        System.out.print("Содержит 10: ");
        System.out.println(queue.contains(10));
        System.out.print("Поиск 10: ");
        System.out.println(queue.search(10));
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("\nДобавление элементов:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Очередь пуста: " + queue.isEmpty());
        System.out.print("Первый элемент: ");
        System.out.println(queue.peek());
        System.out.println("Размер очереди: " + queue.size());
        queue.print();

        System.out.println("\nСодержит 20: " + queue.contains(20));
        System.out.println("Содержит 40: " + queue.contains(40));
        System.out.println("Поиск 20: " + queue.search(20));
        System.out.println("Поиск 40: " + queue.search(40));

        System.out.println("\nУдаление элементов:");
        System.out.print("Удаление: ");
        System.out.println(queue.dequeue());
        System.out.print("Первый элемент после удаления: ");
        System.out.println(queue.peek());
        System.out.println("Размер очереди: " + queue.size());
        queue.print();

        System.out.println("\nУдаление всех элементов:");
        System.out.print("Удаление: ");
        System.out.println(queue.dequeue());
        System.out.print("Удаление: ");
        System.out.println(queue.dequeue());
        System.out.println("Очередь пуста: " + queue.isEmpty());

        System.out.println("\nПопытка удаления из пустой очереди:");
        System.out.print("Удаление элемента: ");
        System.out.println(queue.dequeue());
        System.out.print("Первый элемент: ");
        System.out.println(queue.peek());
        System.out.println("Содержит 10: " + queue.contains(10));
        System.out.println("Поиск 10: " + queue.search(10));
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("\nОчистка очереди:");
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Размер очереди: " + queue.size());
        queue.clear();
        System.out.println("Очередь пуста после очистки: " + queue.isEmpty());
        System.out.print("Первый элемент после очистки: ");
        System.out.println(queue.peek());
    }
}
