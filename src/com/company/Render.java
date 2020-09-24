package com.company;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {


    //Стоит начать с этого
    public static void renderTriangle(BufferedImage img, int x1, int y1, int x2, int y2, int x3, int y3) {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                double A = (x1 - i) * (y2 - y1) - (x2 - x1) * (y1 - j);
                double B = (x2 - i) * (y3 - y2) - (x3 - x2) * (y2 - j);
                double C = (x3 - i) * (y1 - y3) - (x1 - x3) * (y3 - j);
                A=A/C;
                B=B/C;
                C=1-A-B;
                if (0<A && 1>A && 0<B && 1>B && 1>C && 0<C) {
                    A=A*255;
                    B=B*255;
                    C=C*255;
                    int a= (int) A;
                    int b= (int) B;
                    int c= (int) C;
                    img.setRGB(i, j, new Color(a, b, c).getRGB());
                }
                if ((A == 0) && (B == 0) && (C == 0)) {
                    A=A*255;
                    B=B*255;
                    C=C*255;
                    int a= (int) A;
                    int b= (int) B;
                    int c= (int) C;
                    img.setRGB(i, j, new Color(a, b, c).getRGB());
                }
            }
        }
    }

    public static double [] vectors(int x[], double y[]) {

        double z[] = new double[3];
        for (int i = 0; i < 3; i++) {
            z[i] = x[i] + y[i];
        }
        return  z;
    }

    public static double[] vectorm(double x[], double y[])
    {
        double z[] = new double[3];
        z[0]=x[2]*y[1]-x[1]*y[2];
        z[1]=x[0]*y[2]-x[2]*y[0];
        z[2]=x[1]*y[0]-x[0]*y[1];
        return z;
    }
    public static double[] vectorsc(double x[], double y)
    {
        for(int i=0;i<3;i++)
        {
            x[i]=x[i]*y;
        }
        return x;
    }
}


       /* if (x1 > x2) {
            if (y1 > y2) {
                if ((x1 - x2) > (y1 - y2)) {
                    for (int i = x2; i < x1; i++) {
                        int y = ((x1-i)*(y1-y2)/(x1-x2)+y1);
                        img.setRGB(i,y,Color.BLACK.getRGB());


                    }
                } else {
                    for (int i = y2; i < y1; i++) {
                        int x = ((y1-i)*(x1-x2))/(y1 - y2)+x1;
                        img.setRGB(x,i,Color.BLACK.getRGB());

                    }

                }
            }
            else {
                if ((x1 - x2) > (y2 - y1)) {
                    for (int i = x2; i < x1; i++) {
                        int y = ((x1-i)*(y1-y2)/(x1-x2)+y1);
                        img.setRGB(i,y,Color.BLACK.getRGB());


                    }
                } else {
                    for (int i = y1; i < y2; i++) {
                        int x = ((y1-i)*(x2-x1))/(y1 - y2)+x1;
                        img.setRGB(x,i,Color.BLACK.getRGB());

                    }
            }
            }
        }
            else {
            if (y2 > y1) {
                if ((x2 - x1) > (y2 - y1)) {
                    for (int i = x1; i < x2; i++) {
                        int y = (i-x1)*(y2-y1)/(x1-x2)+y1;
                        img.setRGB(i,y,Color.BLACK.getRGB());

                    }
                } else {
                    for (int i = y1; i < y2; i++) {
                        int x = ((y1-i)*(x2-x1))/(y1 - y2)+x1;

                        img.setRGB(x, i,Color.BLACK.getRGB());

                    }

                }
            }
            else {
                if ((x2 - x1) > (y1 - y2)) {
                    for (int i = x1; i < x2; i++) {
                        int y = ((x1-i)*(y1-y2)/(x1-x2)+y1);
                        img.setRGB(i,y,Color.BLACK.getRGB());
                    }
                }
                else {
                    for (int i = y2; i < y1; i++) {
                        int x = ((y1-i)*(x1-x2))/(y1 - y2)+x1;
                        img.setRGB(x,i,Color.BLACK.getRGB());

                    }
            }
            }
            }
            }*/

