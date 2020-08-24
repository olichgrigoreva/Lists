package task;

import java.util.ArrayList;
import java.util.List;

public class Purchase implements Basket {

    List<String> products = new ArrayList<>();
    List<Integer> prodQuantity = new ArrayList<>();

    public Purchase() {
    }

    @Override
    public void addProduct(String product, int quantity) {
        int value;
        if (products.contains(product)) {
            int prodIndex = products.indexOf(product);
            value = prodQuantity.get(prodIndex);
            prodQuantity.set(prodIndex, value + quantity);
            System.out.printf("%s уже есть в корзине! Обновлено кол-во: %d\n", product, value + quantity);
        } else {
            products.add(product);
            prodQuantity.add(quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.equals(products.get(i))) {
                prodQuantity.remove(i);
                products.remove(i);
                System.out.printf("%s удален из корзины!\n", product);
            }
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        for (int i = 0; i < products.size(); i++) {
            if (product.equals(products.get(i))) {
                prodQuantity.set(i, quantity);
                System.out.printf("Для позиции %s обновлено количество: %d!\n", product, quantity);
            }
        }
    }

    @Override
    public void clear() {
        products.clear();
        prodQuantity.clear();
        System.out.println("Корзина очищена!");
    }

    @Override
    public List<String> getProducts() {
        return products;
    }

    @Override
    public int getProductQuantity(String product) {
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (product.equals(products.get(i))) {
                index = prodQuantity.get(i);
            }
        }
        return index;
    }
}