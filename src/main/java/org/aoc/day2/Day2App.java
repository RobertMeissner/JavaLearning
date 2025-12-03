package org.aoc.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day2App {

    public static final Logger logger = LoggerFactory.getLogger("org.aoc");

    static void main(String[] args) {
        SpringApplication.run(Day2App.class, args);
    }
}
