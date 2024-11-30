package Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println("Тестирование на пустом стеке:");
        System.out.println("Стек пуст: " + stack.isEmpty());
        System.out.println("Заполненость стэка: " + stack.size());
        System.out.print("Верхний элемент: ");
        System.out.println(stack.top());
        System.out.print("Удаление элемента: ");
        System.out.println(stack.pop());
        System.out.println("Содержит 10: " + stack.contains(10));
        System.out.println("Поиск 10: " + stack.search(10));

        System.out.println("\nДобавление элементов в стек:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print();
        System.out.println("Заполненость стэка: " + stack.size());

        System.out.print("\nПопытка добавить элемент в переполненный стек:");
        stack.push(60);

        System.out.println("\nТестирование на непустом стеке:");
        System.out.println("Стек пуст: " + stack.isEmpty());
        System.out.println("Верхний элемент: " + stack.top());
        System.out.println("Удаление элемента: " + stack.pop());
        System.out.println("Заполненость стэка: " + stack.size());
        stack.print();

        System.out.println("\nПоиск элементов:");
        System.out.println("Содержит 30: " + stack.contains(30));
        System.out.println("Поиск 30: " + stack.search(30));
        System.out.println("Содержит 60: " + stack.contains(60));
        System.out.println("Поиск 60: " + stack.search(60));

        System.out.println("\nОчистка стека:");
        stack.clear();
        System.out.println("Стек пуст после очистки: " + stack.isEmpty());
        System.out.println("Верхний элемент после очистки: ");
        System.out.print(stack.top());
    }
}
