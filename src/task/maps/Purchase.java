package task.maps;

import java.util.*;

public class Purchase implements Basket {

    Map<String, Integer> prodMap = new HashMap<>();


    public Purchase() {
    }

    @Override
    public void addProduct(String product, int quantity) {
        if (prodMap.containsKey(product)) {
            prodMap.put(product, prodMap.get(product) + quantity);
            System.out.println();
            System.out.printf("%s уже есть в корзине! Обновлено кол-во: %d\n", product, prodMap.get(product));
        } else {
            prodMap.put(product, quantity);
            System.out.printf("Добавлен новый товар: %s в количестве %d.%n", product, quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        prodMap.remove(product, prodMap.get(product));
        System.out.printf("%s удален из корзины!\n", product);
        System.out.println();
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        prodMap.put(product, quantity);
        System.out.printf("Для позиции %s обновлено количество: %d!\n", product, quantity);
    }

    @Override
    public void clear() {
        prodMap.clear();
        System.out.printf("%nКорзина очищена!%n");
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList(prodMap.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return prodMap.get(product);
    }
}