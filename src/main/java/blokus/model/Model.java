package blokus.model;

public interface Model extends Board, Player {

    void addObserver(ModelObserver observer);

    void removeObserver(ModelObserver observer);

    boolean colorBlue(int height, int width);

    boolean colorYellow(int height, int width);

    boolean colorRed(int height, int width);

    boolean colorGreen(int height, int width);

    boolean hasPieceTurn(int height, int width, int turn);

    int getTurn();
}
