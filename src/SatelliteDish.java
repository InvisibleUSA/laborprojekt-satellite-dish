/**
 * Created by Erik on 25.05.2017.
 */
public class SatelliteDish {
    private GeoCoord position;
    SatelliteDish(GeoCoord position) {
        this.position = position.clone();

    }
    public double getPsi() {
        return 0;
    }

    public double getAlpha() {
        return 0;
    }

    public double getDelta() {
        return 0;
    }
}
