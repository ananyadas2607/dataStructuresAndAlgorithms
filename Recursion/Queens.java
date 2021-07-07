package Pepcoding.Recursion;

public class Queens {

    // tnb : total no of boxes, tnq : total no queens
    public static int queenCombination(int tnb, int tnq, int bno, int qno, String ans){
        if(qno==tnq)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=bno; i<tnb;i++){
            count+=queenCombination(tnb, tnq, i+1, qno+1, ans+ "b" + i +"q"+qno+" ");
        }

        return count;
    }

    public static int queenPermutation(boolean[] boxes,int tnq, int bno, int qno, String ans){
        if(qno==tnq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=bno;i<boxes.length;i++){
            if(!boxes[i]) //Check that the place where we want to place the queen is occupied or not--1D
            {
                boxes[i]=true;
                count+=queenPermutation(boxes,tnq,0,qno+1,ans+ "b" + i +"q"+qno+" ");
                boxes[i]=false;
            }
        }

        return count;

    }

    public static int queenCombination2D(boolean[][] board, int tnq, int bno, String ans){
        if (tnq == 0)
        {
            System.out.println(ans);

            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = bno; i < n * m; i++)
        {
            int r = i / m;
            int c = i % m;
            count += queenCombination2D(board, tnq - 1, i + 1, ans + "(" + r + "," + c + ") ");
        }

        return count;

    }

    public static int queenPermutation2D(boolean[][] board, int tnq, int bno, String ans)
    {
        if (tnq == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = bno; i < n * m; i++)
        {
            int r = i / m;
            int c = i % m;
            if (!board[r][c])////Check that the place where we want to place the queen is occupied or not--2D
            {
                board[r][c] = true;
                count += queenPermutation2D(board, tnq - 1, 0, ans + "(" + r + "," + c + ") ");
                board[r][c] = false;
            }
        }

        return count;
    }

    //==================================================================================================
    public static boolean isSafeToPlaceQueen(boolean[][] board,int row, int col){
        int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1}};
        int n=board.length, m=board[0].length;
        for(int d=0;d<dir.length;d++){
            for(int rad=1; rad<board.length;rad++){
                int r=row+rad*dir[d][0];
                int c=col+rad*dir[d][1];
                if(r>=0 && c>=0 && r<n && c<m){
                    if(board[r][c])
                        return false;
                }
                else
                    break;
            }
        }
        return true;
    }

    public static int nqueen_01_combi(boolean[][] board,int tnq, int idx, String ans){
        if (tnq == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++)
        {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(board, r, c))
            {
                board[r][c] = true;
                count += nqueen_01_combi(board, tnq - 1, i + 1, ans + "(" + r + "," + c + ")");
                board[r][c] = false;
            }
        }

        return count;
    }

    int nqueen_01_combi_sub(boolean[][] board, int tnq, int idx, String ans)
    {
        int count = 0, n = board.length, m = board[0].length;
        if (tnq == 0 || idx == n * m)
        {
            if (tnq == 0)
            {
                System.out.println(ans);
            }
            return tnq == 0 ? 1 : 0;
        }

        int r = idx / m;
        int c = idx % m;
        if (isSafeToPlaceQueen(board, r, c))
        {
            board[r][c] = true;
            count += nqueen_01_combi_sub(board, tnq - 1, idx + 1, ans + "(" + r + "," + c + ") ");
            board[r][c] = false;
        }

        count += nqueen_01_combi_sub(board, tnq, idx + 1, ans);

        return count;
    }

    public static int nqueen_01_permu(boolean[][] board, int tnq, int idx, String ans)
    {
        if (tnq == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++)
        {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(board, r, c) && !board[r][c])
            {
                board[r][c] = true;
                count += nqueen_01_permu(board, tnq - 1, 0, ans + "(" + r + "," + c + ") ");
                board[r][c] = false;
            }
        }

        return count;
    }

    //NQueens using shadow technique
    static boolean[] row;
    static boolean[] col;
    static boolean[] diag;
    static boolean[] aDiag;

    public static int nqueen_02_combi(int n, int m, int tnq, int idx, String ans){
        if(tnq==0)
        {
            System.out.println(ans);
            return 1;
        }

        int count=0;
        for(int i=idx;i<n*m;i++){
            int r=i/m;
            int c=i%m;
            if (!row[r] && !col[c] && !diag[r + c] && !aDiag[r - c + m - 1])
            {
                row[r] = col[c] = diag[r + c] = aDiag[r - c + m - 1] = true;
                count += nqueen_02_combi(n, m, tnq - 1, i + 1, ans + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = aDiag[r - c + m - 1] = false;
            }
        }
    return count;
    }

    public static int nqueen_03_combi(int n, int m, int tnq, int floor, String ans)
    {
        if (tnq == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        // calls++;
        for (int room = 0; room < m; room++)
        {
            int r = floor, c = room;
            if (!row[r] && !col[c] && !diag[r + c] && !aDiag[r - c + m - 1])
            {
                row[r] = col[c] = diag[r + c] = aDiag[r - c + m - 1] = true;
                count += nqueen_03_combi(n, m, tnq - 1, floor + 1, ans + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = aDiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    public static int nqueen_03_permu(int n, int m, int tnq, int r, String ans)
    {
        if (tnq == 0 || r == n)
        {
            if (tnq == 0)
                System.out.println(ans);
            return tnq == 0 ? 1 : 0;
        }

        int count = 0;
        // calls++;

        count += nqueen_03_permu(n, m, tnq, r + 1, ans);

        for (int c = 0; c < m; c++)
        {
            if (!row[r] && !col[c] && !diag[r + c] && !aDiag[r - c + m - 1])
            {
                row[r] = col[c] = diag[r + c] = aDiag[r - c + m - 1] = true;
                count += nqueen_03_permu(n, m, tnq - 1, 0, ans + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = aDiag[r - c + m - 1] = false;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int tnb=4, tnq=3, n=4, m=4;
        boolean[] boxes=new boolean[tnb];
        boolean[][] board=new boolean[4][4];
//        queenCombination(tnb, tnq, 0, 0, "");
//        queenPermutation(boxes, tnq, 0, 0, "");
//        queenCombination2D(board, 4, 0, "");

        row=new boolean[n];
        col=new boolean[m];
        diag=new boolean[n+m-1];
        aDiag=new boolean[n+m-1];

//        queenPermutation2D(board, 4,0,"");
        nqueen_02_combi(n,m,tnq, 0, "");
    }
}
