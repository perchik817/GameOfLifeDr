package life_game;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel {

    Cell cell;
    public Box(int x, int y) {
        super();
        cell = new Cell();
        setBounds(x * Config.size, y * Config.size, Config.size, Config.size);
        setBackground(Config.getColor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();

            }
        });
    }

    public void initCells(int x, int y){

    }

    public void setColor(){
        setBackground(Config.getColor(cell.status));
    }

    void step1(){
        cell.step1();
        setColor();
    }

    void step2(){
        cell.step2();
        setColor();
    }
}
