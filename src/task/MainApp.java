package task;

import java.util.ListIterator;

public class MainApp {
    public static void main(String[] args) {

        Purchase newBasket = new Purchase();
        newBasket.addProduct("Груша", 7);
        newBasket.addProduct("Яблоко", 10);
        newBasket.addProduct("Персик", 5);
        newBasket.addProduct("Арбуз", 1);
        printList(newBasket);

        System.out.println();
        newBasket.addProduct("Персик", 15);

        System.out.println();
        System.out.println("Ваша корзина:");
        printList(newBasket);

        System.out.println();
        newBasket.addProduct("Апельсин", 47);
        printList(newBasket);

        System.out.println();
        newBasket.updateProductQuantity("Груша", 25);
        printList(newBasket);

        System.out.println();
        System.out.printf("В корзине Апельсинов: %d", newBasket.getProductQuantity("Апельсин"));

        System.out.println();
        newBasket.clear();
        printList(newBasket);

        newBasket.addProduct("Апельсин", 47);
        printList(newBasket);
    }

    /**
     * выводит элементы списка
     *
     * @param basket объект класса Purchase
     */
    public static void printList(Purchase basket) {
        ListIterator<String> prodIt = basket.getProducts().listIterator();
        String value;
        while (prodIt.hasNext()) {
            value = prodIt.next();
            System.out.print(value + ": " + basket.getProductQuantity(value) + "; ");
        }
        System.out.println();
    }
}
