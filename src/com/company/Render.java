package com.company;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {


    //Стоит начать с этого
    public static void renderTriangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3,double x4,double y4,double x5,double y5,double x6,double y6) {
        {
            double li[]= new double[3];
            li[0]=786;
            li[1]=1366;



            for (int i = (int) Math.min(x1,Math.min(x2,x3)); i <Math.max(x1,Math.max(x2,x3)); i++) {
                for (int j = (int) Math.min(y1,Math.min(y2,y3)); j <Math.max(y1,Math.max(y2,y3)); j++) {

                    double A = (x1-i)*(y2-y1)-(x2-x1)*(y1-j);
                    double B = (x2-i)*(y3-y2)-(x3-x2)*(y2-j);
                    double C = (x3-i)*(y1-y3)-(x1-x3)*(y3-j);

                    if(Math.signum(A)==Math.signum(B) && Math.signum(B)==Math.signum(C)){
                        double h1=Math.acos(((x1-i)*(x4-i) + (y1-j)*(y4-j))/(Math.sqrt((x1-i)*(x1-i)+(y1-j)*(y1-j))*Math.sqrt((x4-i)*(x4-i)+(y4-j)*(y4-j))));
                        double h2=Math.acos(((x2-i)*(x5-i) + (y2-j)*(y5-j))/(Math.sqrt((x2-i)*(x2-i)+(y2-j)*(y2-j))*Math.sqrt((x5-i)*(x5-i)+(y5-j)*(y5-j))));
                        double h3=Math.acos(((x3-i)*(x6-i) + (y3-j)*(y6-j))/(Math.sqrt((x3-i)*(x3-i)+(y3-j)*(y3-j))*Math.sqrt((x5-i)*(x5-i)+(y6-j)*(y6-j))));
                        double h4=h1*h2*h3;

                        //double h4=Math.acos(((x1-i)*(li[0]-i) + (y1-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x1)*(i-x1)+(j-y1)*(j-y1))))*Math.acos(((x2-i)*(li[0]-i) + (y2-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x2)*(i-x2)+(j-y2)*(j-y2))))*Math.acos(((x3-i)*(li[0]-i) + (y3-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x3)*(i-x3)+(j-y3)*(j-y3))));
                        //System.out.println(h4);
                       if(h4>0 && h4<1) {

                            img.setRGB(i, j, new Color((int) (h4 * 255), (int) (h4 * 255), (int) (h4 * 255)).getRGB());
                        }
                        else
                            img.setRGB(i, j, new Color(210, 62, 62).getRGB());
                    }
                    if((A==0)&&(B==0)&&(C==0)){
                        double h1=Math.acos(((x1-i)*(x4-i) + (y1-j)*(y4-j))/(Math.sqrt((x1-i)*(x1-i)+(y1-j)*(y1-j))*Math.sqrt((x4-i)*(x4-i)+(y4-j)*(y4-j))));
                        double h2=Math.acos(((x2-i)*(x5-i) + (y2-j)*(y5-j))/(Math.sqrt((x2-i)*(x2-i)+(y2-j)*(y2-j))*Math.sqrt((x5-i)*(x5-i)+(y5-j)*(y5-j))));
                        double h3=Math.acos(((x3-i)*(x6-i) + (y3-j)*(y6-j))/(Math.sqrt((x3-i)*(x3-i)+(y3-j)*(y3-j))*Math.sqrt((x5-i)*(x5-i)+(y6-j)*(y6-j))));
                        double h4=h1*h2*h3;

                      //  double h4=Math.acos(((x1-i)*(li[0]-i) + (y1-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x1)*(i-x1)+(j-y1)*(j-y1))))*Math.acos(((x2-i)*(li[0]-i) + (y2-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x2)*(i-x2)+(j-y2)*(j-y2))))*Math.acos(((x3-i)*(li[0]-i) + (y3-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x3)*(i-x3)+(j-y3)*(j-y3))));
                       // System.out.println(h4);
                        if(h4>0 && h4<1)
                            img.setRGB(i, j, new Color((int) (h4 * 255), (int) (h4 * 255), (int) (h4 * 255)).getRGB());
//
                        else
                            img.setRGB(i, j, new Color(210, 63, 63).getRGB());


                    }
                }
            }
        }
    }
   // int a=(int) (A/C*255);
    //int b=(int) (B/C*255);
    //int c=(int) ((1-A/C-B/C)*255);
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
