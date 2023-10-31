package refactoring;

import java.util.Objects;

public class IntroduceForeignMethod {
    // suppose you want to add the method nextDate() but you can't touch the class Date or modify it
    // You can create a foreign method and introduce it in this class

    // foreign method in client class
    public Date dateAndTime(Date date) {
        return new Date(date.value() + "-10:00");
    }
    // the problem occurs when this method is going to be used in a lot of classes which results in
    // repetition of code
    // the solution is Introduce Local Extension
    // Solutions:
    // 1. Create a subclass
    // 2. Create a wrapper
}


// Immutable class and out of reach
class Date {

    private final String value;

    public Date(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public String MM_DD_YYYYFormat() {
        return "12-02-2023";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // had to comment so subclass can equate with it
//        if (o == null || getClass() != o.getClass()) return false;
        if (o == null || !(o instanceof Date)) return false;
        Date date = (Date) o;
        return Objects.equals(value, date.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}