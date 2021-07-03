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
        double result = 0.5 * primaryAcc() * primaryTime(time) * primaryTime(time);
        if (secondaryTime(time) > 0) {
            double primaryVel = primaryAcc() * delay;
            final double secondaryAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime(time) + 0.5 * secondaryAcc * secondaryTime(time) * secondaryTime(time);
        }
        return result;
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
