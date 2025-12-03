package org.aoc.day3;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.aoc.day3.Day3App.logger3;

@Service
public class Day3SolverService {
    private final InputReader inputReader;

    public Day3SolverService(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void part1() {
        logger3.debug("Running part1");
        List<String> data = inputReader.readInput("data");
        logger3.debug("Number of banks {}. Number of batteries {}", data.size(), data.get(0).length());
        // load data
        // find largest element
        // if it is last -> search for next largest element, both of them make up the largest jolt
        // if it is not last -> find the next largest element -> largest jolt
    }
}
