package moodie;

import student.TestCase;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MoodStorageTest extends TestCase {
    private final String TEST_FILENAME = "test_mood_data.txt";
    private MoodStorage storage;

    // setUp() replaces @BeforeEach in student.TestCase
    public void setUp() {
        storage = new MoodStorage(TEST_FILENAME);
    }

    // tearDown() replaces @AfterEach in student.TestCase
    public void tearDown() {
        // Clean up the test file after each test
        File file = new File(TEST_FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }

    public void testWriteAndLoadDataNormal() {
        MoodEntry entry = new MoodEntry(7, "2026-09-22", "10:30:00");
        storage.writeEntry(entry);

        ArrayList<MoodEntry> loadedEntries = storage.loadData();
        assertEquals(1, loadedEntries.size());
        assertEquals(7, loadedEntries.get(0).getMoodRating());
        assertEquals("2026-09-22", loadedEntries.get(0).getDate());
        assertEquals("10:30:00", loadedEntries.get(0).getTime());
    }

    public void testLoadBadDataFormat() {
        // Manually write badly formatted data to the file to simulate file corruption
        try (FileWriter fw = new FileWriter(TEST_FILENAME)) {
            fw.write("happy,2026-09-22,10:30:00\n"); // "happy" is not an integer
            fw.write("8,2026-09-23,11:00:00\n");     // Valid entry
        } catch (IOException e) {
            fail("Setup for bad data test failed.");
        }

        // The loadData method should skip the bad line and only load the valid one[cite: 2]
        ArrayList<MoodEntry> loadedEntries = storage.loadData();
        
        // Note: student.TestCase (JUnit 3) puts the failure message string first
        assertEquals("Should skip the invalid entry", 1, loadedEntries.size()); 
        assertEquals(8, loadedEntries.get(0).getMoodRating());
    }
}