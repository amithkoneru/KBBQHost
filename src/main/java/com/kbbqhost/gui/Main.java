package com.kbbqhost.gui;

import com.kbbqhost.controller.Controller;
import com.kbbqhost.model.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main extends Application {
    private Controller controller;
    private Map<Integer, Button> tableButtons;

    @Override
    public void start(Stage primaryStage) {
        controller = new Controller(25, 5);
        tableButtons = new HashMap<>();

        GridPane tableLayout = createTableLayout();
        VBox controls = createControlButtons();

        HBox root = new HBox(20, tableLayout, controls);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("KBBQ Hosting Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createTableLayout() {
        GridPane tableLayout = new GridPane();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int tableNumber = i * 5 + j + 1;
                Button tableButton = new Button("Table " + tableNumber + "\nAvailable");
                tableButton.setMinSize(120, 120);
                tableButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-width: 1;");
                tableButton.setOnAction(e -> handleTableClick(tableNumber));
                tableLayout.add(tableButton, j, i);
                tableButtons.put(tableNumber, tableButton);
            }
        }
        return tableLayout;
    }

    private VBox createControlButtons() {
        Button seatPartyButton = new Button("Seat Party");
        seatPartyButton.setOnAction(e -> handleSeatParty());

        Button clearTableButton = new Button("Clear Table");
        clearTableButton.setOnAction(e -> handleClearTable());

        Button editServersButton = new Button("Edit Servers");
        editServersButton.setOnAction(e -> handleEditServers());

        VBox controls = new VBox(10, seatPartyButton, clearTableButton, editServersButton);
        controls.setPadding(new Insets(10));
        return controls;
    }

    private void handleTableClick(int tableNumber) {
        Table table = controller.getTables().get(tableNumber - 1);
        Stage stage = new Stage();
        VBox details = new VBox(10);
        details.setPadding(new Insets(10));

        if (table.isOccupied()) {
            Party party = table.getParty();
            Server server = table.getServer();
            details.getChildren().add(new Label("Party Size: " + party.getSize()));
            details.getChildren().add(new Label("Server: " + server.getName()));
            details.getChildren().add(new Label("Menu: " + party.getMenu().getName()));
            details.getChildren().add(new Label("Meats Ordered: " + countOrderedItems(party, Meat.class)));
            details.getChildren().add(new Label("Side Dishes Ordered: " + countOrderedItems(party, SideDish.class)));

            ListView<Item> orderedItemsList = new ListView<>();
            orderedItemsList.getItems().addAll(party.getOrderedItems());
            details.getChildren().add(new Label("Ordered Items:"));
            details.getChildren().add(orderedItemsList);

            Button addOrderButton = new Button("Add Order");
            addOrderButton.setOnAction(e -> handleAddOrder(stage, tableNumber));

            Button removeOrderButton = new Button("Remove Order");
            removeOrderButton.setOnAction(e -> handleRemoveOrder(stage, tableNumber, orderedItemsList));

            details.getChildren().addAll(addOrderButton, removeOrderButton);
        } else {
            details.getChildren().add(new Label("Table " + tableNumber + " is available."));
        }

        Scene scene = new Scene(details, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Table " + tableNumber + " Details");
        stage.show();
    }

    private void handleSeatParty() {
        TextInputDialog tableDialog = new TextInputDialog();
        tableDialog.setTitle("Seat Party");
        tableDialog.setHeaderText("Enter the table number:");
        Optional<String> tableResult = tableDialog.showAndWait();

        if (tableResult.isPresent()) {
            int tableNumber;
            try {
                tableNumber = Integer.parseInt(tableResult.get());
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid number.");
                return;
            }

            if (tableNumber < 1 || tableNumber > controller.getTables().size()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Table " + tableNumber + " does not exist.");
                return;
            }

            if (controller.getTables().get(tableNumber - 1).isOccupied()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Table " + tableNumber + " is already occupied.");
                return;
            }

            TextInputDialog sizeDialog = new TextInputDialog();
            sizeDialog.setTitle("Party Size");
            sizeDialog.setHeaderText("Enter the size of the party:");
            Optional<String> sizeResult = sizeDialog.showAndWait();

            if (!sizeResult.isPresent()) return;

            int partySize;
            try {
                partySize = Integer.parseInt(sizeResult.get());
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid number for party size.");
                return;
            }

            List<com.kbbqhost.model.Menu> menus = List.of(new RegularMenu(), new PremiumMenu());
            ChoiceDialog<com.kbbqhost.model.Menu> menuDialog = new ChoiceDialog<>(menus.get(0), menus);
            menuDialog.setTitle("Menu Selection");
            menuDialog.setHeaderText("Choose a menu:");
            Optional<com.kbbqhost.model.Menu> menuResult = menuDialog.showAndWait();

            if (!menuResult.isPresent()) return;
            com.kbbqhost.model.Menu chosenMenu = menuResult.get();

            List<Server> servers = controller.getServers();
            if (servers.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "No Servers", "No servers are available to serve.");
                return;
            }

            ChoiceDialog<Server> serverDialog = new ChoiceDialog<>(servers.get(0), servers);
            serverDialog.setTitle("Choose Server");
            serverDialog.setHeaderText("Select a server to handle this table:");
            Optional<Server> serverResult = serverDialog.showAndWait();

            if (!serverResult.isPresent()) return;
            Server chosenServer = serverResult.get();

            controller.seatParty(tableNumber, partySize, chosenMenu, chosenServer);

            Button tableButton = tableButtons.get(tableNumber);
            tableButton.setText("Table " + tableNumber + "\nOccupied");
            tableButton.setStyle("-fx-background-color: lightcoral; -fx-border-color: black; -fx-border-width: 1;");
        }
    }

    private void handleClearTable() {
        TextInputDialog tableDialog = new TextInputDialog();
        tableDialog.setTitle("Clear Table");
        tableDialog.setHeaderText("Enter the table number to clear:");
        Optional<String> tableResult = tableDialog.showAndWait();

        if (tableResult.isPresent()) {
            int tableNumber;
            try {
                tableNumber = Integer.parseInt(tableResult.get());
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid table number.");
                return;
            }

            if (tableNumber < 1 || tableNumber > controller.getTables().size()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Table " + tableNumber + " does not exist.");
                return;
            }

            double totalPrice = controller.clearTable(tableNumber);

            if (totalPrice == -1) {
                showAlert(Alert.AlertType.ERROR, "Error", "Table " + tableNumber + " is already empty.");
            } else {
                showAlert(Alert.AlertType.INFORMATION, "Total Bill", "The total cost of the party's bill is: $" + totalPrice);

                Button tableButton = tableButtons.get(tableNumber);
                tableButton.setText("Table " + tableNumber + "\nAvailable");
                tableButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-width: 1;");
            }
        }
    }

    private void handleEditServers() {
        Stage stage = new Stage();
        stage.setTitle("Edit Servers");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        ListView<Server> serverListView = new ListView<>();
        serverListView.getItems().addAll(controller.getServers());

        TextField nameField = new TextField();
        nameField.setPromptText("Enter server name");

        Button addServerButton = new Button("Add Server");
        addServerButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                addServer(name, serverListView);
                nameField.clear();
            } else {
                showAlert(Alert.AlertType.WARNING, "Invalid Input", "Please enter a server name.");
            }
        });

        Button removeServerButton = new Button("Remove Selected Server");
        removeServerButton.setOnAction(e -> {
            Server selected = serverListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                removeServer(selected, serverListView);
            } else {
                showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a server to remove.");
            }
        });

        HBox addRemoveBox = new HBox(10, nameField, addServerButton, removeServerButton);
        root.getChildren().addAll(new Label("Servers:"), serverListView, addRemoveBox);

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void handleAddOrder(Stage stage, int tableNumber) {
        Table table = controller.getTables().get(tableNumber - 1);
        com.kbbqhost.model.Menu menu = table.getParty().getMenu();

        List<Meat> meats;
        List<SideDish> sideDishes;

        if (menu instanceof RegularMenu regularMenu) {
            meats = regularMenu.getMeats();
            sideDishes = regularMenu.getSideDishes();
        } else if (menu instanceof PremiumMenu premiumMenu) {
            meats = premiumMenu.getMeats();
            sideDishes = premiumMenu.getSideDishes();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Unknown menu type.");
            return;
        }

        ChoiceDialog<String> categoryDialog = new ChoiceDialog<>("Meats", "Meats", "Side Dishes");
        categoryDialog.setTitle("Select Category");
        categoryDialog.setHeaderText("Which category would you like to order from?");
        Optional<String> categoryResult = categoryDialog.showAndWait();

        if (categoryResult.isPresent()) {
            String category = categoryResult.get();
            if (category.equals("Meats")) {
                if (meats.isEmpty()) {
                    showAlert(Alert.AlertType.WARNING, "No Items", "No meat items available.");
                    return;
                }
                ChoiceDialog<Item> meatDialog = new ChoiceDialog<>(meats.get(0), new ArrayList<>(meats));
                meatDialog.setTitle("Add Meat Order");
                meatDialog.setHeaderText("Choose a meat item to add:");
                handleChoiceDialog(meatDialog, tableNumber, stage);

            } else if (category.equals("Side Dishes")) {
                if (sideDishes.isEmpty()) {
                    showAlert(Alert.AlertType.WARNING, "No Items", "No side dish items available.");
                    return;
                }
                ChoiceDialog<Item> sideDishDialog = new ChoiceDialog<>(sideDishes.get(0), new ArrayList<>(sideDishes));
                sideDishDialog.setTitle("Add Side Dish Order");
                sideDishDialog.setHeaderText("Choose a side dish item to add:");
                handleChoiceDialog(sideDishDialog, tableNumber, stage);
            }
        }
    }

    private void handleChoiceDialog(ChoiceDialog<Item> dialog, int tableNumber, Stage stage) {
        Optional<Item> result = dialog.showAndWait();
        result.ifPresent(item -> {
            controller.addOrder(tableNumber, item);
            stage.close();
            handleTableClick(tableNumber);
        });
    }

    private void handleRemoveOrder(Stage stage, int tableNumber, ListView<Item> orderedItemsList) {
        Item selectedItem = orderedItemsList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            controller.removeOrder(tableNumber, selectedItem);
            stage.close();
            handleTableClick(tableNumber);
        } else {
            showAlert(Alert.AlertType.WARNING, "Warning", "No item selected.");
        }
    }

    private int countOrderedItems(Party party, Class<? extends Item> type) {
        return (int) party.getOrderedItems().stream().filter(type::isInstance).count();
    }

    private void addServer(String name, ListView<Server> serverListView) {
        int newId = controller.getServers().size() + 1;
        Server newServer = new Server(newId, name);
        controller.addServer(newServer);
        serverListView.getItems().clear();
        serverListView.getItems().addAll(controller.getServers());
    }

    private void removeServer(Server server, ListView<Server> serverListView) {
        controller.removeServer(server);
        serverListView.getItems().clear();
        serverListView.getItems().addAll(controller.getServers());
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
