package game2048logic;

import game2048rendering.Board;
import game2048rendering.Side;
import game2048rendering.Tile;

import java.util.Formatter;


/** The state of a game of 2048.
 *  @author P. N. Hilfinger + Josh Hug
 */
public class Model {
    /** Current contents of the board. */
    private final Board board;
    /** Current score. */
    private int score;

    /* Coordinate System: column x, row y of the board (where x = 0,
     * y = 0 is the lower-left corner of the board) will correspond
     * to board.tile(x, y).  Be careful!
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = 0;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (x, y) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score) {
        board = new Board(rawValues);
        this.score = score;
    }

    /** Return the current Tile at (x, y), where 0 <= x < size(),
     *  0 <= y < size(). Returns null if there is no tile there.
     *  Used for testing. */
    public Tile tile(int x, int y) {
        return board.tile(x, y);
    }

    /** Return the number of squares on one side of the board. */
    public int size() {
        return board.size();
    }

    /** Return the current score. */
    public int score() {
        return score;
    }


    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        board.clear();
    }


    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        return maxTileExists() || !atLeastOneMoveExists();
    }

    /** Returns this Model's board. */
    public Board getBoard() {
        return board;
    }

    /** Returns true if at least one space on the board is empty.
     *  Empty spaces are stored as null.
     * */
    public boolean emptySpaceExists() {
        // TODO: Task 1. Fill in this function.
        int size = board.size();
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                Tile currentTile = board.tile(i, j);
                if (currentTile == null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public boolean maxTileExists() {
        // TODO: Task 2. Fill in this function.
        int size = board.size();
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                Tile currentTile = board.tile(i, j);
                if (currentTile == null){
                    continue;
                }
                else{
                    if (currentTile.value() == MAX_PIECE) return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public boolean atLeastOneMoveExists() {
        // TODO: Task 3. Fill in this function.
        if (emptySpaceExists()){
            return true;
        }
        else if(adjacentTilesSameValue()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adjacentTilesSameValue(){
        int size = board.size();
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                Tile currentTile = board.tile(i, j);

                // left tile
                if ((i-1) >= 0){
                    Tile leftTile = board.tile((i-1), j);
                    if (leftTile.value() == currentTile.value()){
                        return true;
                    }
                }

                // right tile
                if ((i+1) < size){
                    Tile rightTile = board.tile((i+1), j);
                    if (rightTile.value() == currentTile.value()){
                        return true;
                    }
                }

                // top tile
                if ((j+1) < size){
                    Tile topTile = board.tile(i, (j+1));
                    if (topTile.value() == currentTile.value()){
                        return true;
                    }
                }

                // bottom tile
                if ((j-1) > 0){
                    Tile bottomTile = board.tile(i, (j-1));
                    if (bottomTile.value() == currentTile.value()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Moves the tile at position (x, y) as far up as possible.
     *
     * Rules for Tilt:
     * 1. If two Tiles are adjacent in the direction of motion (ignoring empty space)
     *    and have the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     */
    public void moveTileUpAsFarAsPossible(int x, int y) {
        Tile currTile = board.tile(x, y);
        int myValue = currTile.value();
        int targetY = y;

        // TODO: Tasks 5, 6, and 10. Fill in this function.

        /* 方法一：存在小瑕疵
        // task 5 move up as far as possible
        if (currTile != null) {
            // construct inspector
            int inspector = y+1;
            while(inspector < board.size()){
                if (board.tile(x, inspector) != null) break;
                else{
                    inspector++;
                }
            }
            board.move(x, inspector-1, currTile);
            // task 6
            if (inspector < board.size()){
                Tile nextTile = board.tile(x, inspector);
                if((!nextTile.wasMerged()) && (currTile.value() == nextTile.value() ) ){
                    board.move(x, inspector, currTile);
                }
            }
        } */

        //我改的方法二
        // task 5 move up as far as possible
        // 如果原格子已经在顶头位置3， 不进函数，不动它。
        if ( (currTile != null) && (y < (board.size()-1) ) ){
            // construct inspector
            int inspector = y+1;
            while(inspector < board.size()){
                if (board.tile(x, inspector) != null) break;
                else{
                    inspector++;
                }
            }
            // 出来时，检测器如果遇见东西了，就是1-3； 没遇见东西就是4

            // task 6
            if (inspector < board.size()){
                Tile nextTile = board.tile(x, inspector);
                if((!nextTile.wasMerged()) && (currTile.value() == nextTile.value() ) ){
                    board.move(x, inspector, currTile);
                    // task10
                    score += (nextTile.value() * 2);
                }
                else{board.move(x, inspector-1, currTile); //因为忘写这一行代码卡了俩小时，妈的。
                }
            }
            else{
                board.move(x, inspector-1, currTile);
            }
        }

        /*
        // 以下为gpt写的，全对。操 = -为什么呢
        // 如果当前方块不为空且不在最顶部
        if (currTile != null && y < board.size() - 1) {
            int aimY = y;

            // 向上查找最近的非空位置
            for (int i = y + 1; i < board.size(); i++) {
                if (board.tile(x, i) == null) {
                    aimY = i; // 更新目标位置为当前空位置
                } else {
                    // 如果找到的非空位置的方块与当前方块值相等且未被合并
                    if (board.tile(x, i).value() == currTile.value() && !board.tile(x, i).wasMerged()) {
                        aimY = i; // 更新目标位置为当前非空位置
                    }
                    break; // 结束查找
                }
            }

            // 如果目标位置与当前位置不同，进行移动
            if (aimY != y) {
                board.move(x, aimY, currTile);
            }
        }*/


    }

    /** Handles the movements of the tilt in column x of board B
     * by moving every tile in the column as far up as possible.
     * The viewing perspective has already been set,
     * so we are tilting the tiles in this column up.
     * */
    public void tiltColumn(int x) {
        // TODO: Task 7. Fill in this function.
        int y = board.size() - 1;
        while (y >= 0){
            if(board.tile(x, y) != null){
                moveTileUpAsFarAsPossible(x, y);
            }
            y--;
        }
    }

    public void tilt(Side side) {
        // TODO: Tasks 8 and 9. Fill in this function.

        // task9
        board.setViewingPerspective(side);

        // task 8
        for (int x = 0; x < board.size(); x++){
            tiltColumn(x);
        }

        // task9
        board.setViewingPerspective(Side.NORTH);
    }

    /** Tilts every column of the board toward SIDE.
     */
    public void tiltWrapper(Side side) {
        board.resetMerged();
        tilt(side);
    }


    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int y = size() - 1; y >= 0; y -= 1) {
            for (int x = 0; x < size(); x += 1) {
                if (tile(x, y) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(x, y).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (game is %s) %n", score(), over);
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Model m) && this.toString().equals(m.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
