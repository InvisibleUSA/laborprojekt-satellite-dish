/**
 * Created by Erik on 25.05.2017.
 */

public class SatelliteDish {
    private GeoCoord position;
    SatelliteDish(GeoCoord position) {
        this.position = position.clone();

    }

    public boolean isInNorthernHemisphere() {
        return position.getBeta() > 0;
    }

    public boolean isInSouthernHemisphere() {
        return position.getBeta() < 0;
    }

    public double getDelta(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanDelta = (Main.k * Math.sin(latitude))/Math.sqrt(1+Math.pow(Main.k, 2)*Math.pow(Math.cos(latitude),2)-2*Main.k*Math.cos(latitude)*Math.cos(sat.getLambda()-longitude));
        return Math.abs(Math.atan(tanDelta));
    }

    public double getDelta(double Psi) {
        double sinBeta = Math.sin(position.getBeta());
        double cosBeta = Math.cos(position.getBeta());
        double lambda = Math.atan(Math.tan(Psi) * sinBeta);
        double tanDelta = Main.k * sinBeta / Math.sqrt(1-2*Main.k * cosBeta * Math.cos(lambda)+Math.pow(Main.k * cosBeta, 2));
        return Math.abs(Math.atan(tanDelta));
    }

    public double getAlpha(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanAlpha = (Math.cos(latitude)*Math.cos(sat.getLambda()-longitude)-Main.k)/Math.sqrt((1-Math.pow(Math.cos(latitude),2)*Math.pow(Math.cos(sat.getLambda()-longitude),2)));
        return Math.atan(tanAlpha);
    }

    public double getAlpha(double psi) {
        double cosPsi = Math.cos(psi);
        double tanBeta = Math.tan(position.getBeta());
        double tanAlpha = - cosPsi / tanBeta - Main.k * Math.sqrt(1 + (cosPsi / tanBeta) * (cosPsi / tanBeta));
        return Math.atan(tanAlpha);
    }

    public double getPsi(Satellite sat) {
        double longitude = this.position.getLambda(), latitude = this.position.getBeta();
        double tanPsi = Math.tan(sat.getLambda()-longitude)/Math.sin(latitude);
        double Psi  = Math.atan(tanPsi);
        if (latitude >= 0) Psi = Math.PI + Psi;
        if (Psi < 0) {
            if (latitude < 0) Psi = 2 * Math.PI + Psi;
        }
        return Psi;
    }
}
