package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Render {
    //Стоит начать с этого
    public static void renderTriangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3,double z1,double z2, double z3, double x4, double y4, double z4, double x5, double y5, double z5,double x6,double y6, double z6,double [][]zBuffer){
        double z[] = new double[3];
        double l[][]=matrix.translation(260,240,320,0,0,0);
        double k1[]={x1,y1,z1,1};
        k1=matrixv(l,k1);
        double k2[]={x2,y2,z2,1};
        k2=matrixv(l,k2);
        double k3[]={x3,y3,z3,1};
        k3=matrixv(l,k3);
        double k4[]={x4,y4,z4,1};
        k4=matrixv(l,k4);
        double k5[]={x5,y5,z5,1};
        k5=matrixv(l,k5);
        double k6[]={x6,y6,z6,1};
        k6=matrixv(l,k6);
        x1=k1[0];
        y1=k1[1];
        z1=k1[2];
        x2=k2[0];
        y2=k2[1];
        z2=k2[2];
        x3=k3[0];
        y3=k3[1];
        z3=k3[2];
        x4=k4[0];
        y4=k4[1];
        z4=k4[2];
        x5=k5[0];
        y5=k5[1];
        z5=k5[2];
        x6=k6[0];
        y6=k6[1];
        z6=k6[2];
        x1+=300;
        x2+=300;
        x3+=300;
        y1+=300;
        y2+=300;
        y3+=300;
        z1+=300;
        z2+=300;
        z3+=300;
        z = vectorm1(x2 - x1, x3 - x1, y2 - y1, y3 - y1, z2 - z1, z3 - z1);
        z = vector.normalize3D(z);
        double k[] = new double[3];
        k[0] = 133737370;// - x1;
        k[1] = 1636438893;// - y1;
        k[2] = 3003030;// - z1;
        k = vector.normalize3D(k);
        double t1;
        t1 = k[0] * x4 + k[1] * y4 + k[2] * z4;
        double t2;
        t2 = k[0] * x5 + k[1] * y5 + k[2] * z5;
        double t3;
        t3 = k[0] * x6 + k[1] * y6 + k[2] * z6;
        double AB[] = {x2-x1,y2-y1,z2-z1,0};
        double AC[] = {x3-x1,y3-y1,z3-z1,0};
       for (int x =0 /*(int) (Math.max((Math.min(x1, Math.min(x2, x3))),0))*/; x < 1376/*(int) (Math.min((Math.max(x1, Math.max(x2, x3))),1376))*/; x++) {
         for (int y = 0 /*(int) (Math.max((Math.min(x1, Math.min(x2, x3))),0))*/; y <786/*(int) (Math.min((Math.max(x1, Math.max(x2, x3))),1376))*/; y++) {
                double PA[] = {x1-x,y1-y,0,0};
                double u1[]={AB[0],AC[0],PA[0]};
                double u2[]={AB[1],AC[1],PA[1]};
                double V[] = vectorm2(u1,u2);
                double u = V[0]/V[2];         double v = V[1]/V[2];
               if (u + v <= 1 && u >= 0 && v >= 0){
                    double t=(t3*v+t2*u+t1*(1-u-v));
                    t = Math.min(1, t);

                    if(zBuffer[x][y]>(z1*(1-u-v)+z2*u+z3*v)) {
                        zBuffer[x][y] = (z1 * (1 - u - v) + z2 * u + z3 * v) ;
                        if(t>0 )
                            img.setRGB((int)(x), (int)(y), new Color((int) (t*255), (int) (t*255), (int) ((t)*255)).getRGB());
                        else
                        img.setRGB((int) (x), (int) (y), new Color(0, (int) 0, (int) 0).getRGB());
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
            z[i]=x[i]*y[0][i]+x[i]*y[1][i]+x[i]*y[2][i]+x[i]*y[3][i];
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