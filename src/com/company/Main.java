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
//import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Main extends JFrame {

    private static List<String> readUsingScanner(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
//        Scanner scanner = new Scanner(, StandardCharsets.UTF_8.name());
//        здесь мы можем использовать разделитель, например: "\\A", "\\Z" или "\\z"
//        String data = scanner.useDelimiter("\\A").next();
//        scanner.close();
//        return data;

    }
    static final int w = 1366;
    static final int h = 786;

    public static void draw(Graphics2D g) throws IOException {
        String fileName= "/Users/Admin/Desktop/rer.txt";
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

//        String s="0";
//        s= readUsingScanner(fileName);
        int k=0;
        double u[][] = new double[1000][3];
        double vn[][] = new double[1000][3];
        double vt[][] = new double[1000][3];
        double f[][]= new double[1000][3];
        int ff[]=new int [3];
        int kk=0;
        int kkk=0;
        double z[]=new double[3];
        double x[]= new double [3];
        double y[]= new double [3];
        double xn[]= new double[3];
        double yn[]=new double[3];
        double zn[]=new double[3];
        for(String l : readUsingScanner(fileName)) {

            k++;
            l.split(" ");
            if (l.length() != 0) {
                if (l.charAt(0) == 'v' && l.charAt(1) == ' ') {
                    kk = kk + 1;
                    String s = "";
                    int qq = 0;
                    for (int i = 2; i < l.length(); i++) {
                        if (l.charAt(i) != ' ') {
                            s = s + l.charAt(i);
                        } else {
                            u[kk][qq] = Double.parseDouble(s);
                            s = "";
                            qq = qq + 1;
                        }
                    }
                    u[kk][qq] = Double.parseDouble(s);
                    s = "";
                    qq = qq + 1;
                }
                if (l.charAt(0) == 'v' && l.charAt(1) == 't') {
                    kk = 0;
                    String s = "";
                    int qq = 0;
                    for (int i = 3; i < l.length(); i++) {
                        if (l.charAt(i) != ' ') {
                            s = s + l.charAt(i);
                        } else {
                            vt[i][qq] = Double.parseDouble(s);
                            s = "";

                            qq = qq + 1;
                        }
                    }

                }
                if (l.charAt(0) == 'v' && l.charAt(1) == 'n') {

                    String s = "";
                    int qq = 0;
                    for (int i = 3; i < l.length(); i++) {
                        if (l.charAt(i) != ' ') {
                            s = s + l.charAt(i);
                        } else {
                            vn[i][qq] = Double.parseDouble(s);
                            s = "";

                            qq = qq + 1;
                        }
                    }

                }
                if (l.charAt(0) == 'f' && l.charAt(1) == ' ') {
                    kk = kk + 1;
                    String s = "";
                    int qq = 0;
                    int ss = 0;

                    for (int i = 2; i < l.length(); i++) {

                        if (l.charAt(i) != ' ' && l.charAt(i) != '/') {
                            s = s + l.charAt(i);
                        }
                        if (l.charAt(i) == '/') {
                            if (qq == 0) {
                                if (ss == 0) {
                                    int hh = Integer.parseInt(s);
                                    s = "";
                                    x[qq] = u[hh][0] ;
                                    y[qq] = u[hh][1] ;
                                    z[qq] = u[hh][2] ; }
                                if (ss == 1) {
                                    int hh = Integer.parseInt(s);
                                    s = "";

                                    xn[qq] = vn[hh][0] ;
                                    yn[qq] = vn[hh][1] ;
                                    zn[qq]= vn[hh][2] ;
                                }
                                if (ss == 2) {
                                    int hh = Integer.parseInt(s);
                                    s = "";

                                }
                                ss=ss+1;
                            }
                            if (qq == 1) {
                                if (ss == 0) {
                                    int hh = Integer.parseInt(s);
                                    x[qq] = u[hh][0] ;
                                    y[qq] = u[hh][1] ;
                                    z[qq] = u[hh][2] ;
                                    s = "";
                                }
                                if (ss == 1) {
                                    int hh = Integer.parseInt(s);

                                    xn[qq] = vn[hh][0] ;
                                    yn[qq] = vn[hh][1] ;
                                    zn[qq] = vn[hh][2];
                                    s = "";
                                }
                                if (ss == 2) {
                                    int hh = Integer.parseInt(s);
                                    s = "";

                                }
                                ss=ss+1;
                            }
                            if (qq == 2) {
                                if (ss == 0) {
                                    int hh = Integer.parseInt(s);
                                    s = "";
                                    x[qq] = u[hh][0] ;
                                    y[qq] = u[hh][1] ;
                                    z[qq] = u[hh][2] ;

                                }
                                if (ss == 1) {
                                    int hh = Integer.parseInt(s);
                                    s = "";

                                    xn[qq] = vn[hh][0] ;
                                    yn[qq] = vn[hh][1] ;
                                    zn[qq] = vn[hh][2];
                                }
                                if (ss == 2) {
                                    int hh = Integer.parseInt(s);
                                    s = "";

                                }
                            }
                            ss = ss + 1;
                        }
                        if (l.charAt(i) == ' ') {
                            ss = 0;
                            s = "";
                            qq = qq + 1;

                        }
                        double t[]= new double[3];
                        double p[]= new double[3];
                        double o[]= new double[3];
                        System.out.println(kkk);
                        Render.renderTriangle(img, x[0],y[0],x[1],y[1],z[0],z[1]);
                }
                }
            }
        }
        System.out.println("=========================");


        //  Render.renderTriangle(img, 1366, 500, 500, 300, 400,400);


        System.out.println();
        //Создаем буффер в который рисуем кадр.


        //Рисуем кадр.


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