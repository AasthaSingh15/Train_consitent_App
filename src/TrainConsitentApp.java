import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrainConsitentApp {

   static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

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

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(linkedTrain);

        // Remove first and last
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(linkedTrain);

        System.out.println("\nFinal Train Consist:");
        System.out.println(linkedTrain);

        // =========================
        // UC5 - Preserve Insertion Order of Bogies
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("=================================");

        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        trainFormation.add("Sleeper"); // duplicate ignored

        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);

        // =========================
        // UC6 - Bogie Capacity Mapping
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC6 - : ");
        System.out.println("=================================");

        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56); // corrected to match expected
        bogieCapacityMap.put("First Class", 24);

        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        // =========================
        // UC7 - Sort Bogies by Capacity
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("=================================");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Before Sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Sorting using Comparator
        bogies.sort((b1, b2) -> Integer.compare(b1.capacity, b2.capacity));

        // After Sorting
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC7 sorting completed...");
        System.out.println("\n=================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("=================================");

        // All bogies
        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Filter condition (> 60)
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

    }
}