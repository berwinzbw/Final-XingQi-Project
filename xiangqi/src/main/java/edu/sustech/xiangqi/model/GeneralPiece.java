package edu.sustech.xiangqi.model;

/**
 * 帅/将
 */
public class GeneralPiece extends AbstractPiece {

    public GeneralPiece(String name, int row, int col, boolean isRed) {
        super(name, row, col, isRed);
    }

    @Override
    public boolean canMoveTo(int targetRow, int targetCol, ChessBoardModel model) {
        // TODO: 实现将/帅的移动规则
        int currentRow = getRow();
        int currentCol = getCol();

        if (currentRow == targetRow && currentCol == targetCol) {
            //System.out.println("General cannot move to the same location");
            return false;
        }

        if(isRed()){
            if(targetCol < 3 || targetCol > 5 || targetRow > 1){
                //System.out.println("Red general cannot move out of the palace");
                return false;
            }
            int distance = 0;
            distance += Math.abs(targetRow - getRow());
            distance += Math.abs(targetCol - getCol());
            if (distance != 1){
                //System.out.println("Invalid move for the Red General");
                return false;
            }
        }
        else{
            if(targetCol < 3 || targetCol > 5 || targetRow < 7){
                //System.out.println("Black general cannot move out of the palace");
                return false;
            }
            int distance = 0;
            distance += Math.abs(targetRow - getRow());
            distance += Math.abs(targetCol - getCol());
            if (distance != 1){
                //System.out.println("Invalid move for the black general");
                return false;
            }
        }
        return true;
    }
}
