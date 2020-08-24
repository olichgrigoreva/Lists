package task;

import java.util.List;

public interface Basket {
    //должен добавлять к существующему, а не перезатирать
    void addProduct(String product, int quantity);

    //находим продукт, берем его индекс, удаляем в списках (продукт и кол-во) по заданому индексу
    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProducts();

    int getProductQuantity(String product);
}
