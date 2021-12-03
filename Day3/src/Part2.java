import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

            ArrayList<String> binaries = new ArrayList<>();

            // Read the data from the file and save it to the object
            while (scanner.hasNext()) {
                binaries.add(scanner.next());
            }

            String oxygenRating = GetGeneratorRatingFromArrayForIndex(binaries, 0).get(0);
            String scrubberRating = GetScrubberRatingFromArrayForIndex(binaries, 0).get(0);

            System.out.println("Result is: " + Integer.parseInt(oxygenRating, 2) * Integer.parseInt(scrubberRating, 2));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found.");
        }
    }

    public static ArrayList<String> GetGeneratorRatingFromArrayForIndex (ArrayList<String> binaries, int index) {
        int countOne = 0, countZero = 0;
        ArrayList<String> result = new ArrayList<>();

        for (String binary : binaries) {
            if (binary.charAt(index) == '0') countZero++;
            else countOne++;
        }

        char mostOccurrences = countZero > countOne ? '0' : '1';
        for (String binary: binaries) {
            if (binary.charAt(index) == mostOccurrences) result.add(binary);
        }

        return result.size() == 1 ? result : GetGeneratorRatingFromArrayForIndex(result, index + 1);
    }

    public static ArrayList<String> GetScrubberRatingFromArrayForIndex (ArrayList<String> binaries, int index) {
        int countOne = 0, countZero = 0;
        ArrayList<String> result = new ArrayList<>();

        for (String binary : binaries) {
            if (binary.charAt(index) == '0') countZero++;
            else countOne++;
        }

        char leastOccurrences = countZero <= countOne ? '0' : '1';
        for (String binary: binaries) {
            if (binary.charAt(index) == leastOccurrences) result.add(binary);
        }

        return result.size() == 1 ? result : GetScrubberRatingFromArrayForIndex(result, index + 1);
    }
}
