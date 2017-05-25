/**
 * Created by Erik on 25.05.2017.
 */
public class Satellite {
    private double lambda;

    public double getLambda() {
        return lambda;
    }
    public GeoCoord getPosition() {
        return new GeoCoord(lambda, 0);
    }
}
