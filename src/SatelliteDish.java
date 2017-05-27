/**
 * Created by Erik on 25.05.2017.
 */
public class SatelliteDish {
    private GeoCoord position;
    SatelliteDish(GeoCoord position) {
        this.position = position.clone();

    }
    public double getPsi(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanPsi = (Main.k * Math.sin(latitude))/Math.sqrt(1+Math.pow(Main.k, 2)*Math.pow(Math.cos(latitude),2)-2*Main.k*Math.cos(latitude)*Math.cos(sat.getLambda()-longitude));
        return Math.atan(tanPsi);
    }

    public double getAlpha() {
        return 0;
    }

    public double getDelta() {
        return 0;
    }
}
