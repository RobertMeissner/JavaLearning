package org.aoc.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

import static org.aoc.day2.Day2App.logger;

class Day2SolverServiceTest {
    private InputReader inputReader;
    private Day2SolverService solver;

    @BeforeEach
    public void setUp() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        this.inputReader = new InputReader(resourceLoader);
        this.solver = new Day2SolverService(this.inputReader);
    }


    @Test
    void testPart1() {
        logger.debug("test");
        List<String> lines = this.inputReader.readInput("data");
        assertEquals(11, lines.toArray().length);
        int result = solver.part1();
        assertEquals(1227775554, result);
    }

    @Test
    void testSingleRange() {
        List<Integer> ids = solver.invalidIdsOfRange(new Range(11,22));
        assertEquals(33, ids.stream().reduce(0, Integer::sum));
    }

    @Test
    void testToRecord() {
        assertEquals(new Range(11, 22), solver.toRecord("11-22"));
    }
}
