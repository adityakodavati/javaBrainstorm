package comparatorAndComparable;

public interface IOrderService {

    String createOrder(String jsonOrder);

    void searchOrder(int orderId);

    void updateOrder(String jsonUpdate);
}
