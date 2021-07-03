package refactoring;

/*
Pg-128 Split Temporary Variable
* */
public class SplitTemporaryVariable {
    double primaryForce = 1;
    double mass = 2;
    int delay = 3;
    double secondaryForce = 4;

    public double getDistanceTravelled(int time) {
        double result = 0.5 * primaryAcc() * primaryTimeSquared(time);
        if (secondaryTime(time) > 0) {
            result += primaryVel() * secondaryTime(time) + 0.5 * secondaryAcc() * secondaryTimeSquared(time);
        }
        return result;
    }

    private int secondaryTimeSquared(int time) {
        return secondaryTime(time) * secondaryTime(time);
    }

    private int primaryTimeSquared(int time) {
        return primaryTime(time) * primaryTime(time);
    }

    private double secondaryAcc() {
        return (primaryForce + secondaryForce) / mass;
    }

    private double primaryVel() {
        return primaryAcc() * delay;
    }

    private int secondaryTime(int time) {
        return time - delay;
    }

    private int primaryTime(int time) {
        return Math.min(time, delay);
    }

    private double primaryAcc() {
        return primaryForce * mass;
    }
}
