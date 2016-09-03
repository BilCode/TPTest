package bil.learn.tutpoint.Test;

import bil.learn.tutpoint.Testing;
import bil.learn.tutpoint.Tests;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProgramTest {
    @Test
    public void testGetFirstNonRepeatedChar() {
        assertEquals('b', Testing.firstNonRepeative("abcdefghija"));
        assertEquals('h', Testing.firstNonRepeative("hello"));
        assertEquals('J', Testing.firstNonRepeative("Java"));
        assertEquals('i', Testing.firstNonRepeative("simplest"));
    }

}
