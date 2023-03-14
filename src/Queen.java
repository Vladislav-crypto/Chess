public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!inSide(toLine, toColumn)) return false;
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
            return false;
        }
        if (toLine == line && toColumn > column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '=', '>');
        }
        if (toLine == line && toColumn < column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '=', '<');
        }
        if (toLine > line && toColumn == column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '=');
        }
        if (toLine < line && toColumn == column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<', '=');
        }

        //for diagonal move

        if (toLine > line && toColumn > column && Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '>');
        }
        if (toLine > line && toColumn < column && Math.abs(toLine - line) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '<');
        }
        if (toLine < line && toColumn > column && Math.abs(line - toLine) == Math.abs(toColumn - column)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<', '>');
        }
        if (toLine < line && toColumn < column && Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<', '<');
        }

        return false;
    }
    private boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, char ratioLines, char ratioColumns) {
        int intIndexLine = 0;
        switch (ratioLines) {
            case '>':
                intIndexLine = 1;
                break;
            case '<':
                intIndexLine = -1;
                break;
        }
        int intIndexColumn = 0;
        switch (ratioColumns) {
            case '>':
                intIndexColumn = 1;
                break;
            case '<':
                intIndexColumn = -1;
                break;
        }
        for (int i = 1; i < 8; i++) {
            if (toLine == (line + (i * intIndexLine)) && toColumn == (column + (i * intIndexColumn))) {
                return true;
            } else if (chessBoard.board[line + (i * intIndexLine)][column + (i * intIndexColumn)] != null) {
                return false;
            }
        }
        return false;
    }
        @Override
        public String getSymbol () {
            return "Q";
        }
    }
