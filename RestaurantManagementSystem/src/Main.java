import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Table> tables = new ArrayList<>();
        List<MenuItem> menu = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        int orderCounter = 1, ticketCounter = 1, billCounter = 1, paymentCounter = 1;

        while (true) {
            System.out.println("\n--- Restaurant Management System ---");
            System.out.println("1. Add Tables");
            System.out.println("2. Add Menu Items");
            System.out.println("3. Seat Customers");
            System.out.println("4. Create Order");
            System.out.println("5. Send to Kitchen");
            System.out.println("6. Generate Bill");
            System.out.println("7. Record Payment");
            System.out.println("8. Display Tables & Menu");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter number of tables to add: ");
                    int numTables = sc.nextInt();
                    for (int i = 0; i < numTables; i++) {
                        System.out.println("\nTable #" + (i + 1));
                        System.out.print("Enter table number: ");
                        int tn = sc.nextInt();
                        System.out.print("Enter capacity: ");
                        int cap = sc.nextInt();
                        tables.add(new Table(tn, cap));
                    }
                    System.out.println(numTables + " tables added successfully!");
                    break;
                case 2:
                    System.out.print("Enter number of menu items to add: ");
                    int numItems = sc.nextInt();
                    for (int i = 0; i < numItems; i++) {
                        System.out.println("\nMenu Item #" + (i + 1));
                        System.out.print("Enter item id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();
                        menu.add(new MenuItem(id, name, price));
                    }
                    System.out.println(numItems + " menu items added successfully!");
                    break;
                case 3:
                    System.out.print("Enter number of customers to seat: ");
                    int numCustomers = sc.nextInt();
                    for (int i = 0; i < numCustomers; i++) {
                        System.out.println("\nCustomer #" + (i + 1));
                        System.out.print("Enter table number to seat customer: ");
                        int tnum = sc.nextInt();
                        boolean found = false;
                        for (Table t : tables) {
                            if (t.getTableNumber() == tnum) {
                                t.seatCustomer();
                                System.out.println("Customer seated at Table " + tnum);
                                found = true;
                                break;
                            }
                        }
                        if (!found)
                            System.out.println("Table not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter table number: ");
                    int tno = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer name: ");
                    String cname = sc.nextLine();
                    Customer c = new Customer(cname, false);
                    Table selTable = null;
                    for (Table t : tables)
                        if (t.getTableNumber() == tno)
                            selTable = t;

                    Order o = new Order(orderCounter++, selTable, c);
                    while (true) {
                        System.out.println("Enter Menu Item ID to add (0 to finish): ");
                        int mid = sc.nextInt();
                        if (mid == 0) break;
                        MenuItem msel = null;
                        for (MenuItem m : menu)
                            if (m.getItemId() == mid)
                                msel = m;
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        o.addItem(new OrderItem(msel, qty));
                    }
                    orders.add(o);
                    System.out.println("Order created successfully!");
                    break;

                case 5:
                    System.out.print("Enter Order ID to send to kitchen: ");
                    int oid = sc.nextInt();
                    for (Order order : orders) {
                        if (order.getStatus().equals("Pending") && orderCounter > 0) {
                            KitchenTicket kt = new KitchenTicket(ticketCounter++, order);
                            order.setStatus("Sent to Kitchen");
                            kt.displayTicket();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter Order ID to generate bill: ");
                    int bid = sc.nextInt();
                    for (Order order : orders) {
                        if (order.getStatus().equals("Sent to Kitchen")) {
                            Bill bill = new Bill(billCounter++, order);
                            bill.displayBill();
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter Order ID for payment: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Payment method (Cash/Card/UPI): ");
                    String method = sc.nextLine();
                    for (Order order : orders) {
                        if (order.getStatus().equals("Sent to Kitchen")) {
                            Bill bill = new Bill(billCounter++, order);
                            Payment pay = new Payment(paymentCounter++, bill, method);
                            pay.makePayment();
                        }
                    }
                    break;

                case 8:
                    System.out.println("\n--- Tables ---");
                    for (Table t : tables)
                        t.displayTable();
                    System.out.println("\n--- Menu ---");
                    for (MenuItem m : menu)
                        m.displayItem();
                    break;

                case 9:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
