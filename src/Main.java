import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by ln on 25.05.17.
 */
public class Main {

    public static double earthRad = 6378.137; //km
    public static double k = Main.earthRad / Satellite.radius;

    public static void main(String [] args){
        System.out.println("k ist: " + k);
        Satellite panamsat = new Satellite(Converter.degToRad(45));
        SatelliteDish dish = new SatelliteDish(new GeoCoord(Converter.degToRad(-9.2), Converter.degToRad(-48.8)));
        double delta = dish.getDelta(panamsat);
        double alpha = dish.getAlpha(panamsat);
        double psi = dish.getPsi(panamsat);
        System.out.println("Delta is: " + Converter.radToDeg(delta));
        System.out.println("Alpha is: " + Converter.radToDeg(alpha));
        System.out.println("Psi is: " + Converter.radToDeg(psi));
    }
}
