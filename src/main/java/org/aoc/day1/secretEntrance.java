package org.aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class secretEntrance {
    private int position = 50;
    private int counter = 0;

    int lineToInt(String line) {
        // converts L to minus and R to plus, number to
        return Integer.parseInt(line.replace("R", "").replace("L", "-"));
    }

    public String[] sequenceFromFile(String filename) throws IOException {
        String completeFilename = Objects.requireNonNull(getClass().getClassLoader()
                        .getResource(filename))
                .getPath();
        List<String> lines = Files.readAllLines(Paths.get(completeFilename));
        return lines.toArray(new String[0]);
    }

    static int clampPosition(int unclamped) {
        return ((unclamped % 100) + 100) % 100;
    }

    public int password(String filename) {
        reset();
        try {
            String[] lines = this.sequenceFromFile(filename);
            System.out.println("Number of lines: " + lines.length);
            for (String line : lines) {
                int wantedRotation = lineToInt(line);
                position += wantedRotation;
                position = clampPosition(position);
                System.out.println(line + ":" + wantedRotation + ":" + position);
                if (position == 0) {
                    counter += 1;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return counter;
    }

    public int passwordPassingZero(String filename) {
        this.reset();
        try {
            String[] lines = this.sequenceFromFile(filename);
            for (String line : lines) {
                int wantedRotation = lineToInt(line);
                int newPos = position + wantedRotation;
                counter += crossings(newPos, position);

                // clamp position
                position = clampPosition(newPos);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return counter;
    }

    int crossings(int newPos, int current) {
        System.out.println(current + "/" + newPos);
        if (current < newPos) {
            return Math.abs(Math.floorDiv(newPos, 100) - Math.floorDiv(current, 100));

        } else if (current > newPos) {
            return crossings(-newPos, -current);

        } else return 0;
    }

    boolean clampingNeeded(int position) {
        return (position > 100 || position < 0);
    }

    int largeRotation(int wantedRotation) {
        return (Math.abs(wantedRotation) - 1) / 100;
    }

    public void day1() {
        int result = this.password("aoc/day1/data");
        System.out.println(result);
    }

    public void day1d1() {
        int result = this.passwordPassingZero("aoc/day1/data");
        System.out.println("Second part:");
        System.out.println(result);
    }


    public static void main(String[] args) {
        secretEntrance entrance = new secretEntrance();
        entrance.day1();
        entrance.day1d1();
    }

    public void reset() {
        counter = 0;
        position = 50;
    }
}
