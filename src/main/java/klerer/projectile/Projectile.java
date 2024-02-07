package klerer.projectile;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private final double gravity = 9.8;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }


    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds - (.5 * 9.8 * (seconds * seconds));
    }

    /**
     *
     * @return the time where the projectile is at it's highest point.
     */
    public double getApexTime() {
        return (Math.sin(radians) * velocity) / gravity;
    }

    /**
     *
     * @return the highest Y value of projectile
     */
    public double getPeakY() {
        return Math.pow(velocity * Math.sin(radians), 2) / (2 * gravity);
    }
}
