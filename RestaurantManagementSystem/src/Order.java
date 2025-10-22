import java.util.*;
public class Order {
    private int orderId;
    private Table table;
    private Customer customer;
    private List<OrderItem> orderItems;
    private String status;

    public Order(int orderId, Table table, Customer customer) {
        this.orderId = orderId;
        this.table = table;
        this.customer = customer;
        this.orderItems = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Table getTable() {
        return table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return orderItems.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    public void displayOrder() {
        System.out.println("Order #" + orderId + " | " + customer.getName());
        for (OrderItem item : orderItems) {
            item.displayOrderItem();
        }
        System.out.println("Total: ₹" + getTotalAmount());
        System.out.println("Status: " + status);
    }
}
