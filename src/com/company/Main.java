package com.company;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Main extends JFrame {

    private static List<String> readUsingScanner(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));


    }
    static final int w = 1366;
    static final int h = 786;

    public static void draw(Graphics2D g) throws IOException {
        String fileName= "/Users/Admin/Desktop/rer.txt";
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        int k=0;
        double u[][] = new double[1000][3];
        double vn[][] = new double[1000][3];
        double vt[][] = new double[1000][3];
        double f[][]= new double[1000][3];
        int ff[]=new int [3];
        int yy[]=new int [3];
        int kk=0;
        int uu=0;
        double[][] zBuffer=new double[1366][786];
        for(int i=0; i<1366; i++){
            for (int j = 0; j < 786; j++) {
                zBuffer[i][j]=10000000;
            }
        }
        int oo=0;
        for(String l : readUsingScanner(fileName)){

            l.split(" ");
            if(l.length()!=0) {
                if (l.charAt(0) == 'v' && l.charAt(1)==' ') {
                    kk++;
                    String s="";
                    int qq=0;
                    for(int i=2;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ')
                        {
                            s=s+l.charAt(i);
                        }
                        else
                        {
                            u[kk][qq]=Double.parseDouble(s);
                            s="";
                            qq=qq+1;
                        }
                    }
                    u[kk][qq]=Double.parseDouble(s);

                }
                if (l.charAt(0) == 'v' && l.charAt(1)=='t') {
                    uu++;
                    String s="";
                    int qq=0;
                    for(int i=3;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ')
                        {
                            s=s+l.charAt(i);
                        }
                        else
                        {
                            vt[uu][qq]=Double.parseDouble(s);
                            s="";
                            qq=qq+1;
                        }
                    }
                    vt[uu][qq]=Double.parseDouble(s);
                }
                if (l.charAt(0) == 'v' && l.charAt(1)=='n') {
                    oo++;
                    String s="";
                    int qq=0;
                    kk=0;
                    for(int i=3;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ')
                        {
                            s=s+l.charAt(i);
                        }
                        else
                        {
                            vn[oo][qq]=Double.parseDouble(s);
                            s="";
                            qq=qq+1;
                        }
                    }
                    vn[oo][qq]=Double.parseDouble(s);

                }
                if (l.charAt(0) == 'f' && l.charAt(1)==' ') {
                    String s="";
                    int qq=0;
                    int ss=0;
                    l=l+" ";
                    for(int i=2;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ' && l.charAt(i)!='/')
                        {
                            s=s+l.charAt(i);
                        }
                        if(l.charAt(i)=='/')
                        {
                            if(qq==0) {
                                ff[ss] = Integer.parseInt(s);
                                s="";
                            }
                            if (qq==1) {
                                s = "";
                            }
                            qq=qq+1;
                        }
                        if(l.charAt(i)==' ') {
                            yy[ss]= Integer.parseInt(s);
                            ss = ss + 1;
                            s="";
                            qq=0;
                        }
                    }
                    int hh=ff[0];
                    double x4=u[hh][0];
                    double y4=u[hh][1];
                    double z4=u[hh][2];

                    hh=yy[0];

                    double x1=vn[hh][0];
                    double y1=vn[hh][1];
                    double z1=vn[hh][2];

                    hh=ff[1];
                    double x5=u[hh][0];
                    double y5=u[hh][1];
                    double z5=u[hh][2];
                    hh=yy[1];
                    double x2=vn[hh][0];
                    double y2=vn[hh][1];
                    double z2=vn[hh][2];
                    hh=ff[2];
                    double x6=u[hh][0];
                    double y6=u[hh][1];
                    double z6=u[hh][2];
                    hh=yy[2];
                    double x3=vn[hh][0];
                    double y3=vn[hh][1];
                    double z3=vn[hh][2];

                    Render.renderTriangle(img, x4, y4,x5, y5,  x6,y6,z4,z5,z6,x1,y1,z1,x2,y2,z2,x3,y3,z3,zBuffer);
                }
            }
        }
        g.drawImage(img, 0, 0, null);
    }



    //магический код позволяющий всему работать, лучше не трогать
    public static void main(String[] args) throws InterruptedException, IOException {
        Main jf = new Main();
        jf.setSize(w, h);//размер экрана
        jf.setUndecorated(false);//показать заголовок окна
        jf.setTitle("Моя супер программа");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.createBufferStrategy(2);
        //в бесконечном цикле рисуем новый кадр
        while (true) {
            long frameLength = 1000 / 60; //пытаемся работать из рассчета  60 кадров в секунду
            long start = System.currentTimeMillis();
            BufferStrategy bs = jf.getBufferStrategy();
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            g.clearRect(0, 0, jf.getWidth(), jf.getHeight());
            draw(g);

            bs.show();
            g.dispose();

            long end = System.currentTimeMillis();
            long len = end - start;
            if (len < frameLength) {
                Thread.sleep(frameLength - len);
            }
        }

    }
    public void keyTyped(KeyEvent e) {
    }

    //Вызывается когда клавиша отпущена пользователем, обработка события аналогична keyPressed
    public void keyReleased(KeyEvent e) {

    }
}