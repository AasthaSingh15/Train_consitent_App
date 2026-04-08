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

    // UC14 - Custom Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

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

    // UC15 - Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
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
        System.out.println(" === Train Consist Management App === ");
        System.out.println("===================================");

        // UC1–UC6 (basic collections)
        List<String> trainConsist = new ArrayList<>();
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");

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
        String cargoCode = "PET-AB";

        boolean validTrain = trainId.matches("TRN-\\d{4}");
        boolean validCargo = cargoCode.matches("PET-[A-Z]{2}");

        // UC12 - Safety
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean safe = goods.stream().allMatch(g ->
                !g.type.equalsIgnoreCase("Cylindrical")
                        || g.cargo.equalsIgnoreCase("Petroleum"));

        // UC13 - Performance
        List<Bogie> test = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            test.add(new Bogie("T" + i, i % 100));
        }

        long t1 = System.nanoTime();
        for (Bogie b : test) {
            if (b.capacity > 60) {}
        }
        long loopTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        test.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        long streamTime = System.nanoTime() - t2;

        // UC14 - Exception
        System.out.println("\nUC14 - Handle Invalid Bogie Capacity");
        try {
            PassengerBogie p1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + p1.type + " -> " + p1.capacity);

            PassengerBogie p2 = new PassengerBogie("AC", 0);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // UC15 - Runtime handling
        System.out.println("\nUC15 - Safe Cargo Assignment");

        GoodsBogieUC15 g1 = new GoodsBogieUC15("Cylindrical");
        g1.assignCargo("Petroleum");

        GoodsBogieUC15 g2 = new GoodsBogieUC15("Rectangular");
        g2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}