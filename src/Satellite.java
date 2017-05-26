/**
 * Created by Erik on 25.05.2017.
 */
public class Satellite {
    private double lambda;
    public static double radius = 42164.14; //km

    Satellite(double lambda){
        //TODO: add check for lambda
        this.lambda = lambda;
    }

    public double getLambda() {
        return lambda;
    }
    public GeoCoord getPosition() {
        return new GeoCoord(lambda, 0);
    }
}
