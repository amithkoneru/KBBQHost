package com.kbbqhost.model;

import java.util.ArrayList;
import java.util.List;

public class RegularMenu extends Menu {
    private List<Meat> meats;
    private List<SideDish> sideDishes;


    public RegularMenu() {
        super("Regular Menu", 35.00);
        meats = new ArrayList<>();
        sideDishes = new ArrayList<>();

        meats.add(new Meat("Beef Brisket"));
        meats.add(new Meat("Beef Tongue"));
        meats.add(new Meat("Pork Belly"));
        meats.add(new Meat("Thin Pork Belly"));
        meats.add(new Meat("Shrimp"));
        meats.add(new Meat("Spam"));
        meats.add(new Meat("Beef Bulgogi"));
        meats.add(new Meat("Beef Chunks"));
        meats.add(new Meat("Spicy Beef Bulgogi"));
        meats.add(new Meat("Chicken Bulgogi"));
        meats.add(new Meat("Spicy Check Bulgogi"));
        meats.add(new Meat("Curry Pork Belly"));
        meats.add(new Meat("Garlic Pork Belly"));
        meats.add(new Meat("Jalapeno Pork Belly"));
        meats.add(new Meat("Pork Bulgogi"));
        meats.add(new Meat("Spicy Pork Belly"));
        meats.add(new Meat("Spicy Pork Bulgogi"));

        sideDishes.add(new SideDish("Kimchi"));
        sideDishes.add(new SideDish("Pickled Veggies"));
        sideDishes.add(new SideDish("Radish Wrap"));
        sideDishes.add(new SideDish("Cucumber Kimchi"));
        sideDishes.add(new SideDish("Korean Beansprouts"));
        sideDishes.add(new SideDish("Corn Cheese"));
        sideDishes.add(new SideDish("Fried Dumplings"));
        sideDishes.add(new SideDish("Green Salad"));
        sideDishes.add(new SideDish("Lettuce Wrap"));
        sideDishes.add(new SideDish("Mushroom Plate"));
        sideDishes.add(new SideDish("Pineapple Slices"));
        sideDishes.add(new SideDish("Roasted Garlic"));
        sideDishes.add(new SideDish("Serrano Peppers"));
        sideDishes.add(new SideDish("Soybean Soup"));
        sideDishes.add(new SideDish("Spicy Rice Cakes"));
        sideDishes.add(new SideDish("Steamed Egg"));
        sideDishes.add(new SideDish("Steamed Rice"));
        sideDishes.add(new SideDish("Vegetable Plate"));
        sideDishes.add(new SideDish("Gochujang Sauce"));
        sideDishes.add(new SideDish("Green Chili Sauce"));
    }

    public List<Meat> getMeats()    {
        return meats;
    }

    public List<SideDish> getSideDishes() {
        return sideDishes;
    }
}
