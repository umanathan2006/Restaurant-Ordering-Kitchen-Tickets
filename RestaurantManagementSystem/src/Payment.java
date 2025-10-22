public class Payment {
    private int paymentId;
    private Bill bill;
    private String paymentMethod; 
    private boolean isPaid;

    public Payment(int paymentId, Bill bill, String paymentMethod) {
        this.paymentId = paymentId;
        this.bill = bill;
        this.paymentMethod = paymentMethod;
        this.isPaid = false;
    }

    public void makePayment() {
        if (!isPaid) {
            isPaid = true;
            bill.getOrder().getTable().freeTable();
            System.out.println("Payment successful using " + paymentMethod);
        } else {
            System.out.println("Payment already made.");
        }
    }

    public boolean isPaid() {
        return isPaid;
    }
}
