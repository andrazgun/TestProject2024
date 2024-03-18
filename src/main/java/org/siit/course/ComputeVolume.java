package org.siit.course;

public class ComputeVolume {

    //        Sphere compute volume
    public static double computeVolume(double sphereRadius) {
        return (( 4.0 / 3.0 ) * Math.PI * Math.pow(sphereRadius, 3));
    }

    //    Pyramid compute volume
    public static double computeVolume(int baseLength, int baseWidth, int pyramidHeight) {
        return ((baseLength * baseWidth) * pyramidHeight) / 3;
    }

    //        Torus compute volume
    public static double computeVolume(double minorRadius, double majorRadius) {
        return ((Math.PI * Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius));
    }
}
