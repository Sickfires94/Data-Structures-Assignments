

public class Dynamic2dArray {
    int[][] array;
    int currColInd;
    int currRowInd;

    Dynamic2dArray(int rows, int cols){
        array = new int[rows][cols];
        currColInd = cols - 1;
        currRowInd = rows - 1;

        for(int col = 0; col < cols; col++){
            for(int row = 0; row < rows; row++){
                array[row][col] = (int)(Math.random() * 10);
            }
        }
    }

    public void appendRow(int[] rowArray){
        currRowInd++;
        if(rowArray.length > currColInd + 1) {
            System.out.println("Wrong row size");
            return;
        }
        System.out.println(currRowInd + "   " + (array.length - 1));
        if(currRowInd >= array.length){
            this.IncreaseArray(array.length * 2, array[0].length);
        }

        for(int col = 0; col < rowArray.length; col++){
            array[currRowInd][col] = rowArray[col];
        }

    }

    public void appendCol(int[] colArray){
        currColInd++;
        if(colArray.length > currRowInd + 1) {
            System.out.println("Wrong col size");
            return;
        }
        if(currColInd >= array[0].length){
            this.IncreaseArray(array.length, array[0].length * 2);
        }
        for(int row = 0; row < colArray.length; row++){
            array[row][currColInd] = colArray[row];
            System.out.println(row);
        }

    }

    public void IncreaseArray(int rows, int cols){
        int[][] newArray = new int[rows][cols];

        for(int row = 0; row < array.length; row++){
            for(int col = 0; col < array[row].length; col++){
                newArray[row][col] = array[row][col];
            }
        }
        array = newArray;
    }

    public void print2d(){
        String str = "";
        for(int row = 0; row < array.length; row++){
            for(int col = 0; col < array[row].length; col++){
                str += array[row][col] + ", ";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}

class MainDynamic2dArray{
    public static void main(String[] args) {
        Dynamic2dArray array = new Dynamic2dArray(2,2);
        int[] col = {3,6};
        int[] row = {4,2,9};

        array.appendCol(col);
        array.appendCol(col);
        array.appendCol(col);
        array.appendCol(col);
        array.appendRow(row);
        array.appendRow(row);
        array.appendRow(row);
        array.appendRow(row);

        array.print2d();


    }
}
