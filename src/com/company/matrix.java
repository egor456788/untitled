package com.company;

import javax.swing.*;

public class matrix {
    public static double[][] translation(double al,double be,double ga, double a,double b, double c) {
        double l[][]=new double[4][4];
        l[0][0] = 1;
        l[0][1] = 0;
        l[0][2] = 0;
        l[0][3] = 0;
        l[1][0] = 0;
        l[1][1] = 1;
        l[1][2] = 0;
        l[1][3] = 0;
        l[2][0] = 0;
        l[2][1] = 0;
        l[2][2] = 1;
        l[2][3] = 0;
        l[3][0] = 0;
        l[3][1] = 0;
        l[3][2] = 0;
        l[3][3] = 1;
if(al!=0){
        double l1[][] = new double[4][4];
        l1[0][0] = 1;
        l1[0][1] = 0;
        l1[0][2] = 0;
        l1[0][3] = 0;
        l1[1][0] = 0;
        l1[1][1] = Math.cos(al);
        l1[1][2] = -Math.sin(al);
        l1[1][3] = 0;
        l1[2][0] = 0;
        l1[2][1] = Math.sin(al);
        l1[2][2] = Math.cos(al);
        l1[2][3] = 0;
        l1[3][0] = 0;
        l1[3][1] = 0;
        l1[3][2] = 0;
        l1[3][3] = 1;
        l=Render.matrix(l,l1);
    }
if(be!=0){
        double l2[][] = new double[4][4];
        l2[0][0] = Math.cos(be);
        l2[0][1] = 0;
        l2[0][2] = Math.sin(be);
        l2[0][3] = 0;
        l2[1][0] = 0;
        l2[1][1] = 1;
        l2[1][2] = 0;
        l2[1][3] = 0;
        l2[2][0] = -Math.sin(be);
        l2[2][1] = 0;
        l2[2][2] = Math.cos(be);
        l2[2][3] = 0;
        l2[3][0] = 0;
        l2[3][1] = 0;
        l2[3][2] = 0;
        l2[3][3] = 1;
        l=Render.matrix(l,l2);
    }
        if(ga!=0)
        {
            double l3[][]=new double [4][4];
            l3[0][0]=Math.cos(ga);
            l3[0][1]=-Math.sin(ga);
            l3[0][2]=0;
            l3[0][3]=0;
            l3[1][0]=Math.sin(ga);
            l3[1][1]=Math.cos(ga);
            l3[1][2]=0;
            l3[1][3]=0;
            l3[2][0]=0;
            l3[2][1]=0;
            l3[2][2]=1;
            l3[2][3]=0;
            l3[3][0]=0;
            l3[3][1]=0;
            l3[3][2]=0;
            l3[3][3]=1;
            l=Render.matrix(l,l3);
        }
        l[0][3]=a;
        l[1][3]=b;
        l[2][3]=c;
        return l;
    }
}
