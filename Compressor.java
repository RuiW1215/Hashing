import java.util.*;
import java.io.*;

public class Compress {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        String filename = args[0];
        File file = new File(filename);

        // Log file contents
        int fileSize;
        int newFileSize;
        long startTime;
        long endTime;
        double hashTableLoad;
        double avgLinkedListSize;
        int longestLinkedList;
        int dicEntries;
        int rehashes;


        boolean validFile = false;
        while (validFile == false) {
            if (file.exists() != true){
                System.out.println("File does not exist. Please input an existing file: ");
                filename = input.nextLine();
            }
            else {
                validFile = true;
            }
        }

        FileInputStream inputS = new FileInputSteam("inputFile.txt");
        char currentChar;
        int key = 0;
        String code = "";

        while ((currentChar = inputS.read()) != -1 ) {
            System.out.println(currentChar);
        }
        /* Could convert file into string OR
        *  compress AS the file is being read in
        */
        HashTable dictionary = new HashTable();
    }
}
