public class BussProperty extends Property implements Propable
 {
    private double size;
    private double insurance;
    private double monthlyRent;

    

    public BussProperty(char propertyType, String ownerName, String contactNumber, 
                        int contractDuration, double size) 
    {
        super(propertyType, ownerName, contactNumber, contractDuration);
        this.size = size;
        this.insurance = calcMonthInsurance();
        this.monthlyRent = calcMonthRent();
    }

    @Override
    public double calcMonthRent() 
    {
        return size * 250;
    }

    public double calcMonthInsurance() 
    {
        return size * 25;
    }

    // Setters
    public void setSize(double size) 
    {
        this.size = size;
    }

    // Getters
    public double getSize() 
    {
        return size;
    }

    public double getInsurance() 
    {
        return insurance;
    }

    public double getMonthlyRent() 
    {
        return monthlyRent;
    }

    // toString
    @Override
    public String toString() 
    {
        return super.toString() + " " + size + " R" + String.format("%.2f", insurance) + " R" + String.format("%.2f", monthlyRent);
    }
}
