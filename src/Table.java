public class Table {
    private int tableNumber;
    private boolean isOccupied;


    public Table(int tableNumber, boolean isOccupied) {
        this.tableNumber = tableNumber;
        this.isOccupied = isOccupied;

    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean getOccupied()  {
        return isOccupied;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setOccupied(boolean isOccupied)   {
        this.isOccupied = isOccupied;
    }
}


