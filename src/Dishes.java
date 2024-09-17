public class Dishes {
    
    private String name;
    private int maxAllowed;

    public Dishes() {


    }

    public Dishes(String name, int maxAllowed)  {
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
