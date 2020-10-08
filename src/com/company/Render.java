package com.company;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {


    //Стоит начать с этого
    public static void renderTriangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3,double x4,double y4,double x5,double y5,double x6,double y6) {
        {
            double li[]= new double[3];
            li[0]=1366;
            li[1]=786;
            double z[]=new double[3];
            z=vectorm(x1-x2,y1-y2,x1-x3,y1-y3,1,1);
            double z1=z[0]/Math.sqrt(z[0]*z[0]+z[1]*z[1]);
            double z2=z[1]/Math.sqrt(z[0]*z[0]+z[1]*z[1]);
            z[0]=z1;
            z[1]=z2;
            double k[]=new double [3];
            k[0]=(x1-li[0])/Math.sqrt(((x1-li[0])*(x1-li[0])+(y1-li[1])*(y1-li[1])));
            k[1]=(x2-li[1])/Math.sqrt(((x1-li[0])*(x1-li[0])+(y1-li[1])*(y1-li[1])));
            double t;
            t=k[0]*z[0]+k[1]*z[1];
            System.out.println(t);
            for (int i = (int) Math.min(x1,Math.min(x2,x3)); i <Math.max(x1,Math.max(x2,x3)); i++) {
                for (int j = (int) Math.min(y1,Math.min(y2,y3)); j <Math.max(y1,Math.max(y2,y3)); j++) {

                    double A = (x1-i)*(y2-y1)-(x2-x1)*(y1-j);
                    double B = (x2-i)*(y3-y2)-(x3-x2)*(y2-j);
                    double C = (x3-i)*(y1-y3)-(x1-x3)*(y3-j);
                    A=A/C;
                    B=B/C;
                    C=1-A-B;
                    if(0<A && 1>A && 0<B && 1>B && 0<C && 1>C){
                        if(t<1 && t>0) {
                            double h1 = x1 - x2;
                            double h2 = y2 - y1;
                            double u1 = h1 * li[0] + li[1] * h2;
                            double h3 = Math.cos(((x6 - x3) * (li[0] - x3) + (y6 - y3) * (li[1] - y3)) / (Math.sqrt((x3 - x6) * (x3 - x6) + (y3 - y6) * (y3 - y6)) * Math.sqrt((x3 - li[0]) * (x3 - li[0]) + (y3 - li[1]) * (y3 - li[1]))));
                            // double h2=Math.acos(((x2-i)*(x5-i) + (y2-j)*(y5-j))/(Math.sqrt((x2-i)*(x2-i)+(y2-j)*(y2-j))*Math.sqrt((x5-i)*(x5-i)+(y5-j)*(y5-j))));
                            //double h3=Math.acos(((x3-i)*(x6-i) + (y3-j)*(y6-j))/(Math.sqrt((x3-i)*(x3-i)+(y3-j)*(y3-j))*Math.sqrt((x5-i)*(x5-i)+(y6-j)*(y6-j))));
                            // double h4=h1*h2*h3;

                            //double h4=Math.acos(((x1-i)*(li[0]-i) + (y1-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x1)*(i-x1)+(j-y1)*(j-y1))))*Math.acos(((x2-i)*(li[0]-i) + (y2-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x2)*(i-x2)+(j-y2)*(j-y2))))*Math.acos(((x3-i)*(li[0]-i) + (y3-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x3)*(i-x3)+(j-y3)*(j-y3))));
                            //System.out.println(h4);
                            // if(h4>0 && h4<1) {

                            //   img.setRGB(i, j, new Color((int) (h4 * 255), (int) (h4 * 255), (int) (h4 * 255)).getRGB());
                            //   }
                            //    else
                            double v = ((double) (x1 - i) * (y1 - y2) / (x1 - x2) - (y1 - j)) / ((double) (y1 - y3) - (x1 - x3) * (y1 - y2) / (x1 - x2));
                            double u = ((double) (y1 - j) * (y1 - y3) / (x1 - x3) - (x1 - i)) / ((double) (x1 - x2) - (y1 - y2) * (x1 - x3) / (y1 - y3));
                            img.setRGB(1366-i,786- j, new Color((int)(A*255*t), (int)(B*255*t), (int)(C*255*t)).getRGB());
                            int a = (int) (((A / C) * 255) * h1);
                            int b = (int) ((B / C * 255) * h2);
                            int c = (int) ((1 - A / C - B / C) * 255 * h3);
                        }
                        else
                            img.setRGB(1366-i,786-j,new Color(0,0,0).getRGB());
                    }
                    if((A==0)&&(B==0)&&(C==0)){
                      //  double h1=Math.acos(((x1-i)*(x4-i) + (y1-j)*(y4-j))/(Math.sqrt((x1-i)*(x1-i)+(y1-j)*(y1-j))*Math.sqrt((x4-i)*(x4-i)+(y4-j)*(y4-j))));
                     //   double h2=Math.acos(((x2-i)*(x5-i) + (y2-j)*(y5-j))/(Math.sqrt((x2-i)*(x2-i)+(y2-j)*(y2-j))*Math.sqrt((x5-i)*(x5-i)+(y5-j)*(y5-j))));
                     //   double h3=Math.acos(((x3-i)*(x6-i) + (y3-j)*(y6-j))/(Math.sqrt((x3-i)*(x3-i)+(y3-j)*(y3-j))*Math.sqrt((x5-i)*(x5-i)+(y6-j)*(y6-j))));
                     //   double h4=h1*h2*h3;

                      //  double h4=Math.acos(((x1-i)*(li[0]-i) + (y1-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x1)*(i-x1)+(j-y1)*(j-y1))))*Math.acos(((x2-i)*(li[0]-i) + (y2-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x2)*(i-x2)+(j-y2)*(j-y2))))*Math.acos(((x3-i)*(li[0]-i) + (y3-j)*(li[1]-j))/(Math.sqrt((i-li[0])*(i-li[0])+(j-li[1])*(j-li[1]))*Math.sqrt((i-x3)*(i-x3)+(j-y3)*(j-y3))));
                       // System.out.println(h4);
                      //  if(h4>0 && h4<1)
                       //     img.setRGB(i, j, new Color((int) (h4 * 255), (int) (h4 * 255), (int) (h4 * 255)).getRGB());
//
                     //   else
                    double h2=Math.cos(((x5-x2)*(li[0]-x2) + (y5-y2)*(li[1]-y2))/(Math.sqrt((x2-x5)*(x2-x5)+(y2-y5)*(y2-y5))*Math.sqrt((x2-li[0])*(x2-li[0])+(y2-li[1])*(y2-li[1]))));
                    double h3=Math.cos(((x6-x3)*(li[0]-x3) + (y6-y3)*(li[1]-y3))/(Math.sqrt((x3-x6)*(x3-x6)+(y3-y6)*(y3-y6))*Math.sqrt((x3-li[0])*(x3-li[0])+(y3-li[1])*(y3-li[1]))));
                    double h1=Math.cos(((x4-x1)*(li[0]-x1) + (y4-y1)*(li[1]-y1))/(Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4))*Math.sqrt((x1-li[0])*(x1-li[0])+(y1-li[1])*(y1-li[1]))));
                    int a=(int) (255*h1*h2*h3);
                        img.setRGB(1366-i,786- j, new Color((int)(A*255*t), (int)(B*255*t), (int)(C*255*t)).getRGB());

                    }}
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

    public static double[] vectorm(double x1, double y1,double x2, double y2,double x3,double y3)
    {
        double z[] = new double[3];
        z[0]=x3*y2-x2*y3;
        z[1]=x1*y3-x3*y1;
        z[2]=x2*y1-x1*y2;
        return z;
    }
    public static double vectorsc(double x[], double y[])
    {
        double z=0;
        for(int i=0;i<2;i++)
        {
            z=z+x[i]*y[i];
        }
        return z;
    }
    public static double [][] matrix(double x[][], double y[][])
    {
        double z[][]=new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                 z[i][j]=x[0][i]*y[j][0]+x[1][i]*y[j][1]+x[2][i]*y[j][2]+x[3][i]*y[j][3];
            }
        }
        return z;
    }
    public static double[] matrixv(double x[][],double y[])
    {
        double z[]=new double[4];
        z[0]=0;
        z[1]=0;
        z[2]=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                z[i]=z[i]+x[i][j]*y[j];
            }
        }
        return z;
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
