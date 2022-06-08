package blokus.model;

public interface Player {

    boolean hasPiece(int height, int width);

    int findPiece(int height, int width);

    void clearPiece(int piece);

    int colorPlayer(int height, int width);

}
