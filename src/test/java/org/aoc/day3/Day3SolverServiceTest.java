package org.aoc.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Day3SolverServiceTest {
    private InputReader inputReader;
    private Day3SolverService solver;

    @BeforeEach
    public void setUp() {
        ResourceLoader loader = new DefaultResourceLoader();
        inputReader = new InputReader(loader);
        solver = new Day3SolverService(inputReader);
    }

    @Test
    public void testPart1() {
        solver.part1();
        assertFalse(true);
    }
}
