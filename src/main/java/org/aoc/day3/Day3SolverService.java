package org.aoc.day3;

import org.springframework.stereotype.Service;

import java.util.*;

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

        if (maxIndex < batteries.size() - 1) {
            List<Long> subList = batteries.subList(maxIndex + 1, batteries.size());

            return List.of(new IndexedBattery(0, maxBattery),
                    new IndexedBattery(1, Collections.max(subList)));
        } else {
            List<Long> subList = batteries.subList(0, maxIndex);

            return List.of(new IndexedBattery(0, Collections.max(subList)),
                    new IndexedBattery(1, maxBattery));
        }
    }

    private List<IndexedBattery> getTopNBatteries(List<Long> batteries) {
        int n = 12;
        List<IndexedBattery> result = new ArrayList<>();
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            // For position i in result, we can search from startIndex up to and including batteries.size() - (n - i)
            // After picking position j, we need (n - i - 1) more batteries from positions j+1 onwards
            // batteries.size() - j - 1 >= n - i - 1, so j <= batteries.size() - (n - i)
            int endIndex = batteries.size() - (n - i) + 1;  // +1 because loop uses j < endIndex

            // Find max value in this window
            long maxValue = Long.MIN_VALUE;
            int maxIdx = startIndex;

            for (int j = startIndex; j < endIndex; j++) {
                if (batteries.get(j) > maxValue) {
                    maxValue = batteries.get(j);
                    maxIdx = j;
                }
            }

            result.add(new IndexedBattery(maxIdx, maxValue));
            startIndex = maxIdx + 1;
        }

        return result;
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

    private long joltage12Batteries(List<IndexedBattery> batteries) {
        long joltage = 0;
        for (int i = 0; i < batteries.size(); i++) {
            joltage += batteries.get(i).value() * (long) Math.pow(10,
                    batteries.size() - i - 1);
        }
        return joltage;
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

    private static List<Long> toBatteries(String line) {
        return Arrays.stream(line.split("")).map(Long::parseLong).toList();
    }

    public Long part2() {
        logger3.debug("Running part2");
        return solve(this::getTopNBatteries, this::joltage12Batteries);
    }
}
