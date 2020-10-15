package com.company;

public class vector {
    public static double[] normalize3D(double [] z){
        double res[]=new double[3];
        res[0] = z[0] / Math.sqrt(z[0] * z[0] + z[1] * z[1]+z[2]*z[2]);
        res[1] = z[1] / Math.sqrt(z[0] * z[0] + z[1] * z[1]+z[2]*z[2]);
        res[2] = z[2] / Math.sqrt(z[0] * z[0] + z[1] * z[1]+z[2]*z[2]);
        return res;
    }
}

