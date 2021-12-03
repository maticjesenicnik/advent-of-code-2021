import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
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
            int aim = 0;

            // Read the data from the file and save it to the object
            while (scanner.hasNext()) {
                switch (scanner.next()) {
                    case "forward" -> {
                        int move = scanner.nextInt();
                        depth += aim * move;
                        horizontal += move;
                    }
                    case "up" -> aim -= scanner.nextInt();
                    case "down" -> aim += scanner.nextInt();
                }
            }

            System.out.println("Result is: " + depth * horizontal);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found.");
        }
    }
}
