package Pepcoding.Recursion;

import java.util.ArrayList;

public class Sudoku {
    public static boolean isSafetoPlaceANum(int r, int c, char[][] board, int num){
        //row
        for(int i=0;i<9;i++){
            if(board[r][i]-'0'==num) //char to integer typecasting
            {
                return false;
            }
        }
        //col
        for(int i=0;i<9;i++){
            if(board[i][c]-'0'==num)
                return false;
        }

        //matrix
        r=(r/3)*3; //starting place of the row of the submatrix which is passed as an argument
        c=(c/3)*3; //starting place of the col of the submatrix which is passed as an argument
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j]-'0'==num)
                    return false;
            }
        }
        return true;
    }

    public boolean solveSudoku(char[][] board, ArrayList<Integer> emptyIndex, int idx){
        if(idx==emptyIndex.size())
            return true;

        int cell=emptyIndex.get(idx); //get the cell from the 1D
        int r=cell/9;
        int c=cell % 9;
        for(int num=1;num<=9;num++){
            if(isSafetoPlaceANum(r,c,board,num)){
                board[r][c]=(char)(num+'0');
                if (solveSudoku(board, emptyIndex, idx + 1))
                    return true;
                board[r][c] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board){
        ArrayList<Integer> emptyIndex=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    emptyIndex.add(i*9 + j); //Conversion of a 2d matrix to a 1D matrix
                }
            }
        }
        solveSudoku(board, emptyIndex, 0);
    }

    //SUDOKU USING BIT OPERATIONS---------------------------------------------------------------------
    static int[] row=new int[9];
    static int[] col=new int[9];
    static int[][] mat=new int[3][3];

    public static boolean solveSudoku_bits(char[][] board, ArrayList<Integer> emptyIndex, int idx){
        if (idx == emptyIndex.size()) {
            return true;
        }
        int oneDEncodedValue = emptyIndex.get(idx); // emptyIndex[idx];
        int r = oneDEncodedValue / 9;
        int c = oneDEncodedValue % 9;

        for (int num = 1; num <= 9; num++) {
            int mask = 1 << num;
            if ((row[r] & mask) == 0 && (col[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0) {
                row[r] ^= mask;         //set the row to true
                col[c] ^= mask;         //set col to true
                mat[r / 3][c / 3] ^= mask;//set submatrix to true

                board[r][c] = (char) (num + '0');
                if (solveSudoku_bits(board, emptyIndex, idx + 1))
                    return true;
                board[r][c] = '.';

                row[r] ^= mask;     //set the row to false
                col[c] ^= mask;     //set the col to false
                mat[r / 3][c / 3] ^= mask;//set the submatrix to false

            }
        }
        return false;
    }

    public static void solveSudoku_bits(char[][] board) {
        ArrayList<Integer> emptyIndex = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    emptyIndex.add(i * 9 + j); // emptyIndex.push_back(i * 9 + j);
                else {
                    int mask = 1 << (board[i][j] - '0');
                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                }
            }
        }

        solveSudoku_bits(board, emptyIndex, 0);
    }

    public static void main(String[] args) {
        char[][] board= {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
            solveSudoku_bits(board);
        }
    }




