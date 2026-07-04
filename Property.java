public class Property 
{
    private char propertyType;
    private String ownerName;
    private String contactNumber;
    private int contractDuration;

    

    public Property(char propertyType, String ownerName, String contactNumber, int contractDuration) 
    {
        this.propertyType = propertyType;
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
        this.contractDuration = contractDuration;
    }

    // Setters
    public void setPropertyType(char propertyType) 
    {
        this.propertyType = propertyType;
    }

    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public void setContractDuration(int contractDuration) 
    {
        this.contractDuration = contractDuration;
    }

    // Getters
    public char getPropertyType() 
    {
        return propertyType;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }

    public int getContractDuration() 
    {
        return contractDuration;
    }

    // toString
    @Override
    public String toString() 
    {
        return ownerName + " " + contactNumber + " " + contractDuration;
    }
}
