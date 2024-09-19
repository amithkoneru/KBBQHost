public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private int maxSeating;
    private Party party;


    public Table(int tableNumber, boolean isOccupied, int maxSeating) {
        this.tableNumber = tableNumber;
        this.isOccupied = isOccupied;
        this.maxSeating = maxSeating;

    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean getOccupied()  {
        return isOccupied;
    }

    public int getMaxSeating()  {
        return maxSeating;
    }

    public void setMaxSeating(int maxSeating)  {
        this.maxSeating = maxSeating;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setOccupied(boolean isOccupied)   {
        this.isOccupied = isOccupied;
    }
}


