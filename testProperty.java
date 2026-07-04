import java.io.*;
import java.util.*;

public class testProperty {
    public static void main(String[] args) {
        try {
            String fileName = "properties.txt";
            ArrayList<String> properties = FileClass.getArrList(fileName);
            
            displayResidentialProperties(properties);
            displayBusinessProperties(properties);
            
            FileClass.writeTownHToFile();
            System.out.println("\nTownhouse report generated successfully!");
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void displayResidentialProperties(ArrayList<String> properties) {
    System.out.println("\nRESIDENTIAL PROPERTIES");
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Owner\t\tContact\t\tType\tBed\tBath\tRent");
    System.out.println("-----------------------------------------------------------------");
    
    for (String line : properties) {
        if (line.startsWith("R")) {
            try {
                String[] parts = line.split("#");
                if (parts.length >= 7) {
                    // Validate residence type
                    char residenceType = parts[4].charAt(0);
                    if (residenceType != 'F' && residenceType != 'T' && residenceType != 'H') {
                        System.err.println("Invalid residence type in: " + line);
                        continue;
                    }
                    
                    // Parse numeric values safely
                    int contractDuration = Integer.parseInt(parts[3]);
                    int bedrooms = Integer.parseInt(parts[5]);
                    int bathrooms = Integer.parseInt(parts[6]);
                    
                    // Create residential property
                    ResProperty res = new ResProperty(
                        parts[0].charAt(0), 
                        parts[1], 
                        parts[2], 
                        contractDuration, 
                        residenceType, 
                        bedrooms, 
                        bathrooms
                    );

                    System.out.printf("%-15s %-15s %-5s %-5d %-5d R%.2f%n",
                        parts[1], parts[2], parts[4], 
                        bedrooms, bathrooms,
                        res.getMonthlyRent());
                } else {
                    System.err.println("Incomplete residential property data: " + line);
                }
            } catch (NumberFormatException e) {
                System.err.println("Number format error in: " + line);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid data in: " + line + " - " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error processing residential property: " + line);
            }
        }
    }
}


    public static void displayBusinessProperties(ArrayList<String> properties) {
        System.out.println("\nBUSINESS PROPERTIES");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Owner\t\tContact\t\tSize\tInsurance\tRent");
        System.out.println("-----------------------------------------------------------------");
        
        for (String line : properties) {
            if (line.startsWith("B")) {
                try {
                    String[] parts = line.split("#");
                    if (parts.length >= 5) {
                        BussProperty buss = new BussProperty(
                            parts[0].charAt(0),
                            parts[1],
                            parts[2],
                            Integer.parseInt(parts[3]),
                            Double.parseDouble(parts[4])
                        );

                        System.out.printf("%-15s %-15s %-5.1f\tR%-10.2f R%.2f%n",
                            parts[1], parts[2], buss.getSize(), 
                            buss.getInsurance(), buss.getMonthlyRent());
                    }
                } catch (Exception e) {
                    System.err.println("Error processing business property: " + line);
                }
            }
        }
    }
}