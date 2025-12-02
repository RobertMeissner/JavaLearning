package org.aoc.day2;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.aoc.day2.Day2App.logger;

@Service
public class Day2SolverService {
    private final InputReader inputReader;

    public void part1(){
        logger.debug("Running part1");
        List<String> data = this.inputReader.readInput("data");
        logger.debug(data.toArray().length);

    }

    public Day2SolverService(InputReader inputReader) {
        this.inputReader = inputReader;
    }
}
