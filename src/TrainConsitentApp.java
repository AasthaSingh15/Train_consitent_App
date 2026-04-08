import java.util.*;
import java.util.stream.Collectors;

public class TrainConsitentApp {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // UC14 Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String msg) {
            super(msg);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0)
                throw new InvalidCapacityException("Capacity must be greater than zero");
            this.type = type;
            this.capacity = capacity;
        }
    }

    // UC15 Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String msg) {
            super(msg);
        }
    }

    static class GoodsBogieUC15 {
        String shape;
        String cargo;

        GoodsBogieUC15(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("\nCargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("\nError: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println("Train Consist Management App");
        System.out.println("===================================");

        // UC7 - Sorting
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        bogies.sort((a, b) -> a.capacity - b.capacity);

        // UC8 - Filter
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // UC9 - Group
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        // UC10 - Reduce
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // UC11 - Regex
        String trainId = "TRN-1234";
        boolean validTrain = trainId.matches("TRN-\\d{4}");

        // UC12 - Safety
        List<String> safety = Arrays.asList("Petroleum", "Coal");

        // UC13 - Performance (short)
        long t1 = System.nanoTime();
        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        long t2 = System.nanoTime();

        // UC14
        System.out.println("\nUC14 - Exception Handling");
        try {
            PassengerBogie p = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + p.type + " -> " + p.capacity);
            new PassengerBogie("AC", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // UC15
        System.out.println("\nUC15 - Runtime Handling");
        GoodsBogieUC15 g1 = new GoodsBogieUC15("Cylindrical");
        g1.assignCargo("Petroleum");

        GoodsBogieUC15 g2 = new GoodsBogieUC15("Rectangular");
        g2.assignCargo("Petroleum");

        // UC16 - Bubble Sort
        System.out.println("\nUC16 - Bubble Sort");

        int[] capacities = {72, 56, 24, 70, 60};

        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // UC17 - Arrays.sort()
        System.out.println("\nUC17 - Arrays.sort()");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original: " + Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("Sorted: " + Arrays.toString(bogieNames));

        // =========================
        // UC18 - Linear Search
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("=================================");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";

        System.out.println("\nAvailable Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}