package md.usm.autotestinglabs;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("D:\\Data\\input.csv"), ',')) {

            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {

                for (String token : nextLine) {
                    System.out.println(token);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}