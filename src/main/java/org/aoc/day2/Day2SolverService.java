package org.aoc.day2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.aoc.day2.Day2App.logger;

@Service
public class Day2SolverService {
    private final InputReader inputReader;

    public boolean hasEvenLength(long value) {
        return String.valueOf(value).length() % 2 == 0;
    }

    public List<Long> invalidIdsOfRange(Range range) {

        List<Long> result = new ArrayList<>(List.of());
        // simple case: both lower and upper id have odd length -> no invalid ids possible
        if (!hasEvenLength(range.lower()) && !hasEvenLength(range.upper())) {
            return result;
        } else {
            // brute forcing it
            for (long i = range.lower(); i <= range.upper(); i++) {
                if (hasEvenLength(i)) {
                    String id = String.valueOf(i);
                    int length = id.length();
                    if (id.substring(0, length / 2).equals(id.substring(length / 2, length))) {
                        result.add(i);
                    }
                }
            }
        }


        logger.debug("result: " + String.valueOf(result));
        return result;
    }

    public Range toRecord(String line) {
        String[] borders = line.split("-");
        return new Range(Long.parseLong(borders[0]), Long.parseLong(borders[1]));
    }

    public Long part1() {
        logger.debug("Running part1");
        List<String> data = this.inputReader.readInput("data");
        logger.debug(String.valueOf(data.toArray().length));

        List<Long> all_ids = new ArrayList<Long>();
        for (String line : data) {
            Range record = toRecord(line);
            List<Long> invalidIds = invalidIdsOfRange(record);
            all_ids.addAll(invalidIds);
        }
        return all_ids.stream().reduce(0L, Long::sum);
    }

    public Day2SolverService(InputReader inputReader) {
        this.inputReader = inputReader;
    }
}
