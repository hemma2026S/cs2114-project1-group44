package moodie;

import student.TestCase;

public class MoodMessageTest extends TestCase {

    public void testGetMessageNormalLow() {
        MoodMessage messenger = new MoodMessage();
        // Normal case: Input is 4. Expected result: Returns a message saying "it's okay to feel this way"[cite: 2].
        String result = messenger.getMessage(4);
        assertTrue(result.contains("it’s okay to feel this way"));
    }

    public void testGetMessageNormalHigh() {
        MoodMessage messenger = new MoodMessage();
        String result = messenger.getMessage(8);
        assertEquals("Keep up the happy mood!", result);
    }

    public void testGetMessageBadInput() {
        MoodMessage messenger = new MoodMessage();
        // Bad case: Input is 15. Expected result: Returns a default error message[cite: 2].
        String result = messenger.getMessage(15);
        assertEquals("Error: Mood rating must be between 1 and 10.", result);
    }
}