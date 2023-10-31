package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateSubclassTest {

    // works without overriding equals in DateSubClass
    // the problem why it was not working was because of the condition in Date (parent)
    // it checks for .class()
    // but how does that solve? In ArrayList it doesn't check for ArrayList but checks for List type
    // and checks for instance and not for class
    // http://www.angelikalanger.com/Articles/JavaSolutions/SecretsOfEquals/Equals-2.html
    @Test
    void checkingHowEquateWorksWithSubClassAndParentClass() {
        DateSubclass dateSubClass = new DateSubclass("value1");
        Date date = new Date("value1");

        assertEquals(dateSubClass, date);
    }

    @Test
    void checkingHowEquateWorksWithSubClassAndParentClassByPassingParentClass() {
        Date date = new Date("value1");
        Date dateSubClass = new DateSubclass(date);

        assertEquals(dateSubClass, date);
    }
}