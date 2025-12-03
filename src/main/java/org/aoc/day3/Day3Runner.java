package org.aoc.day3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.aoc.day3.Day3App.logger3;

@Component
public class Day3Runner implements CommandLineRunner {
    private final Day3SolverService solver;

    public Day3Runner(Day3SolverService solver){
        this.solver = solver;
    }
    @Override
    public void run(String ... args){
        logger3.debug("Running day3");
        solver.part1();

    }
}
