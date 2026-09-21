package moodie;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Tia
 *  @version Sep 18, 2026
 */
public class MoodEntry {
    private int moodRating; // Holds an int for the mood rating[cite: 2]
    private String date;    // Holds a String for the date[cite: 2]
    private String time;    // Holds a String for the time[cite: 2]

    public MoodEntry(int moodRating, String date, String time) {
        this.moodRating = moodRating;
        this.date = date;
        this.time = time;
    }

    // Returns the integer mood rating of the entry[cite: 2]
    public int getMoodRating() {
        return moodRating;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}