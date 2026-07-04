import java.io.*;
import java.util.*;

public class FileClass 
{
    public static void fillArray(String fileName, ArrayList<String> list) throws IOException 
    {
        File properties = new File(fileName);
        if (!properties.exists()) {
            throw new FileNotFoundException("File does not exist: " + fileName);
        }
        
        try (Scanner read = new Scanner(properties)) {
            while (read.hasNext()) {
                list.add(read.nextLine());
            }
        }
    }

    public static ArrayList<String> getArrList(String fileName) throws IOException 
    {
        ArrayList<String> list = new ArrayList<>();
        fillArray(fileName, list);
        return list;
    }

    public static void writeTownHToFile() throws IOException 
    {
        ArrayList<String> list = getArrList("properties.txt");
        try (PrintWriter write = new PrintWriter("townhouses.txt")) {
            write.println("TOWNHOUSE PROPERTIES");
            write.println("----------------------------------");
            write.println("Owner\t\tContact\t\tRent");
            write.println("----------------------------------");
            
            for (String currentLine : list) {
                if (currentLine.startsWith("R#") && currentLine.contains("#T#")) {
                    String[] details = currentLine.split("#");
                    if (details.length >= 7) {
                        String name = details[1];
                        String contact = details[2];
                        int bedR = Integer.parseInt(details[5]);
                        int bathR = Integer.parseInt(details[6]);
                        
                        ResProperty res = new ResProperty('R', name, contact, 12, 'T', bedR, bathR);
                        write.printf("%-15s %-15s R%.2f%n", name, contact, res.getMonthlyRent());
                    }
                }
            }
        }
    }
}
