public class Bill {
    private int billId;
    private Order order;
    private double taxRate = 0.05;
    private double serviceCharge = 0.1;
    private double discount = 0.0;

    public Bill(int billId, Order order) {
        this.billId = billId;
        this.order = order;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public Order getOrder() {
        return order;
    }


    public double calculateTotal() {
        double subtotal = order.getTotalAmount();
        double tax = subtotal * taxRate;
        double service = subtotal * serviceCharge;
        double total = subtotal + tax + service - discount;
        return total;
    }

    public void displayBill() {
        System.out.println("\n--- Bill #" + billId + " ---");
        order.displayOrder();
        System.out.println("Tax (5%): ₹" + order.getTotalAmount() * taxRate);
        System.out.println("Service (10%): ₹" + order.getTotalAmount() * serviceCharge);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Grand Total: ₹" + calculateTotal());
    }
}
