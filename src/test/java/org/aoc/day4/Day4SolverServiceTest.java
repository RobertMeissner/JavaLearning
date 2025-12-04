package org.aoc.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import static org.junit.jupiter.api.Assertions.*;

class Day4SolverServiceTest {
    private Day4SolverService service;

    @BeforeEach
    public void setUp() {
        ResourceLoader loader = new DefaultResourceLoader();
        InputReader reader = new InputReader(loader);
        service = new Day4SolverService(reader);
    }

    @Test
    public void testPart1() {
        assertEquals(0L, service.part1());
    }
}