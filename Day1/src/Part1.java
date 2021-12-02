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

            ArrayList<Integer> integers = new ArrayList<>();
            int count = 0;

            // Read the data from the file and save it to the object
            while (scanner.hasNext()) {
                integers.add(scanner.nextInt());
            }

            for (int i = 1; i < integers.size(); i++) {
                if (integers.get(i) > integers.get(i - 1)) count++;
            }

            System.out.println("Count of ascending is: " + count);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found.");
        }
    }
}
