package org.aoc.day2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.aoc.day2.Day2App.logger;

@Service
public class Day2SolverService {
    private final InputReader inputReader;

    public boolean hasEvenLength(int value) {
        return String.valueOf(value).length() % 2 == 0;
    }

    public List<Integer> invalidIdsOfRange(Range range) {

        List<Integer> result = new ArrayList<>(List.of());
        logger.debug(String.valueOf(hasEvenLength(range.lower())));
        logger.debug(String.valueOf(hasEvenLength(range.upper())));
        // simple case: both lower and upper id have odd length -> no invalid ids possible
        if (!hasEvenLength(range.lower()) && !hasEvenLength(range.upper())) {
            return result;
        } else {
            // brute forcing it
            for (int i = range.lower(); i <= range.upper(); i++) {
                if (hasEvenLength(i)) {
                    logger.debug("Working: " + String.valueOf(i));
                    String id = String.valueOf(i);
                    int length = id.length();
                    if (id.substring(0, length / 2).equals(id.substring(length / 2 + 1, length))) {
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
        return new Range(Integer.parseInt(borders[0]), Integer.parseInt(borders[1]));
    }

    public int part1() {
        logger.debug("Running part1");
        List<String> data = this.inputReader.readInput("data");
        logger.debug(String.valueOf(data.toArray().length));

        List<Integer> all_ids = new ArrayList<Integer>();
        for (String line : data) {
            Range record = toRecord(line);
            List<Integer> invalidIds = invalidIdsOfRange(record);
            all_ids.addAll(invalidIds);
        }
        return all_ids.stream().reduce(0, Integer::sum);
    }

    public Day2SolverService(InputReader inputReader) {
        this.inputReader = inputReader;
    }
}
