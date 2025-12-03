package org.aoc.day2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.aoc.day2.Day2App.logger;

@Component
public class Day2Runner implements CommandLineRunner {
    private final Day2SolverService solver;

    public Day2Runner(Day2SolverService solver){
        this.solver = solver;
    }

    @Override
    public void run(String... args){
        logger.debug("Running day 2{}", (Object) args);
        Long sum = solver.part1();
        logger.info("Sum of invalid ids: {}", sum);
        sum = solver.part2();
        logger.info("Sum of invalid ids part2: {}", sum);
    }
}
