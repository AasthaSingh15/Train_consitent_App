import java.util.ArrayList;
import java.util.List;

public class TrainConsitentApp {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" ===Train Consist Management App === ");
        System.out.println(" ==================================");

        System.out.println("Train initialized successfully....");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());
        System.out.println("Current train consist: " + trainConsist);

        System.out.println("System ready for operations...");
        System.out.println("=================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("==================================");
        System.out.println("After Adding Bogies:");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("Passenger Bogies :" + trainConsist);
        System.out.println("After Removing 'AC Chair':");
        trainConsist.remove("AC Chair");
        System.out.println("Passenger Bogies :" + trainConsist);
        System.out.println("Checking if 'Sleeper' exist:");
        System.out.println("Contains sleeper? :" + trainConsist.contains("Sleeper"));
        System.out.println("Final Train Passenger Consist:");
        System.out.println(trainConsist);

    }
}
