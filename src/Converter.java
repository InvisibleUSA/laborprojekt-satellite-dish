/**
 * Created by Erik on 25.05.2017.
 */
public class Converter {
    public static double degToRad(double angle) {
        return angle / 180 * Math.PI;
    }

    public static double radToDeg(double angle) {
        return angle / Math.PI * 180;
    }
}
