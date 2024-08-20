package ProjectV6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) throws IOException {
    
        List<String> listOfPatients = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader("Patients.txt"));

        String line = reader.readLine();

        while (line != null) {
            listOfPatients.add(line);
            line = reader.readLine();
        }

        reader.close();
       // listOfPatients.toArray(Reception.addPatient)

        String[] array = listOfPatients.toArray(new String[0]);

        for (String str : array) {
            System.out.println(str);
        }
    }
    
}
