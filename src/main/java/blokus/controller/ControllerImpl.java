package blokus.controller;

import blokus.model.*;

public class ControllerImpl implements Controller{

    private Model model;

    public ControllerImpl(Model model) {
        this.model = model;
    }

    public void toggleShaded(int height, int width, int color){
        model.toggleCell(height, width, color);
    }

    public boolean isBlue(int height, int width){
    return model.hasColor(height, width, 1) || model.hasColor(height, width, 5);
    }

    public boolean isYellow(int height, int width){
        return model.hasColor(height, width, 2) || model.hasColor(height, width, 6);
    }

    public boolean isRed(int height, int width){
        return model.hasColor(height, width, 3) || model.hasColor(height, width, 7);
    }

    public boolean isGreen(int height, int width){
        return model.hasColor(height, width, 4) || model.hasColor(height, width, 8);
    }

    @Override
    public boolean colorBlue(int height, int width) {
        return model.colorBlue(height, width);
    }

    @Override
    public boolean colorYellow(int height, int width) {
        return model.colorYellow(height, width);
    }

    @Override
    public boolean colorRed(int height, int width) {
        return model.colorRed(height, width);
    }

    @Override
    public boolean colorGreen(int height, int width) {
        return model.colorGreen(height, width);
    }

    @Override
    public void togglePieceBlue(int height, int width) {
        if(model.getTurn() == 1 && model.colorBlue(height, width)) {
            int piece = model.findPiece(height, width);
            if(model.checkPiece(piece)) {
                if(model.getTurn() == 1) {
                    if(!model.hasColor(0, 0, 5)) {
                        return;
                    }
                }
                model.clearPiece(piece);
                model.changeColors();
            }
        }
    }

    @Override
    public void togglePieceYellow(int height, int width) {
        if(model.getTurn() == 2 && model.colorYellow(height, width)) {
            int piece = model.findPiece(height, width);
            if(model.checkPiece(piece)) {
                if(model.getTurn() == 2) {
                    if(!model.hasColor(0, 19, 6)) {
                        return;
                    }
                }
                model.clearPiece(piece);
                model.changeColors();
            }
        }
    }

    @Override
    public void togglePieceRed(int height, int width) {
        if(model.getTurn() == 3 && model.colorRed(height, width)) {
            int piece = model.findPiece(height, width);
            if(model.checkPiece(piece)) {
                if(model.getTurn() == 3) {
                    if(!model.hasColor(19, 19, 7)) {
                        return;
                    }
                }
                model.clearPiece(piece);
                model.changeColors();
            }
        }
    }

    @Override
    public void togglePieceGreen(int height, int width) {
        if(model.getTurn() == 4 && model.colorGreen(height, width)) {
            int piece = model.findPiece(height, width);
            if(model.checkPiece(piece)) {
                if(model.getTurn() == 4) {
                    if(!model.hasColor(19, 0, 8)) {
                        return;
                    }
                }
                model.clearPiece(piece);
                model.changeColors();
            }
        }
    }

    @Override
    public int getColor() {
        return model.getTurn() + 4;
    }
}
