import java.util.*;
import java.util.stream.Collectors;

public class TrainConsitentApp {

    // Bogie class (UC7–UC13)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Goods Bogie (UC12)
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // =========================
    // UC14 - Custom Exception
    // =========================
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie with validation
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
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

        // UC3
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        // UC4
        LinkedList<String> linkedTrain = new LinkedList<>();
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");

        // UC5
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");

        // UC6
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        // UC7 - Sorting
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        bogies.sort((b1, b2) -> Integer.compare(b1.capacity, b2.capacity));

        // UC8 - Filtering
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // UC9 - Grouping
        List<Bogie> bogiesUC9 = new ArrayList<>();
        bogiesUC9.add(new Bogie("Sleeper", 72));
        bogiesUC9.add(new Bogie("AC Chair", 56));
        bogiesUC9.add(new Bogie("First Class", 24));
        bogiesUC9.add(new Bogie("Sleeper", 70));

        Map<String, List<Bogie>> grouped =
                bogiesUC9.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        // UC10 - Reduce
        int totalSeats = bogiesUC9.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // UC11 - Regex
        Scanner scanner = new Scanner(System.in);
        String trainId = "TRN-1234"; // simplified for run
        String cargoCode = "PET-AB";

        boolean isTrainValid = trainId.matches("TRN-\\d{4}");
        boolean isCargoValid = cargoCode.matches("PET-[A-Z]{2}");

        // UC12 - Safety
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean isSafe = goodsBogies.stream()
                .allMatch(g ->
                        !g.type.equalsIgnoreCase("Cylindrical")
                                || g.cargo.equalsIgnoreCase("Petroleum"));

        // UC13 - Performance
        List<Bogie> testBogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            testBogies.add(new Bogie("Type" + i, i % 100));
        }

        long startLoop = System.nanoTime();
        for (Bogie b : testBogies) {
            if (b.capacity > 60) { }
        }
        long loopTime = System.nanoTime() - startLoop;

        long startStream = System.nanoTime();
        testBogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        long streamTime = System.nanoTime() - startStream;

        // =========================
        // UC14 - Exception Handling
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=================================");

        try {
            PassengerBogie valid = new PassengerBogie("Sleeper", 72);
            System.out.println("\nCreated Bogie: " + valid.type + " -> " + valid.capacity);

            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}