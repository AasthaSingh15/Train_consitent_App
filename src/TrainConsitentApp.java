import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class TrainConsitentApp {
    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" === Train Consist Management App === ");
        System.out.println("===================================");

        // =========================
        // UC1 - Initialization
        // =========================
        System.out.println("\nTrain initialized successfully...");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Initial bogie count: " + trainConsist.size());
        System.out.println("Current train consist: " + trainConsist);

        System.out.println("System ready for operations...");

        // =========================
        // UC2 - Add / Remove Bogies
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC2 - Add Passenger Bogies");
        System.out.println("=================================");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + trainConsist);

        System.out.println("Contains Sleeper? " + trainConsist.contains("Sleeper"));

        System.out.println("Final Train Passenger Consist:");
        System.out.println(trainConsist);

        // =========================
        // UC3 - Unique Bogie IDs
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC3 - Unique Bogie ID Management");
        System.out.println("=================================");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIds);

        // =========================
        // UC4 - LinkedList Operations
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC4 - Advanced Train Operations");
        System.out.println("=================================");

        LinkedList<String> linkedTrain = new LinkedList<>();

        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(linkedTrain);

        // Insert Pantry at index 2
        linkedTrain.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting Pantry  Car at position 2:");
        System.out.println(linkedTrain);

        // Remove first and last
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(linkedTrain);


    }
}