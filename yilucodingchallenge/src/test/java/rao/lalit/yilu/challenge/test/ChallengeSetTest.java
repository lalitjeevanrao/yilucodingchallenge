package rao.lalit.yilu.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rao.lalit.yilu.challenge.ChallengeSet;

public class ChallengeSetTest {
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void rotationTest() {
        assertTrue(ChallengeSet.checkRotation("abc", "bca"));
        assertTrue(ChallengeSet.checkRotation("pqrs", "rspq"));
        assertFalse(ChallengeSet.checkRotation("lalit", "lirtla"));
        assertFalse(ChallengeSet.checkRotation("rao", null));
        assertFalse(ChallengeSet.checkRotation("abc", ""));
        assertFalse(ChallengeSet.checkRotation(null, ""));
        assertFalse(ChallengeSet.checkRotation(null, null));
    }
    
    @Test
    public void nonRepeatedCharacterTest() {
        assertEquals(ChallengeSet.nonRepeatedCharacterCheck("lalit"), 'a');
        assertEquals(ChallengeSet.nonRepeatedCharacterCheck("rao"), 'r');
        
        char c = ChallengeSet.nonRepeatedCharacterCheck("rao");
        assertFalse(c == 'a');
        
        assertEquals(ChallengeSet.nonRepeatedCharacterCheck("Lalit", false), 'a');
        
        assertEquals(ChallengeSet.nonRepeatedCharacterCheck("Lalit", true), 'L');
        
        exception.expect(RuntimeException.class);
        assertEquals(ChallengeSet.nonRepeatedCharacterCheck(null), 'r');
    }

}
