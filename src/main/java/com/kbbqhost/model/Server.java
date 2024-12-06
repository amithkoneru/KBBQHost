package com.kbbqhost.model;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private int id;
    private String name;
    private List<Table> assignedTables;

    public Server(int id, String name)  {
        this.id = id;
        this.name = name;
        this.assignedTables = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Table> getAssignedTables() {
        return assignedTables;
    }

    public void assignTable(Table table) {
        if (!assignedTables.contains(table)) {
            assignedTables.add(table);
        }
    }

    public void removeTable(Table table) {
        assignedTables.remove(table);
    }

    public String toString() {
        return getName();
    }
}
