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
        int x1=270,x2=300,x3=150,y1=345,y2=280,y3=160;
        int h=0;
        for(int i=1;i<16;i++)
        {
            x1=(x1*i)%1366;
            x2=(x2*i)%1366;
            x3=(x3*i)%1366;
            y1=(y1*i)%768;
            y2=(y2*i)%768;
            y3=(y3*i)%768;
            Render.renderTriangle(img, x1, y1, x2, y2, x3,y3);
        }
        Render.renderTriangle(img, 1366, 500, 500, 300, 400,400);
//        String s="0";
//        s= readUsingScanner(fileName);
int k=0;
        double u[][] = new double[1000][3];
        double vn[][] = new double[1000][3];
        double vt[][] = new double[1000][3];
        double f[][]= new double[1000][3];
        int kk=0;
        for(String l : readUsingScanner(fileName)){
            k++;
            l.split(" ");

            if(l.length()!=0) {
                if (l.charAt(0) == 'v' && l.charAt(1)==' ') {
                  kk=kk+1;
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
                    s="";
                    qq=qq+1;
                }

                if (l.charAt(0) == 'v' && l.charAt(1)=='t') {
                    kk=0;
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
                            vt[i][qq]=Double.parseDouble(s);
                            s="";

                            qq=qq+1;
                        }
                    }

                }
                if (l.charAt(0) == 'v' && l.charAt(1)=='n') {

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
                            vn[i][qq]=Double.parseDouble(s);
                            s="";

                            qq=qq+1;
                        }
                    }

                }
                if (l.charAt(0) == 'f' && l.charAt(1)==' ') {
                    kk=kk+1;
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
                            f[kk][qq]=Double.parseDouble(s);

                            s="";
                            qq=qq+1;
                        }
                    }
                    f[kk][qq]=Double.parseDouble(s);
                    s="";
                    qq=qq+1;
                }
            }
        }
        for(int i=0; i<563;i++)
        {
            for(int j=0;j<3;j++) {
                System.out.println(u[i][j]);
                System.out.println(f[i][j]);
            }
        }

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