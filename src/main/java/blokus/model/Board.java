package blokus.model;

import java.util.List;

public interface Board {

    List<CellImpl> getPiece();

    void clearPieceList();

    boolean hasPiece(int height, int width);

    boolean hasColor(int height, int width, int color);

    void toggleCell(int height, int width, int color);

    boolean checkCorner(int height, int width, int color);

    void changeColors();

    boolean checkPiece(int no);

    void checkWinner();

    boolean checkAllCorners(int color);

}
