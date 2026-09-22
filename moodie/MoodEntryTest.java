package moodie;

import student.TestCase;

public class MoodEntryTest extends TestCase {

    public void testMoodEntryCreation() {
        MoodEntry entry = new MoodEntry(9, "2026-09-22", "14:45:00");
        
        assertEquals(9, entry.getMoodRating());
        assertEquals("2026-09-22", entry.getDate());
        assertEquals("14:45:00", entry.getTime());
    }
}