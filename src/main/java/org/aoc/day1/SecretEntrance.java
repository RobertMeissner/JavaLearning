package org.aoc.day1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class SecretEntrance {
    private static final int STARTING_POSITION = 50;

    private static final Logger logger = LoggerFactory.getLogger(SecretEntrance.class);

    public int parsedRotation(String line) {
        return Integer.parseInt(line.replace("R", "").replace("L", "-"));
    }

    public String[] sequenceFromFile(String filename) throws IOException {
        String completeFilename = Objects.requireNonNull(getClass().getClassLoader()
                        .getResource(filename))
                .getPath();
        List<String> lines = Files.readAllLines(Paths.get(completeFilename));
        return lines.toArray(new String[0]);
    }

    public static int clampPosition(int unclamped) {
        return ((unclamped % 100) + 100) % 100;
    }

    public int password(String filename) {
        int position = STARTING_POSITION;
        int counter = 0;
        try {
            String[] lines = this.sequenceFromFile(filename);
            logger.debug("Number of lines: " + lines.length);
            for (String line : lines) {
                int wantedRotation = parsedRotation(line);
                position += wantedRotation;
                position = clampPosition(position);
                logger.debug(line + ":" + wantedRotation + ":" + position);
                if (position == 0) {
                    counter += 1;
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read input: " + filename, e);
        }
        return counter;
    }

    public int passwordPassingZero(String filename) {
        int position = STARTING_POSITION;
        int counter = 0;
        try {
            String[] lines = this.sequenceFromFile(filename);
            for (String line : lines) {
                int wantedRotation = parsedRotation(line);
                int newPos = position + wantedRotation;
                counter += crossings(newPos, position);

                // clamp position
                position = clampPosition(newPos);
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read input: " + filename, e);
        }
        return counter;
    }

    public int crossings(int newPos, int current) {
        logger.debug(current + "/" + newPos);
        if (current < newPos) {
            return Math.abs(Math.floorDiv(newPos, 100) - Math.floorDiv(current, 100));

        } else if (current > newPos) {
            return crossings(-newPos, -current);

        } else return 0;
    }

    public void solvedPart1() {
        int result = this.password("aoc/day1/data");
        logger.debug("Result: {}", result);
    }

    public void solvedPart2() {
        int result = this.passwordPassingZero("aoc/day1/data");
        logger.debug("Second part:");
        logger.debug("Result: {}", result);
    }


    public static void main(String[] args) {
        SecretEntrance entrance = new SecretEntrance();
        entrance.solvedPart1();
        entrance.solvedPart2();
    }

}
