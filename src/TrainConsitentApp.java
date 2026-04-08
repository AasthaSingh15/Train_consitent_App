import java.util.*;
import java.util.stream.Collectors;

public class TrainConsitentApp {

    // Bogie class (used in UC7, UC8, UC9)
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
        // UC1
        // =========================
        List<String> trainConsist = new ArrayList<>();
        System.out.println("\nTrain initialized successfully...");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // =========================
        // UC2
        // =========================
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nPassenger Bogies: " + trainConsist);

        // =========================
        // UC3
        // =========================
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");

        System.out.println("\nUnique Bogie IDs: " + bogieIds);

        // =========================
        // UC4
        // =========================
        LinkedList<String> linkedTrain = new LinkedList<>();
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("Cargo");

        System.out.println("\nTrain: " + linkedTrain);

        // =========================
        // UC5
        // =========================
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Guard");

        System.out.println("\nFormation: " + formation);

        // =========================
        // UC6
        // =========================
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);

        System.out.println("\nBogie Capacities:");
        for (Map.Entry<String, Integer> e : capacityMap.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // =========================
        // UC7 - Sorting
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC7 - Sort Bogies by Capacity");
        System.out.println("=================================");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        bogies.sort((b1, b2) -> Integer.compare(b1.capacity, b2.capacity));

        System.out.println("\nAfter Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // =========================
        // UC8 - Filtering
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("=================================");

        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 filtering completed...");

        // =========================
        // UC9 - Grouping
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("=================================");

        List<Bogie> bogiesUC9 = new ArrayList<>();

        bogiesUC9.add(new Bogie("Sleeper", 72));
        bogiesUC9.add(new Bogie("AC Chair", 56));
        bogiesUC9.add(new Bogie("First Class", 24));
        bogiesUC9.add(new Bogie("Sleeper", 70));
        bogiesUC9.add(new Bogie("AC Chair", 60));

        System.out.println("\nAll Bogies:");
        for (Bogie b : bogiesUC9) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        Map<String, List<Bogie>> grouped =
                bogiesUC9.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}