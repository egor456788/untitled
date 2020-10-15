package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Render {

    //Стоит начать с этого
    public static void renderTriangle(BufferedImage img, double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3,double z3) {
        {
            double li[] = new double[3];
            li[0] = 1366;
            li[1] = 786;
            double z[] = new double[3];
            z = vectorm(x1 - x2, x1 - x3, y1 - y2, y1 - y3, z1 - z2, z1 - z3);
            z = vector.normalize3D(z);
            double k[] = new double[3];
            k[0] = 1366 - x1;
            k[1] = 786 - y1;
            k[2] = 10 - z1;
            k = vector.normalize3D(k);
            double t;
            t = k[0] * z[0] + k[1] * z[1] + k[2] * z[2];
            for (int i = (int) Math.max(0,Math.min(x1, Math.min(x2, x3))); i < Math.min(1366,Math.max(x1, Math.max(x2, x3))); i++) {
                for (int j = (int) Math.max(0,Math.min(y1, Math.min(y2, y3))); j < Math.min(786,Math.max(y1, Math.max(y2, y3))); j++) {
                    double A = (x1 - i) * (y2 - y1) - (x2 - x1) * (y1 - j);
                    double B = (x2 - i) * (y3 - y2) - (x3 - x2) * (y2 - j);
                    double C = (x3 - i) * (y1 - y3) - (x1 - x3) * (y3 - j);
                    if (Math.signum(A) == Math.signum(B) && Math.signum(B) == Math.signum(C)) {
                        if (t < 0 || t > 1)
                            img.setRGB(i, j, new Color(0, 0, 0).getRGB());
                        else {
                            img.setRGB(i, j, new Color((int) (255 * t), (int) (t * 255), (int) (t * 255)).getRGB());
                        }
                    }
                    if ((A == 0) && (B == 0) && (C == 0)) {
                        img.setRGB(i, j, new Color(0, 0, 0).getRGB());
                    }
                }
            }
        }
        }
            public static double[] vectors ( int x[], double y[]){

                    double z[] = new double[3];
                    for (int i = 0; i < 3; i++) {
                        z[i] = x[i] + y[i];
                    }
                    return z;
                }

                public static double[] vectorm ( double x1, double y1, double x2, double y2, double x3, double y3)
                {
                    double z[] = new double[3];
                    z[0] = x3 * y2 - x2 * y3;
                    z[1] = x1 * y3 - x3 * y1;
                    z[2] = x2 * y1 - x1 * y2;
                    return z;
                }
                public static double vectorsc ( double x[], double y[])
                {
                    double z = 0;
                    for (int i = 0; i < 2; i++) {
                        z = z + x[i] * y[i];
                    }
                    return z;
                }

                public static double[][] matrix ( double x[][], double y[][])
                {
                    double z[][] = new double[4][4];
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            z[j][i] = x[0][i] * y[j][0] + x[1][i] * y[j][1] + x[2][i] * y[j][2] + x[3][i] * y[j][3];
                        }
                    }
                    return z;
                }
    public static double[]matrixv ( double x[], double y[][])
    {
        double z[]=new double[4];
        for (int i = 0; i < 4; i++) {
            z[i]=x[i]*y[i][0]+x[i]*y[i][1]+x[i]*y[i][2]+x[i]*y[i][3];
        }
        return z;
    }
                public static double[] matrixv ( double x[][], double y[])
                {
                    double z[] = new double[4];
                    z[0] = 0;
                    z[1] = 0;
                    z[2] = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            z[i] = z[i] + x[i][j] * y[j];
                        }
                    }
                    return z;
                }
            }