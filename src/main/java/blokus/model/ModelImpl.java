package blokus.model;

import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private int turn;
    private Player blue;
    private Player yellow;
    private Player red;
    private Player green;
    private Board board;
    private List<ModelObserver> observers;

    public ModelImpl() {
        turn = 1;
        blue = new PlayerImpl(1);
        yellow = new PlayerImpl(2);
        red = new PlayerImpl(3);
        green = new PlayerImpl(4);
        this.board = new BoardImpl();
        this.observers = new ArrayList<ModelObserver>();
    }

    @Override
    public List<CellImpl> getPiece() {
        return board.getPiece();
    }

    @Override
    public void clearPieceList() {
        board.clearPieceList();
    }

    @Override
    public boolean hasPiece(int height, int width) {
        return board.hasPiece(height, width);
    }

    @Override
    public int findPiece(int height, int width) {
        if(turn == 1) {
            return blue.findPiece(height, width);
        }
        else if(turn == 2) {
            return yellow.findPiece(height, width);
        }
        else if(turn == 3) {
            return red.findPiece(height, width);
        }
        else if(turn == 4) {
            return green.findPiece(height, width);
        }
        return 0;
    }

    @Override
    public void clearPiece(int piece) {
        if(turn == 1) {
            blue.clearPiece(piece);
        }
        else if(turn == 2) {
            yellow.clearPiece(piece);
        }
        else if(turn == 3) {
            red.clearPiece(piece);
        }
        else if(turn == 4) {
            green.clearPiece(piece);
        }
    }

    @Override
    public int colorPlayer(int height, int width) {
        return 0;
    }

    @Override
    public boolean hasColor(int height, int width, int color) {
        return board.hasColor(height, width, color);
    }

    @Override
    public void toggleCell(int height, int width, int color) {
        board.toggleCell(height, width, color);
        notifyObservers();
    }

    @Override
    public boolean checkCorner(int height, int width, int color) {
        return board.checkCorner(height, width, color);
    }

    @Override
    public void changeColors() {
        board.changeColors();
        turn++;
        if(turn == 5) {
            turn = 1;
        }
        notifyObservers();
    }

    @Override
    public boolean checkPiece(int no) {
        return board.checkPiece(no);
    }

    @Override
    public void checkWinner() {
        board.checkWinner();
    }

    @Override
    public void addObserver(ModelObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public boolean colorBlue(int height, int width) {
        return blue.colorPlayer(height, width) == 1;
    }

    @Override
    public boolean colorYellow(int height, int width) {
        return yellow.colorPlayer(height, width) == 2;
    }

    @Override
    public boolean colorRed(int height, int width) {
        return red.colorPlayer(height, width) == 3;
    }

    @Override
    public boolean colorGreen(int height, int width) {
        return green.colorPlayer(height, width) == 4;
    }

    @Override
    public boolean hasPieceTurn(int height, int width, int turn) {
        return false;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    private void notifyObservers() {
        for (ModelObserver m : observers) {
            m.update(this);
        }
    }
}
