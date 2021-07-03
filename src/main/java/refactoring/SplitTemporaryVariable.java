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
        final double primaryAcc = primaryAcc();
        int primaryTime = Math.min(time, delay);
        double result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * delay;
            final double secondaryAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }

    private double primaryAcc() {
        return primaryForce * mass;
    }
}
