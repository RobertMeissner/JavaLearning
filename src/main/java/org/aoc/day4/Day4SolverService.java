package org.aoc.day4;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.aoc.day4.Day4App.logger4;


@Service
public class Day4SolverService {
    private final InputReader reader;

    public Day4SolverService(InputReader reader) {
        this.reader = reader;
    }

    public long part1() {
        logger4.debug("Running part1");
        List<String> data = reader.readInput("data");
        return 0L;
    }
}
