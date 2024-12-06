package com.kbbqhost.model;

public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private Party party;
    private Server server;

    public Table(int tableNumber)   {
        this.tableNumber = tableNumber;
        this.isOccupied = false;
    }

    public void seatParty(Party party, Server server)    {
        this.party = party;
        this.server = server;
        this.isOccupied = true;
    }

    public void clearTable()    {
        this.party = null;
        this.server = null;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Party getParty() {
        return party;
    }

    public Server getServer() {
        return server;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}

