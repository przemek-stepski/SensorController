import org.junit.jupiter.api.Test;
import tools.Handler;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {
    Handler handler = new Handler();
    String testString = "  test_String ";

    @Test
    void testTrimShouldReturnTrimmedString() {
        String testExpectedResult ="test_String";

        assertEquals(testExpectedResult, handler.trim(testString) );
    }

    @Test
    void testPadToMultipleShouldReturnStringPaddedRightFilledWithHashTo10() {
        String testExpectedResult ="##test_String#";

        assertEquals(testExpectedResult, handler.padToMultiple(testString) );
    }

    @Test
    void testAddTimestampShouldReturnStringWithAddedTimeStapm() {
        Long timeStamp = Instant.now().getEpochSecond();
        String testExpectedResult = "  test_String _" + timeStamp;

        assertEquals(testExpectedResult, handler.addTimestamp(testString));
    }
}