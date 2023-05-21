public class sudokuSolver {
    int[][] puzzle;

    public sudokuSolver(String puzzle){ //constructor to read and parse string into a 2d Array
        this.puzzle = new int[9][9];

        String[] str = puzzle.split("\n");
        for(int row = 0; row < str.length; row++){
            String[] tempstr = str[row].split(" ");
            for(int col = 0; col < 8; col++){
                this.puzzle[row][col] = Integer.parseInt(tempstr[col]);
            }
        }

    }

    public void solve(){  // Method to solve the puzzle
        ;
        for(int i = 0; i < puzzle.length - 1; i++){
            equateRow(puzzle[i]);
            equateCols(i);
        }
        equateRow(puzzle[puzzle.length - 1]);

        printArray();

    }

     // Helper Functions
     private void equateRow(int[] row){
        int total = 45;
        for(int i : row) total -= i;

        row[row.length - 1] = total;
     }


    private void equateCols(int col){
        int total = 45;
        for(int[] i : puzzle) total -= i[col];

        puzzle[puzzle.length - 1][col] = total;
    }

    //Method to print Array

    public void printArray(){
        for(int[] row : this.puzzle){
            for(int val : row){
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }
}

class SudokuMain{
    public static void main(String[] args) {
/*
        int[][] puzzle = {  {5, 3, 4, 6, 7, 8, 9, 1, 0},
                            {6, 7, 2, 1, 9, 5, 3, 4, 0},
                            {1, 9, 8, 3, 4, 2, 5, 6, 0},
                            {8, 5, 9, 7, 6, 1, 4, 2, 0},
                            {4, 2, 6, 8, 5, 3, 7, 9, 0},
                            {7, 1, 3, 9, 2, 4, 8, 5, 0},
                            {9, 6, 1, 5, 3, 7, 2, 8, 0},
                            {2, 8, 7, 4, 1, 9, 6, 3, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0}};
*/
        sudokuSolver ss = new sudokuSolver("7 1 4 5 6 3 2 9\n" +
                "9 2 6 7 8 1 5 4\n" +
                "3 8 5 2 9 4 6 7\n" +
                "1 4 9 8 7 2 3 5\n" +
                "2 3 8 6 4 5 9 1\n" +
                "5 6 7 1 3 9 4 8\n" +
                "4 9 2 3 1 7 8 6\n" +
                "8 7 3 9 5 6 1 2");

        ss.printArray();
        System.out.println("*************************************");
        ss.solve();

    }


}