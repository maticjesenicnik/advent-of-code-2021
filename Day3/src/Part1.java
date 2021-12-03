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

            ArrayList<String> binaries = new ArrayList<>();
            StringBuilder gamma = new StringBuilder();
            StringBuilder epsilon = new StringBuilder();

            // Read the data from the file and save it to the object
            while (scanner.hasNext()) {
                binaries.add(scanner.next());
            }

            for(int i = 0; i < binaries.get(0).length(); i++) {
                int countOne = 0, countZero = 0;

                for (String binary : binaries) {
                    if (binary.charAt(i) == '0') countZero++;
                    else countOne++;
                }

                if (countOne > countZero) {
                    gamma.append(1);
                    epsilon.append(0);
                } else {
                    gamma.append(0);
                    epsilon.append(1);
                }
            }

            System.out.println(gamma + " -> " + Integer.parseInt(gamma.toString(), 2));
            System.out.println(epsilon + " -> " + Integer.parseInt(epsilon.toString(), 2));

            System.out.println("Result is: " + Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found.");
        }
    }
}
