package org.aoc.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SecretEntranceTest {
    private secretEntrance entrance;

    @BeforeEach
    public void setUp() {
        entrance = new secretEntrance();
        entrance.reset();
    }

    @Test
    public void firstTest() {
        assertThrows(IOException.class, () -> {
            entrance.sequenceFromFile("");
        });
    }

    @Test
    public void testSequenceFromFile() throws IOException {
        String[] result = entrance.sequenceFromFile("aoc/day1/readTestData");
        assertEquals(1, result.length);
        assertEquals("L68", result[0]);
    }

    @Test
    public void testLineToInt() {
        assertEquals(-30, entrance.lineToInt("L30"));
        assertEquals(20, entrance.lineToInt("R20"));
    }

    @Test
    public void testDay1() {
        int password = entrance.password("aoc/day1/data");
        assertEquals(3, password);
    }

    @Test
    void testClamp(){
        assertEquals(0, secretEntrance.clampPosition(0));
        assertEquals(0, secretEntrance.clampPosition(100));
        assertEquals(0, secretEntrance.clampPosition(-100));
        assertEquals(82, secretEntrance.clampPosition(-18));
        assertEquals(18, secretEntrance.clampPosition(118));
        assertEquals(50, secretEntrance.clampPosition(-50));
    }


    @Test
    public void testOnlyLeft() {
        int password = entrance.password("aoc/day1/onlyLeftData");
        assertEquals(3, password);
    }

    @Test
    public void largeRotation() {
        assertEquals(0, entrance.largeRotation(0));
        assertEquals(0, entrance.largeRotation(100));
        assertEquals(1, entrance.largeRotation(101));
        assertEquals(1, entrance.largeRotation(199));
        assertEquals(0, entrance.largeRotation(-100));
        assertEquals(1, entrance.largeRotation(-101));
        assertEquals(1, entrance.largeRotation(-199));
        assertEquals(1, entrance.largeRotation(-200));
        assertEquals(2, entrance.largeRotation(-201));
        assertEquals(2, entrance.largeRotation(-300));
        assertEquals(2, entrance.largeRotation(300));
    }

    @Test
    public void testClampingNeeded(){
        assertFalse(entrance.clampingNeeded(0));
        assertTrue(entrance.clampingNeeded(-1));
        assertFalse(entrance.clampingNeeded(1));
        assertFalse(entrance.clampingNeeded(100));
        assertTrue(entrance.clampingNeeded(101));
        assertTrue(entrance.clampingNeeded(-101));
    }

    @Test
    public void testDay1d1() {
        int password = entrance.passwordPassingZero("aoc/day1/day1d1Data");
        assertEquals(13, password);
    }
    @Test
    public void testDay1d1Edge() {
        int password = entrance.passwordPassingZero("aoc/day1/day1d1DataEdge");
        assertEquals(4, password);
    }
}