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
        Long result = solver.part1();
        assertEquals(1227775554, result);
    }

    @Test
    void testSingleRange() {
        List<Long> ids = solver.invalidIdsOfRange(new Range(11,22), solver::isInvalidPart1);
        assertEquals(33, ids.stream().reduce(0L, Long::sum));
    }

    @Test
    void testToRecord() {
        assertEquals(new Range(11, 22), solver.toRecord("11-22"));
    }

    @Test
    void testSingleRangePart2() {
        List<Long> ids = solver.invalidIdsOfRange(new Range(95,115), solver::isInvalidPart2);
        assertEquals(210, ids.stream().reduce(0L, Long::sum));
    }

    @Test
    void testPart2() {
        logger.debug("test");
        List<String> lines = this.inputReader.readInput("data");
        assertEquals(11, lines.toArray().length);
        Long result = solver.part2();
        assertEquals(4174379265L, result);
    }
}
