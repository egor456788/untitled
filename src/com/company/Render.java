package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Render {
    //Стоит начать с этого
    public static void renderTriangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3,double z1,double z2, double z3){
        double li[] = new double[3];
        li[0] = 1366;
        li[1] = 786;
        double z[] = new double[3];
        z = vectorm1(x1 - x2, x1 - x3, y1 - y2, y1 - y3, z1 - z2, z1 - z3);
        z = vector.normalize3D(z);
        double k[] = new double[3];
        k[0] = 1366 - x1;
        k[1] = 786 - y1;
        k[2] = 10 - z1;
        k = vector.normalize3D(k);
        double t;
        t = k[0] * z[0] + k[1] * z[1] + k[2] * z[2];
        double AB[] = {x2-x1,y2-y1};
        double AC[] = {x3-x1,y3-y1};
       for (int x =(int) (Math.min(x1, Math.min(x2, x3))); x <= (int) (Math.max(x1, Math.max(x2, x3))); x++) {
         for (int y = (int)(Math.min(y1, Math.min(y2, y3))); y < (int)(Math.max(y1, Math.max(y2, y3))); y++) {
                double PA[] = {x1-x,y1-y};

                double u1[]={AB[0],AC[0],PA[0]};
                double u2[]={AB[1],AC[1],PA[1]};
                double V[] = Render.vectorm2(u1,u2);
                double u = V[0]/V[2];         double v = V[1]/V[2];
               if (u + v <= 1 && u >= 0 && v >= 0){
                   if(t>0)
                    img.setRGB(x, y, new Color((int) (u*255*t), (int) (v*255*t), (int) ((1-u-v)*255*t)).getRGB());
                   else
                       img.setRGB(x, y, new Color(0, (int) 0, (int) 0).getRGB());
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

                public static double[] vectorm2 ( double x [],double y[])
                {
                    double z[] = new double[3];
                    z[0] = x[2]* y[1] - x[1] * y[2];
                    z[1] = x[0] * y[2] - x[2] * y[0];
                    z[2] = x[1] * y[0] - x[0] * y[1];
                    return z;
                }
    public static double[] vectorm1 ( double x1, double y1, double x2, double y2, double x3, double y3)
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