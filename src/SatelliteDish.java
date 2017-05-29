/**
 * Created by Erik on 25.05.2017.
 */
public class SatelliteDish {
    private GeoCoord position;
    SatelliteDish(GeoCoord position) {
        this.position = position.clone();

    }
    public double getDelta(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanDelta = (Main.k * Math.sin(latitude))/Math.sqrt(1+Math.pow(Main.k, 2)*Math.pow(Math.cos(latitude),2)-2*Main.k*Math.cos(latitude)*Math.cos(sat.getLambda()-longitude));
        return Math.atan(tanDelta);
    }

    public double getAlpha(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanAlpha = (Math.cos(latitude)*Math.cos(sat.getLambda()-longitude)-Main.k)/Math.sqrt((1-Math.pow(Math.cos(latitude),2)*Math.pow(Math.cos(sat.getLambda()-longitude),2)));
        return Math.atan(tanAlpha);
    }

    public double getPsi(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanPsi = Math.tan(sat.getLambda()-longitude)/Math.sin(latitude);
        return Math.atan(tanPsi);
    }
}
