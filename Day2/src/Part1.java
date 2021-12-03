import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect number of parameters. Quitting...");
            return;
        }

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            // Check if file is not empty
            if (!scanner.hasNext()) {
                System.out.println("File is empty. Quitting...");
                return;
            }

            int depth = 0;
            int horizontal = 0;

            // Read the data from the file and save it to the object
            while (scanner.hasNext()) {
                switch (scanner.next()) {
                    case "forward" -> horizontal += scanner.nextInt();
                    case "up" -> depth -= scanner.nextInt();
                    case "down" -> depth += scanner.nextInt();
                }
            }

            System.out.println("Result is: " + depth * horizontal);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found.");
        }
    }
}
