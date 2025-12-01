package org.oracle;

import java.util.Arrays;

enum PersonSex {
    MALE,
    FEMALE
}

class Person {
    PersonSex sex;

    public PersonSex getGender() {
        return this.sex;
    }

    public String getName() {
        return "Peter";
    }
}

public class aggregateOperations {
    private void original(Person[] roster) {
        for (Person p : roster) {
            if (p.getGender() == PersonSex.MALE) {
                System.out.println(p.getName());
            }
        }
    }

    private void forEachRewritten(Person[] roster) {
        Arrays.stream(roster).
                filter(e -> e.getGender() == PersonSex.MALE).
                forEach(person -> System.out.println(person.getName()));
    }
}
