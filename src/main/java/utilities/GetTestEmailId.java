package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetTestEmailId {

    String filePath = "/Users/joshiv7/Documents/M and T/test-exercise/TestEmailIds.txt";

    public String sendTestEmail() throws FileNotFoundException {

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();
    }
}
