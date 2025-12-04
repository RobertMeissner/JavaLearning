package org.aoc.day4;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.aoc.day4.Day4App.logger4;


@Service
public class Day4SolverService {
    private final InputReader reader;

    public Day4SolverService(InputReader reader) {
        this.reader = reader;
    }

    public int toBit(String element) {
        return 0;
    }

    public int[][] mapToMatrix(List<String> data) {
        // char(@) = 64
        return data.stream().map(line -> line.chars().map(c -> c == 64 ? 1 : 0).toArray())
                .toArray(int[][]::new);
    }

    private static int countNeighborsAt(int[][] matrix, int i, int j) {
        int count = 0;
        int size = matrix.length;

        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue;

                int ni = i + di;
                int nj = j + dj;
                if (ni >= 0 && ni < size && nj >= 0 && nj < size) {
                    count += matrix[ni][nj];
                }
            }
        }
        return count;
    }

    public static int[][] countNeighbors(int[][] matrix) {
        int size = matrix.length;
        int[][] counts = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                counts[i][j] = countNeighborsAt(matrix, i, j);
            }
        }

        return counts;
    }

    public static int[][] removeEmptySpaces(int[][] matrix, int[][] counts) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    counts[i][j] = 8; // FIXME: 8 equals all places taken - THIS IS TECH DEBT!
                }
            }
        }

        return counts;
    }

    public int rollsWithFourOrMoreNeighbors(int[][] matrix) {
        int count = 0;
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count += matrix[i][j] < 4 ? 1 : 0;
            }
        }

        return count;
    }


    public int part1() {
        logger4.debug("Running part1");

        // data
        List<String> data = reader.readInput("data");
        int[][] matrix = this.mapToMatrix(data);

        logger4.debug(Arrays.toString(matrix));
        // count
        int[][] neighbors = countNeighbors(matrix);
        neighbors = removeEmptySpaces(matrix, neighbors);
        return this.rollsWithFourOrMoreNeighbors(neighbors);
    }
}
