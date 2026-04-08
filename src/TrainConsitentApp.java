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
        System.out.println("\n=================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=================================");

        try {
            PassengerBogie p = new PassengerBogie("Sleeper", 72);
            System.out.println("\nCreated Bogie: " + p.type + " -> " + p.capacity);
            new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");

        // UC15
        System.out.println("\n=================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=================================");

        GoodsBogieUC15 g1 = new GoodsBogieUC15("Cylindrical");
        g1.assignCargo("Petroleum");

        GoodsBogieUC15 g2 = new GoodsBogieUC15("Rectangular");
        g2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");

        // UC16 - Bubble Sort
        System.out.println("\n=================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("=================================");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("\nOriginal Capacities:");
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

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) System.out.print(c + " ");

        System.out.println("\n\nUC16 sorting completed...");

        // UC17 - Arrays.sort()
        System.out.println("\n=================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("=================================");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("\nOriginal Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");

        // UC18 - Linear Search
        System.out.println("\n=================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("=================================");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";

        System.out.println("\nAvailable Bogie IDs:");
        for (String id : bogieIds) System.out.println(id);

        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("\nBogie " + searchId + " found in train consist.");
        else
            System.out.println("\nBogie not found.");

        System.out.println("\nUC18 search completed...");

        // =========================
        // UC19 - Binary Search
        // =========================
        System.out.println("\n=================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("=================================");

        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure sorted
        Arrays.sort(ids);

        String key = "BG309";

        System.out.println("\nSorted Bogie IDs:");
        for (String id : ids) System.out.println(id);

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

        if (foundBinary)
            System.out.println("\nBogie " + key + " found using Binary Search.");
        else
            System.out.println("\nBogie not found.");

        System.out.println("\nUC19 search completed...");
    }
}