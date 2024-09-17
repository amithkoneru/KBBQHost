public class Dish {
    
    private String name;
    private int maxAllowed;

    public Dish() {


    }

    public Dish(String name, int maxAllowed)  {
        this.name = name;
        this.maxAllowed = maxAllowed;
    }

    public String getName()    {
        return name;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public void setName(String name)    {
        this.name = name;
    }

    public void setMaxAllowed(int maxAllowed)  {
        this.maxAllowed = maxAllowed;
    }


}
