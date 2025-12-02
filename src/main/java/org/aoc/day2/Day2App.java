package org.aoc.day2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day2App {

    public static final Logger logger = LogManager.getLogger("org.aoc.day2");

    public static void main(String[] args) {
        SpringApplication.run(Day2App.class, args);

    }
}
