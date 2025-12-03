package org.aoc.day3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.aoc.day3.Day3App.logger3;

@Service
public class Day3SolverService {
    private final InputReader inputReader;

    public Day3SolverService(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int part1() {
        logger3.debug("Running part1");
        List<String> data = inputReader.readInput("data");
        logger3.debug("Number of banks {}. Number of batteries {}", data.size(), data.get(0).length());

        ArrayList<Integer> result = new ArrayList<>();
        for (String line : data) {
            List<Integer> batteries = Arrays.stream(line.split("")).map(Integer::parseInt).toList();
            int maxBattery = Collections.max(batteries);
            int maxIndex = batteries.indexOf(maxBattery);
            // next largest

            int max2ndBattery = 0;
            int joltage = 0;
            if (maxIndex < batteries.size() - 1) {
                // find next largest element TRAILING the current one
                List<Integer> subBank = batteries.subList(maxIndex+1, batteries.size());

                max2ndBattery = Collections.max(subBank);
                joltage = maxBattery*10 + max2ndBattery;
            } else{
                List<Integer> subBank = batteries.subList(0, maxIndex);

                max2ndBattery = Collections.max(subBank);
                joltage = maxBattery + max2ndBattery*10;
            }

            result.add(joltage);
            logger3.debug(maxBattery + "/" + max2ndBattery + " = " + joltage);
        }
        // load data
        // find largest element
        // if it is last -> search for next largest element, both of them make up the largest jolt
        // if it is not last -> find the next largest element -> largest jolt

        return result.stream().mapToInt(Integer::intValue).sum();
    }
}
