
package moodie;

import java.io.*;
import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 *  Storage class for moodie program 
 * 
 *  @author Mikey
 *  @version Sep 18, 2026
 */
public class MoodStorage {
    private String filename; // Holds a String for the filename[cite: 2]

    public MoodStorage(String filename) {
        this.filename = filename;
    }

    // Appends a single mood entry to the text file[cite: 2]
    public void writeEntry(MoodEntry entry) {
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(entry.getMoodRating() + "," + entry.getDate() + "," + entry.getTime());
        } catch (IOException e) {
            System.out.println("Error saving entry to " + filename);
        }
    }

    // Reads the text file and returns a list of past entries[cite: 2]
    public ArrayList<MoodEntry> loadData() {
        ArrayList<MoodEntry> entries = new ArrayList<>();
        File file = new File(filename);
        
        if (!file.exists()) {
            return entries;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // Checks that integers and strings are formatted correctly[cite: 2]
                if (parts.length == 3) {
                    try {
                        int mood = Integer.parseInt(parts[0]);
                        entries.add(new MoodEntry(mood, parts[1], parts[2]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid data format detected in file. Skipping entry."); //[cite: 2]
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + filename);
        }
        return entries;
    }
}
