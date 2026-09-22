package moodie;

import student.TestCase;
import java.util.ArrayList;

public class MoodAnalyzerTest extends TestCase {

    public void testCalculateWeeklyAverageNormal() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        ArrayList<MoodEntry> weekData = new ArrayList<>();
        
        // Normal case: Input is a list with ratings 5, 5, and 8. Expected result: returns 6.0[cite: 2].
        weekData.add(new MoodEntry(5, "2026-09-22", "09:00:00"));
        weekData.add(new MoodEntry(5, "2026-09-23", "09:00:00"));
        weekData.add(new MoodEntry(8, "2026-09-24", "09:00:00"));

        double average = analyzer.calculateWeeklyAverage(weekData);
        assertEquals(6.0, average, 0.001);
    }

    public void testCalculateWeeklyAverageEmpty() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        ArrayList<MoodEntry> emptyData = new ArrayList<>();
        
        // Bad case: Input is an empty list. Expected result: returns 0.0[cite: 2].
        double average = analyzer.calculateWeeklyAverage(emptyData);
        assertEquals(0.0, average, 0.001);
    }
    
    public void testCalculateWeeklyAverageNull() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        // Also handling null input safely as a defensive programming measure
        double average = analyzer.calculateWeeklyAverage(null);
        assertEquals(0.0, average, 0.001);
    }
}