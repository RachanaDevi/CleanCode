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
        double acc = primaryForce * mass;
        int primaryTime = Math.min(time, delay);
        double result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * delay;
            acc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }
}
