public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isOccupied;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void seatCustomer() {
        if (!isOccupied) {
            isOccupied = true;
        } else {
            System.out.println("Table already occupied!");
        }
    }

    public void freeTable() {
        isOccupied = false;
    }

    public void displayTable() {
        System.out.println("Table " + tableNumber + " | Capacity: " + capacity +" | Status: " + (isOccupied ? "Occupied" : "Available"));
    }
}
