package com.kbbqhost.model;

import java.util.ArrayList;
import java.util.List;

public class PremiumMenu extends Menu {
    private List<Meat> meats;
    private List<SideDish> sideDishes;

    public PremiumMenu() {
        super("Premium Menu", 60.00);

        meats = new ArrayList<>();
        sideDishes = new ArrayList<>();

        meats.add(new Meat("Beef Brisket"));
        meats.add(new Meat("Beef Tongue"));
        meats.add(new Meat("Hanger Steak"));
        meats.add(new Meat("Ribeye Steak"));
        meats.add(new Meat("Boneless Short Rib"));
        meats.add(new Meat("Thin Wagyu"));
        meats.add(new Meat("Wagyu Steak"));
        meats.add(new Meat("Pork Belly"));
        meats.add(new Meat("Pork Jowl"));
        meats.add(new Meat("Spam"));
        meats.add(new Meat("Thin Pork Belly"));
        meats.add(new Meat("Duck Breast"));
        meats.add(new Meat("Lamb Chops"));
        meats.add(new Meat("Lobster Tail"));
        meats.add(new Meat("Scallops"));
        meats.add(new Meat("Shrimp"));
        meats.add(new Meat("Tiger Shrimp"));
        meats.add(new Meat("Beef Bulgogi"));
        meats.add(new Meat("Beef Chunks"));
        meats.add(new Meat("Boneless Kalbi"));
        meats.add(new Meat("LA Kalbi"));
        meats.add(new Meat("Spicy Beef Bulgogi"));
        meats.add(new Meat("Chicken Bulgogi"));
        meats.add(new Meat("Spicy Chicken Bulgogi"));
        meats.add(new Meat("Curry Pork Belly"));
        meats.add(new Meat("Garlic Pork Belly"));
        meats.add(new Meat("Jalapeño Pork Belly"));
        meats.add(new Meat("Pork Bulgogi"));
        meats.add(new Meat("Spicy Pork Belly"));
        meats.add(new Meat("Spicy Pork Bulgogi"));

        sideDishes.add(new SideDish("Kimchi"));
        sideDishes.add(new SideDish("Radish Wrap"));
        sideDishes.add(new SideDish("Pickled Veggies"));
        sideDishes.add(new SideDish("Cucumber Kimchi"));
        sideDishes.add(new SideDish("Yellow Radish"));
        sideDishes.add(new SideDish("Garlic Stems"));
        sideDishes.add(new SideDish("Perilla Leaves"));
        sideDishes.add(new SideDish("Fish Cakes"));
        sideDishes.add(new SideDish("Korean Beansprouts"));
        sideDishes.add(new SideDish("Corn Cheese"));
        sideDishes.add(new SideDish("Fried Dumplings"));
        sideDishes.add(new SideDish("Green Salad"));
        sideDishes.add(new SideDish("Japchae"));
        sideDishes.add(new SideDish("Lettuce Wrap"));
        sideDishes.add(new SideDish("Mushroom Plate"));
        sideDishes.add(new SideDish("Pineapple Slices"));
        sideDishes.add(new SideDish("Roasted Garlic"));
        sideDishes.add(new SideDish("Seaweed"));
        sideDishes.add(new SideDish("Serrano Peppers"));
        sideDishes.add(new SideDish("Soybean Soup"));
        sideDishes.add(new SideDish("Spicy Green Peppers"));
        sideDishes.add(new SideDish("Spicy Radish"));
        sideDishes.add(new SideDish("Spicy Rice Cakes"));
        sideDishes.add(new SideDish("Steamed Egg w/ Cheese"));
        sideDishes.add(new SideDish("Steamed Rice"));
        sideDishes.add(new SideDish("Vegetable Plate"));
        sideDishes.add(new SideDish("Gochujang Sauce"));
        sideDishes.add(new SideDish("Green Chili Sauce"));
    }

    public List<Meat> getMeats()    {
        return meats;
    }

    public List<SideDish> getSideDishes()   {
        return sideDishes;
    }
}
