package io.github.sliskicode.robusttestinglivecodingdemos;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * 6
 */
public class EqualsHashCodeInObject {

    @Test
    public void objectsShouldBeEquals() throws Exception {
        Person foo = new Person("Peter", "Slesarew", 28);
        Person foo2 = new Person("Peter", "Slesarew", 28);

        assertEquals(foo.name, foo2.name);
        assertEquals(foo.surname, foo2.surname);
        assertEquals(foo.age, foo2.age);
    }

    private static class Person {
        String name;
        String surname;
        int age;

        Person(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
    }
}
