public class Customer {
    private String name;
    private boolean isTakeaway;

    public Customer(String name, boolean isTakeaway) {
        this.name = name;
        this.isTakeaway = isTakeaway;
    }

    public String getName() {
        return name;
    }

    public boolean isTakeaway() {
        return isTakeaway;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + name + " | " + (isTakeaway ? "Takeaway" : "Dine-In"));
    }
}
