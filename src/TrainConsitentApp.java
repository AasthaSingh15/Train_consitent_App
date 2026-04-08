import java.util.Arrays;

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

        // UC14
        System.out.println("\nUC14 - Handle Invalid Bogie Capacity");
        try {
            PassengerBogie p = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + p.type + " -> " + p.capacity);
            new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // UC15
        System.out.println("\nUC15 - Safe Cargo Assignment");
        GoodsBogieUC15 g1 = new GoodsBogieUC15("Cylindrical");
        g1.assignCargo("Petroleum");

        GoodsBogieUC15 g2 = new GoodsBogieUC15("Rectangular");
        g2.assignCargo("Petroleum");

        // UC16 - Bubble Sort
        System.out.println("\nUC16 - Bubble Sort");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int c : capacities) System.out.print(c + " ");

        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSorted Capacities:");
        for (int c : capacities) System.out.print(c + " ");

        // UC17
        System.out.println("\n\nUC17 - Arrays.sort()");
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        // UC18 - Linear Search
        System.out.println("\nUC18 - Linear Search");

        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String search = "BG309";

        boolean found = false;
        for (String id : ids) {
            if (id.equals(search)) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Found" : "Not Found");

        // UC19 - Binary Search
        System.out.println("\nUC19 - Binary Search");

        Arrays.sort(ids);
        String key = "BG309";

        int low = 0, high = ids.length - 1;
        boolean foundBinary = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = ids[mid].compareTo(key);

            if (cmp == 0) {
                foundBinary = true;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(foundBinary ? "Found using Binary Search" : "Not Found");

        // =========================
        // UC20 - Exception Handling During Search
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("=================================");

        // Empty array (fail-fast scenario)
        String[] bogieIds = {};

        String searchId = "BG101";

        // Fail-fast validation
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // This part will not execute if exception occurs
        boolean foundUC20 = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                foundUC20 = true;
                break;
            }
        }

        if (foundUC20)
            System.out.println("Bogie found");
        else
            System.out.println("Bogie not found");

        System.out.println("\nUC20 execution completed...");
    }
}