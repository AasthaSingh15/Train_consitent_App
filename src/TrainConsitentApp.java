import java.util.*;
import java.util.stream.Collectors;

public class TrainConsitentApp {

    // Bogie class (UC7–UC10, UC13)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Goods Bogie class (UC12)
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" === Train Consist Management App === ");
        System.out.println("===================================");

        // UC1
        List<String> trainConsist = new ArrayList<>();
        System.out.println("\nTrain initialized successfully...");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // UC2
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("\nPassenger Bogies: " + trainConsist);

        // UC3
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        System.out.println("\nUnique Bogie IDs: " + bogieIds);

        // UC4
        LinkedList<String> linkedTrain = new LinkedList<>();
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("Cargo");
        System.out.println("\nTrain: " + linkedTrain);

        // UC5
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Guard");
        System.out.println("\nFormation: " + formation);

        // UC6
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);

        System.out.println("\nBogie Capacities:");
        for (Map.Entry<String, Integer> e : capacityMap.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // UC7 - Sorting
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

        // UC8 - Filtering
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

        // UC9 - Grouping
        System.out.println("\n=================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("=================================");

        List<Bogie> bogiesUC9 = new ArrayList<>();
        bogiesUC9.add(new Bogie("Sleeper", 72));
        bogiesUC9.add(new Bogie("AC Chair", 56));
        bogiesUC9.add(new Bogie("First Class", 24));
        bogiesUC9.add(new Bogie("Sleeper", 70));
        bogiesUC9.add(new Bogie("AC Chair", 60));

        Map<String, List<Bogie>> grouped =
                bogiesUC9.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        // UC10 - Reduce
        System.out.println("\n=================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("=================================");

        List<Bogie> bogiesUC10 = new ArrayList<>();
        bogiesUC10.add(new Bogie("Sleeper", 72));
        bogiesUC10.add(new Bogie("AC Chair", 56));
        bogiesUC10.add(new Bogie("First Class", 24));
        bogiesUC10.add(new Bogie("Sleeper", 70));

        int totalSeats = bogiesUC10.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        // UC11 - Regex
        System.out.println("\n=================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("=================================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean isTrainValid = trainId.matches("TRN-\\d{4}");
        boolean isCargoValid = cargoCode.matches("PET-[A-Z]{2}");

        System.out.println("\nTrain ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        // UC12 - Safety
        System.out.println("\n=================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("=================================");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean isSafe = goodsBogies.stream()
                .allMatch(g ->
                        !g.type.equalsIgnoreCase("Cylindrical")
                                || g.cargo.equalsIgnoreCase("Petroleum"));

        System.out.println("\nSafety Compliance Status: " + isSafe);

        // UC13 - Performance
        System.out.println("\n=================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("=================================");

        List<Bogie> testBogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            testBogies.add(new Bogie("Type" + i, i % 100));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long loopTime = System.nanoTime() - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamResult = testBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startStream;

        System.out.println("\nLoop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 completed...");
    }
}