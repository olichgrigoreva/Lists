package lesson;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("world");
        linkedList.addLast("!");
        linkedList.addFirst("Hello");
        printList(linkedList); //размер очереди 3
        System.out.println(linkedList.size());

        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            if ("Hello".equals(listIterator.next())) {
                listIterator.add("big");
            }
        }
        printList(linkedList);

        System.out.printf("Индекс слова 'hello' в списке %d %n", linkedList.indexOf("Hello")); //убедиться есть ли в корзине продукт до его добавления
        System.out.printf("Индекс слова 'bye' в списке %d %n", linkedList.indexOf("bye"));
        System.out.printf("Список содержит слово 'bye' - %s %n", linkedList.contains("bye"));
        linkedList.retainAll(Arrays.asList("Hello", "my", "world", "!")); //оставляет одинаковые слова в списках

        //двухконцевая очередь
        printDeque(linkedList); //размер очереди 2
        System.out.println(linkedList.size());
    }

    public static void printList(List list) {
        for (Object obj : list) {
            System.out.print(obj == null ? "null" : obj.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * разграбает очередь и печатает её содержимое
     */
    public static void printDeque(Deque<String> deque) {
        while (!deque.isEmpty()) {
            String value = deque.removeFirst(); //возврат данных и УДАЛЕНИЕ!
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
