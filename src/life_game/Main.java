package life_game;

import life_game.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        javax.swing.SwingUtilities.invokeLater(window);//запуск в отдельном потоке к-ой-л программы
    }
}