package moodie;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Emma
 *  @version Sep 18, 2026
 */
public class MoodMessage {
    
    // Returns a specific daily message based on the 1-10 rating[cite: 2]
    public String getMessage(int mood) {
        if (mood >= 1 && mood <= 5) {
            return "We’re sorry you’re not feeling the best, but remember it’s okay to feel this way and to take a moment for yourself."; //[cite: 1]
        } else if (mood >= 6 && mood <= 10) {
            return "Keep up the happy mood!"; //[cite: 1]
        } else {
            return "Error: Mood rating must be between 1 and 10."; //[cite: 2]
        }
    }
}