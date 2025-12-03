package org.aoc.day2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.aoc.day2.Day2App.logger;

@Service
public class Day2SolverService {
    private final InputReader inputReader;

    public Day2SolverService(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public boolean hasEvenLength(long value) {
        return String.valueOf(value).length() % 2 == 0;
    }

    public boolean isInvalidPart1(long value) {
        if (!hasEvenLength(value)) return false;
        String id = String.valueOf(value);
        int length = id.length();
        return (id.substring(0, length / 2).equals(id.substring(length / 2, length)));
    }

    public boolean isInvalidPart2(long value) {
        String id = String.valueOf(value);
        int length = id.length();

        if (length < 2) return false;

        // check for repeating patterns
        for (int patternLength = 1; patternLength <= length / 2; patternLength++) {
            if (length % patternLength == 0) {
                String pattern = id.substring(0, patternLength);
                if (id.equals(pattern.repeat(length / patternLength))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Long> invalidIdsOfRange(Range range, Predicate<Long> isInvalid) {
        List<Long> result = new ArrayList<>();
        // brute forcing it
        for (long i = range.lower(); i <= range.upper(); i++) {
            if (isInvalid.test(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public Range fromString(String line) {
        String[] borders = line.split("-");
        return new Range(Long.parseLong(borders[0]), Long.parseLong(borders[1]));
    }

    private Long solve(Predicate<Long> validator, String partName) {
        logger.debug("Running {}", partName);
        List<String> data = inputReader.readInput("data");
        logger.debug("Processing {} lines", data.size());

        return data.stream().map(this::fromString).flatMap(range -> invalidIdsOfRange(range, validator).stream()).mapToLong(Long::longValue).sum();

    }

    public Long part1() {
        return solve(this::isInvalidPart1, "part1");
    }

    public Long part2() {
        return solve(this::isInvalidPart2, "part2");
    }

}
