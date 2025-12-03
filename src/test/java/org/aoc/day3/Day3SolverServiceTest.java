package org.aoc.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3SolverServiceTest {
    private Day3SolverService solver;

    @BeforeEach
    public void setUp() {
        ResourceLoader loader = new DefaultResourceLoader();
        InputReader inputReader = new InputReader(loader);
        solver = new Day3SolverService(inputReader);
    }

    @Test
    public void testPart1() {
        Integer result = solver.part1();
        assertEquals(357,result);
    }
    @Test
    public void testPart2() {
        Long result = solver.part2();
        assertEquals(3121910778619L,result);
    }
}
