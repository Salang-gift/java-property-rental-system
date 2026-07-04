public class ResProperty extends Property implements Propable 
{
    private char residenceType;
    private int bedrooms;
    private int bathrooms;
    private int garages;
    private double monthlyRent;

    

    public ResProperty(char propertyType, String ownerName, String contactNumber,
                  int contractDuration, char residenceType, int bedrooms, int bathrooms) {
    super(propertyType, ownerName, contactNumber, contractDuration);
    
    // Validate residence type
    if (residenceType != 'F' && residenceType != 'T' && residenceType != 'H') {
        throw new IllegalArgumentException("Invalid residence type: " + residenceType);
    }
    
    // Validate bedroom/bathroom counts
    if (bedrooms < 0 || bathrooms < 0) {
        throw new IllegalArgumentException("Bedrooms and bathrooms must be positive");
    }
    
    this.residenceType = residenceType;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.monthlyRent = calcMonthRent();
}

@Override
public double calcMonthRent() 
    {
        switch (residenceType) {
            case 'F': return 8000 + (500 * bedrooms);
            case 'T': return 15000 + (1000 * bedrooms);
            case 'H': return 12000 + (800 * bedrooms);
            default: throw new IllegalArgumentException("Invalid residence type: " + residenceType);

        }
    }

// Setters
public void setResidenceType(char residenceType) 
{
    this.residenceType = residenceType;
}

public void setBedrooms(int bedrooms) 
{
    this.bedrooms = bedrooms;
}

public void setBathrooms(int bathrooms) 
{
    this.bathrooms = bathrooms;
}

// Getters
 public char getResidenceType() 
{
    return residenceType;
}

public int getBedrooms() 
{
    return bedrooms;
}

public int getBathrooms() 
{
    return bathrooms;
}

public double getMonthlyRent() 
{
    return monthlyRent;
}

    // toString
@Override
public String toString() 
{
    return super.toString() + " " + residenceType + " " + bedrooms + " " + bathrooms + " R" + String.format("%.2f", monthlyRent);
}
}
