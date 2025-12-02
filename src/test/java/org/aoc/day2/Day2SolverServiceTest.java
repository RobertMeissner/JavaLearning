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
    void testPart1(){
        logger.debug("test");
        List<String> lines = this.inputReader.readInput("data");
        assertEquals(11, lines.toArray().length);
    }
}
