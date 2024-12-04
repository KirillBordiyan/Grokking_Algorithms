package orders;

public interface OrderService {
    void placeOrder(Order order);
    int getOrderCount();
}
