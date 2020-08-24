package lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        /*list = new ArrayList(10);

        //будет происходить ресайз массива
        for(int i = 0; i < 100; i++){
            list.add(Integer.valueOf(i).toString());
        }
        list.trimToSize();*/

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        printList(list);

        ArrayList<String> list2 = new ArrayList<>();
        list.add("x");
        list.add("y");
        list.add("a");

        list.addAll(list2);
        printList(list);

        //вывод в обратную сторону
        ListIterator<String> it = list.listIterator(list.size()); //позиция итератора
        System.out.println();
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
        //т.к. итератор уже в начале списка, то новый можно не создавать
        System.out.println();
        while (it.hasNext()) {
            String value = it.next(); //получаем текущее значение
            it.set(value.toUpperCase());
        }

        printList(list);

        //удаление буквы А + новый итератор нужно (или обойти список обратно)
        while (it.hasPrevious()) {
            if ("A".equals(it.previous())) {
                it.remove();
            }
        }
        printList(list);

        //удаление без итератора
        list.add("X");
        list.add("D");
        printList(list);
        list.remove("X"); //удаляет первое совпадение
        printList(list);
        list.removeAll(Arrays.asList("D")); //удаляет все D списка
        printList(list);
        //printList(list.subList(1,3));

        List<String> sublist = list.subList(0, 4);
        printList(sublist);

        List<String> lowerCase = sublist.stream() //конвертация в стрим
                .map(String::toLowerCase)
                .filter(element -> !"x".equals(element))
                .map(element -> element + element) //дублирование
                .collect(Collectors.toList());
        printList(lowerCase);
        lowerCase.replaceAll(String::toUpperCase);
        printList(lowerCase);

        //удаление по предикату
        lowerCase.add("a");
        lowerCase.add("b");
        lowerCase.removeIf(item -> item.length() > 1);
        printList(lowerCase);
        lowerCase.add(2, "r");
        //lowerCase.remove(2);
        printList(lowerCase);

        //список списков
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList("hi", "bye"));
        listOfLists.add(Arrays.asList("hello"));
    }

    public static void printList(List list) {
        for (Object obj : list) {
            System.out.print(obj == null ? "null" : obj.toString());
            System.out.print(" ");
        }
        System.out.println();
    }
}
