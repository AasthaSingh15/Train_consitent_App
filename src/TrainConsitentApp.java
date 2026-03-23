import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TrainConsitentApp {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" === Train Consist Management App === ");
        System.out.println("===================================");

        System.out.println("Train initialized successfully....");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Initial bogie count: " + trainConsist.size());
        System.out.println("Current train consist: " + trainConsist);

        System.out.println("System ready for operations...");

        System.out.println("=================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("=================================");

        // Add bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + trainConsist);

        // Remove bogie
        System.out.println("After Removing 'AC Chair':");
        trainConsist.remove("AC Chair");
        System.out.println("Passenger Bogies: " + trainConsist);

        // Check existence
        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? " + trainConsist.contains("Sleeper"));

        System.out.println("Final Train Passenger Consist:");
        System.out.println(trainConsist);

        System.out.println("=================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("=================================");

        // Create a HashSet for bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG102"); // Duplicate

        // Display unique bogie IDs
        System.out.println("Bogies IDs After Insertion:");
        System.out.println(bogieIds);
    }
}