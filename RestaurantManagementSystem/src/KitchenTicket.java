import java.time.LocalDateTime;
public class KitchenTicket {
    private int ticketId;
    private Order order;
    private String status;
    private LocalDateTime createdTime;

    public KitchenTicket(int ticketId, Order order) {
        this.ticketId = ticketId;
        this.order = order;
        this.status = "Pending";
        this.createdTime = LocalDateTime.now();
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void displayTicket() {
        System.out.println("\n--- Kitchen Ticket #" + ticketId + " ---");
        System.out.println("Table: " + order.getTable().getTableNumber());
        for (OrderItem item : order.getOrderItems()) {
            item.displayOrderItem();
        }
        System.out.println("Status: " + status);
        System.out.println("Created: " + createdTime);
    }
}
