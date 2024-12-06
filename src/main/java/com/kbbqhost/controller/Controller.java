package com.kbbqhost.controller;

import com.kbbqhost.model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Table> tables;
    private List<Server> servers;

    public Controller(int numberOfTables, int numberOfServers) {
        tables = new ArrayList<>();
        for (int i = 1; i <= numberOfTables; i++) {
            tables.add(new Table(i));
        }

        servers = new ArrayList<>();
        servers = new ArrayList<>();
        servers.add(new Server(1, "Daniel"));
        servers.add(new Server(2, "Monica"));
        servers.add(new Server(3, "Yuki"));
        servers.add(new Server(4, "Eric"));
        servers.add(new Server(4, "Jason"));
        servers.add(new Server(4, "Amber"));
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void seatParty(int tableNumber, int partySize, Menu menu, Server server) {
        Table table = tables.get(tableNumber - 1);
        if (table.isOccupied()) {
            System.out.println("Table " + tableNumber + " is already occupied.");
            return;
        }

        Party party = new Party(partySize, menu);
        table.seatParty(party, server);
        server.assignTable(table);
        System.out.println("Seated party of " + partySize + " at Table " + tableNumber + " with " + menu.getName() + ", served by " + server.getName());
    }

    public double clearTable(int tableNumber) {
        Table table = tables.get(tableNumber - 1);
        if (!table.isOccupied()) {
            System.out.println("Table " + tableNumber + " is already empty.");
            return -1;
        }

        Server server = table.getServer();
        server.removeTable(table);

        Party party = table.getParty();
        double totalPrice = party.calculateTotalPrice();
        System.out.println("Total for Table " + tableNumber + ": $" + totalPrice);

        table.clearTable();
        return totalPrice;
    }

    public void addOrder(int tableNumber, Item item) {
        Table table = tables.get(tableNumber - 1);
        if (!table.isOccupied()) {
            System.out.println("Error: Table " + tableNumber + " is not occupied.");
            return;
        }
        table.getParty().addOrder(item);
        System.out.println("Order added to Table " + tableNumber + ": " + item.getName());
    }

    public void removeOrder(int tableNumber, Item item) {
        Table table = tables.get(tableNumber - 1);
        if (!table.isOccupied()) {
            System.out.println("Error: Table " + tableNumber + " is not occupied.");
            return;
        }
        table.getParty().removeOrder(item);
        System.out.println("Order removed from Table " + tableNumber + ": " + item.getName());
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }
}
