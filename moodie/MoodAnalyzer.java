package moodie;
// -------------------------------------------------------------------------
/**
 *  Gives a weekly average calculated from the sum of mood entries
 * 
 *  @author Seth
 *  @version Sep 18, 2026
 */
import java.util.ArrayList;

public class MoodAnalyzer {
    private double weeklyAverage; // Holds a double for the weekly average[cite: 2]

    // Takes a list of entries and returns the math average[cite: 2]
    public double calculateWeeklyAverage(ArrayList<MoodEntry> weekData) {
        if (weekData == null || weekData.isEmpty()) {
            return 0.0; // Returns 0.0 for an empty list[cite: 2]
        }
        
        double sum = 0;
        for (MoodEntry entry : weekData) {
            sum += entry.getMoodRating();
        }
        
        weeklyAverage = sum / weekData.size(); // Calculates based on logs present[cite: 2]
        return weeklyAverage;
    }
}
