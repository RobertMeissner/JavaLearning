package org.aoc.day4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.aoc.day4.Day4App.logger4;

@Component
public class Day4Runner implements CommandLineRunner {
    private Day4SolverService service;

    public Day4Runner(Day4SolverService service) {
        this.service = service;

    }

    @Override
    public void run(String... args) throws Exception {
        logger4.debug("Running day 4.");
        long result = service.part1();
        logger4.info("Result part1: {}", result);
    }
}
