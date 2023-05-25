package life_game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JButton;

public class Window implements Runnable{
    JFrame frame;//поле для рисования
    Box[][] boxes;

    //JButton startButton = new JButton("Start Program");
    @Override
    public  void run(){
        initFrame(); //инициализация окна
        initBoxes();
        initTimer();
        //initBtn();
    }

//    void initBtn(){
//        startButton.addActionListener(e -> {
//            System.out.println("Program has started");
//        });
//        frame.add(startButton);
//        frame.pack();
//    }
    void initFrame(){
        frame = new JFrame();
        frame.getContentPane().setLayout(null); //расположение на всю форму
        frame.setSize(Config.size * Config.width , Config.size * Config.height );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие программы
        frame.setLocationRelativeTo(null); //расположение окна по центру экрана
        frame.setVisible(true);
        frame.setTitle("Life Game");
    }
    void initBoxes(){

        boxes = new Box[Config.width][Config.height];
        for (int x = 0; x< Config.width; x++){
            for (int y = 0; y< Config.height; y++){
                boxes[x][y] = new Box(x,y);
                frame.add(boxes[x][y]);
            }
        }
        for (int x = 0; x< Config.width; x++){          //выбор одной клетки
            for (int y = 0; y< Config.height; y++){
                for (int sx = -1; sx <= +1; sx++){   //проверка 8 соседей
                    for (int sy = -1; sy <= +1; sy++){
                        if (!(sx == 0 && sy == 0)){
                            boxes[x][y].cell.addNear(boxes
                                [(x + sx + Config.width) % Config.width] // tor
                                [(y + sy + Config.height) % Config.height].cell);
                        }
                    }
                }
            }
        }
    }

    private void initTimer(){
        TimerListener  t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener{
        boolean flop = false; // turn off/on
        @Override
        public void actionPerformed(ActionEvent e){
            flop = !flop;
            for (int x = 0; x< Config.width; x++){
                for (int y = 0; y< Config.height; y++){
                    if (flop)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();

                }
            }
        }
    }
}

