package refactoring;

public class IntroduceLocalExtension {
    // suppose you want to add the method nextDate() but you can't touch the class Date or modify it

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

// Subclass
class DateSubclass extends Date {

    // adding relevant constructors
    DateSubclass(String value) {
        super(value);
    }

    // converting constructor
    DateSubclass(Date date) {
        super(date.value());
    }

    // not necessary to override equals and hashcode in subclass
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
}

