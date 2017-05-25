/**
 * Created by Erik on 25.05.2017.
 */
public class GeoCoord {
    private double lambda;
    private double beta;

    GeoCoord(double l, double b) {
         setBeta(b);
         setLambda(l);
    }

    public double getLambda() {
        return lambda;
    }

    public double getBeta() {
        return beta;
    }

    public void setLambda(double l) {
        if ((l > Converter.degToRad(180)) || (l < Converter.degToRad(-180))) {
            throw new IllegalArgumentException("Lambda out of bounds.");
        }
        lambda = l;
    }

    public void setBeta(double b) {
        if ((b > Converter.degToRad(90)) || (b < Converter.degToRad(-90))) {
            throw new IllegalArgumentException("Beta out of bounds.");
        }
        beta = b;
    }

    public GeoCoord clone() {
        return new GeoCoord(lambda, beta);
    }

}
