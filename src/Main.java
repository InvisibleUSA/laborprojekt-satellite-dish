import javax.swing.*;

/**
 * Created by ln on 25.05.17.
 */
public class Main {

    public static double earthRad = 6378.137; //km
    public static double k = Main.earthRad / Satellite.radius;

    public static String convertAngle(double angle) {
        return Math.round(Converter.radToDeg(angle*10000))/10000.0 + "°";
    }
    public static String calcElevationCurve(SatelliteDish dish) {
        String result = "Psi\tAlpha\tDelta\n";
        if (dish.isInNorthernHemisphere()){
            for (double psi = Converter.degToRad(90); psi <= Converter.degToRad(270); psi += Converter.degToRad(5)) {
                result += convertAngle(psi) + "\t" + convertAngle(dish.getAlpha(psi)) + "\t" + convertAngle(dish.getDelta(psi)) + "\n";
            }
        }
        else if (dish.isInSouthernHemisphere()){
            for (double psi = Converter.degToRad(-90); psi <= Converter.degToRad(90); psi += Converter.degToRad(5)) {//TODO check if 0-90 and 270-360 necessary
                result += convertAngle(psi) + "\t" + convertAngle(dish.getAlpha(psi)) + "\t" + convertAngle(dish.getDelta(psi)) + "\n";
            }
        }
        else {
            result += "*\t90°\t0°\n";
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println("k ist: " + k);
        Satellite panamsat = new Satellite(Converter.degToRad(Double.parseDouble(JOptionPane.showInputDialog("Satpos: ", -19.2))));
        SatelliteDish dish = new SatelliteDish(new GeoCoord(Converter.degToRad(Double.parseDouble(JOptionPane.showInputDialog("Länge: ", 9.2))), Converter.degToRad(Double.parseDouble(JOptionPane.showInputDialog("Breite: ", 48.8)))));
        double delta = dish.getDelta(panamsat);
        double alpha = dish.getAlpha(panamsat);
        double psi = dish.getPsi(panamsat);
        JOptionPane.showMessageDialog(null, "Delta is: " + Converter.radToDeg(delta) + "\n" + "Alpha is: " + Converter.radToDeg(alpha) + "\n" + "Psi is: " + Converter.radToDeg(psi));
        String message = calcElevationCurve(dish);
        JOptionPane.showMessageDialog(null, new JTextArea(message));
        System.out.println("Delta is: " + Converter.radToDeg(delta));
        System.out.println("Alpha is: " + Converter.radToDeg(alpha));
        System.out.println("Psi is: " + Converter.radToDeg(psi));
    }
}
