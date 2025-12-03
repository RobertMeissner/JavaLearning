package org.aoc.day3;

import org.jetbrains.annotations.NotNull;
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

    record IndexedBattery(int index, long value) {
    }

    private List<IndexedBattery> topTwoBatteries(List<Long> batteries) {

        long maxBattery = Collections.max(batteries);
        int maxIndex = batteries.indexOf(maxBattery);
        // next largest

        long max2ndBattery;
        if (maxIndex < batteries.size() - 1) {
            max2ndBattery = Collections.max(batteries.subList(maxIndex + 1, batteries.size()));
            return List.of(new IndexedBattery[]{new IndexedBattery(0, maxBattery), new IndexedBattery(1, max2ndBattery)});
        } else {
            max2ndBattery = Collections.max(batteries.subList(0, maxIndex));
            return List.of(new IndexedBattery[]{new IndexedBattery(0, max2ndBattery), new IndexedBattery(1, maxBattery)});
        }
    }

    private long joltage(List<IndexedBattery> batteries) {
        IndexedBattery first = batteries.get(0);
        IndexedBattery second = batteries.get(1);

        if (first.index() < second.index()) {
            return first.value() * 10 + second.value();
        } else {
            return first.value() + second.value() * 10;
        }
    }

    @FunctionalInterface
    interface TopBatteries {
        List<IndexedBattery> calculate(List<Long> batteries);
    }

    @FunctionalInterface
    interface Joltage {
        long calculate(List<IndexedBattery> batteries);
    }

    private Long solve(TopBatteries getTopBatteries, Joltage joltage) {
        List<String> data = inputReader.readInput("data");
        logger3.debug("Number of banks {}. Number of batteries {}", data.size(), data.getFirst().length());

        ArrayList<Long> result = new ArrayList<>();
        for (String line : data) {
            List<Long> batteries = toBatteries(line);

            List<IndexedBattery> topBatteries = getTopBatteries.calculate(batteries);
            result.add(joltage.calculate(topBatteries));
            logger3.debug(topBatteries.toString());
        }
        return result.stream().mapToLong(Long::longValue).sum();
    }

    public int part1() {
        logger3.debug("Running part1");
        return solve(this::topTwoBatteries, this::joltage).intValue();
    }

    @NotNull
    private static List<Long> toBatteries(String line) {
        return Arrays.stream(line.split("")).map(Long::parseLong).toList();
    }

    public Long part2() {
        logger3.debug("Running part2");
        return solve(this::topTwoBatteries, this::joltage);
    }
}
