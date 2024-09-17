import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> dishes;
    private Table table;



    public Order(Table table)   {
        this.table = table;
        this.dishes = new ArrayList<>();
    }


    public Table getTable() {
        return table;
    }

    public void addDish(Dish dish)   {
        dishes.add(dish); 
    }

    public void getDishes()    {
        System.out.println("Order for table " + table.getTableNumber() + ":");
        for (int i = 0; i < dishes.size(); i++)    {
            System.out.println(dishes.get(i).getName());
        }
    }





}
