package task.maps;

import java.util.ListIterator;

public class MainApp {
    public static void main(String[] args) {

        Purchase newBasket = new Purchase();
        newBasket.addProduct("Груша", 7);
        newBasket.addProduct("Яблоко", 10);
        newBasket.addProduct("Персик", 5);
        newBasket.addProduct("Арбуз", 1);
        printList(newBasket);

        newBasket.addProduct("Персик", 15);
        printList(newBasket);

        newBasket.addProduct("Апельсин", 47);

        newBasket.updateProductQuantity("Груша", 25);
        printList(newBasket);

        System.out.printf("В корзине Апельсинов: %d", newBasket.getProductQuantity("Апельсин"));

        newBasket.clear();
        printList(newBasket);

        newBasket.addProduct("Апельсин", 47);
        printList(newBasket);

        newBasket.removeProduct("Апельсин");
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
        System.out.printf("%nВ корзине: ");
        while (prodIt.hasNext()) {
            value = prodIt.next();
            System.out.print(value + ": " + basket.getProductQuantity(value) + "; ");
        }
        System.out.println();
    }
}
