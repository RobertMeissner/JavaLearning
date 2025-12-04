package org.aoc.day4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Day4App {
    public static Logger logger4 = LoggerFactory.getLogger("org.aoc");
    
    void main(String... args) {
        SpringApplication.run(Day4App.class, args);
    }
}
