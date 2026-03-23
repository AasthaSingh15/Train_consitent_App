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
    }
}
