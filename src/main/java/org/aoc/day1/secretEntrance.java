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

    static int clampPosition(int unclamped){
        return ((unclamped % 100) + 100) % 100;
    }

    public int password(String filename) {
        // 1. parse file input with list of strings
        // 2. transform each line into an integer
        // 3. go through the list of int; increase counter whenever we reach 0
        // 4. return counter

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

    public void day1() {
        int result = this.password("aoc/day1/data");
        System.out.println(result);
    }


    public static void main(String[] args) {
        secretEntrance entrance = new secretEntrance();
        entrance.day1();
    }

    public void reset() {
        counter = 0;
        position = 50;
    }
}
