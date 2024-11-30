package LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Тестирование на пустом списке:");
        System.out.println("Список пуст: " + list.isEmpty());
        list.print();

        System.out.println("\nДобавление элементов:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();

        System.out.println("\nДобавление элемента в начало:");
        list.addAtHead(5);
        list.print();

        System.out.println("\nУдаление элемента 20:");
        list.delete(20);
        list.print();

        System.out.println("\nУдаление элемента из начала:");
        list.deleteAtHead();
        list.print();

        System.out.println("\nПоиск элемента 30:");
        System.out.println("Содержит 30: " + list.search(30));

        System.out.println("\nПоиск элемента 100:");
        System.out.println("Содержит 100: " + list.search(100));

        System.out.println("\nУдаление элемента 30:");
        list.delete(30);
        list.print();

        System.out.println("\nУдаление элемента из пустого списка:");
        list.delete(10);
        list.print();

        System.out.println("\nОчистка списка:");
        list.deleteAtHead();
        list.print();
        System.out.println("Список пуст после очистки: " + list.isEmpty());
    }
}
