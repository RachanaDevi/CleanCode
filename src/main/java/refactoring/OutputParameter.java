package refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
output parameter:
- calculateCount does not signify that it produces a side-effect
- addSums and calculateCount gets the ownership of the list which means they can also delete the element or modify one
- sums.addSums() a reader does not know unless you look carefully that it produces a side-effect
- writing tests for addSums() is weird because you pass the list and then you assert it again

- a method should not be allowed to produce a hidden side effect. Any changes that you cannot comprehend by looking at the signature

So here by hidden things you mean, it may not be confined to a particular method doing that,
 it just keeps or may be getting passed around and we don't know the operations which may come in between.
  And we also may not know if the order of operations matter or not.

surety
-----------------------------------
What we are saying is with result parameters
A method can take result parameter
And manipulate that

- So here the method getListFrom() can manipulate the finalResult (result parameter) which is passed by calculateCount?

Reasons
- someone else can manipulate it and we don't know what happened to the real result. Will be difficult to debug, what went wrong
in its real behaviour
- it can get passed on and on and we may not know the flow
- it is not a pure function, take something and return something
- if someone as a library point of view, sees the function, they will never know that the thing which
 they want to pass is an output parameter
 - even if you see the tests, the tests are weird

 Constructor injection does not like activity config
 I had to turn into configuration objects and prefix them
 constructor injection, @ConstructorBinding and it will do actually complex structures
 Because on KSQL side I have introduced Config now, and it could not do that
 - I didn't go that, thanks for sharing that I ran into similar issue
 Fixed structure and fixed path
 List of activities

 @Value
 - annotation is not straight-forward in list in my opinion, it was quite tedious with this configuration properties
 - class structure, nested, yeah oh okay,
 - @Value, I don't know that much a
 - the user can manipulate at all
 - is there any way in spring supress something with @Data
 - yeah I am torn on this, I am really not super opposed to getters and setters on things, we are publishing this as a library
 defensive about too restrictive in a library after the fact, but I also see the point, if I can make work without setters
 Couple of 3 hours on friday, could not really make this work, all the way down

 There
 I am just defensive a reasonable toString equals and hashcode, not having equals hashcode and

 I am apprehensive about the all args constructor, IDE generate one for you, becaua

 Created and histograms configurations
 - a fixed data value I can't do it for my config,

 Super big fan we're doing right now, the way does not end up transient object creation and we need to pay attention throughput on the garbage
 collector, transient objects

 new on an Object, creating a new Totals object to an existing totals object and we are losing references to the
 clean up that totals, millions of these at a type, millions of these
 the app has caused for the second,
 streaming process thing
 new as much as possible during the processing of each message
 */
public class OutputParameter {

    private SumConfig sums;

    private Map<String, String> counts;

    // what they user will do with, if you look at the signature, the user will not know that it is an output parameter
    public List<Integer> getListFrom(Event event, List<integer> list) {
        List<Integer> finalResult = new ArrayList<Integer>();
       finalResult =  calculateCount(event); // 1, 2 , 3
 // someone can manipulate nobody is stopping you from doing it
        // library banayi hai
        // output parameter, library karate

        // the side effect
        finalResult.remove(100);

// undo it  //
//        secondResult = sums.addSums(event, finalResult); // 4,5,6 pure function

        return finalResult;
    }

    private void calculateCount(Event event, List<Integer> finalResult) {
        counts.keySet().forEach(key -> {
            finalResult.add(event.get(key));
        });
    }
}

class Event {

    public Integer get(String key) {
        return 100;
    }
}

class SumConfig {
    public void addSums(Event event, List<Integer> finalResult) {
        finalResult.add(100);
        finalResult.remove(100);
        // removing from anything else
    }
}
