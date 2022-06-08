package blokus.controller;

public interface Controller {
    void toggleShaded(int height, int width, int color);
    boolean isBlue(int height, int width);
    boolean isYellow(int height, int width);
    boolean isRed(int height, int width);
    boolean isGreen(int height, int width);
    boolean colorBlue(int height, int width);
    boolean colorYellow(int height, int width);
    boolean colorRed(int height, int width);
    boolean colorGreen(int height, int width);
    void togglePieceBlue(int height, int width);
    void togglePieceYellow(int height, int width);
    void togglePieceRed(int height, int width);
    void togglePieceGreen(int height, int width);
    int getColor();
}
