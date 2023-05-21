import java.lang.reflect.Array;

public class ArrayUtility {

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void shiftRight(int[] A, int i, int j){
        for(; j > i; j--){
            A[j] = A[j - 1];
        }

    }

    public static void printArray(int[] array){
        String str = "";
        for(int i : array){
            str += i + ", ";
        }
        System.out.println(str);
    }

    public static void MaxsortSwap(int[] array){
        for(int placeIndex = 0; placeIndex < array.length; placeIndex++){
            int max = Integer.MIN_VALUE;
            int pickindex = - 1;
            for(int pickIndexfinder = placeIndex; pickIndexfinder < array.length; pickIndexfinder++){
                if(max < array[pickIndexfinder]) {
                    max = array[pickIndexfinder];
                    pickindex = pickIndexfinder;
                }
            }
            //System.out.println(pickindex + "    " + placeIndex);
            //printArray(array);
            swap(array, pickindex, placeIndex );
        }
        //printArray(array);
    }
    public static void MaxsortShift(int[] array){
        for(int placeIndex = 0; placeIndex < array.length; placeIndex++){
            int max = Integer.MIN_VALUE;
            int pickindex = - 1;
            for(int pickIndexfinder = placeIndex; pickIndexfinder < array.length; pickIndexfinder++){
                if(max < array[pickIndexfinder]) {
                    max = array[pickIndexfinder];
                    pickindex = pickIndexfinder;
                }
            }
           // System.out.println(pickindex + "    " + placeIndex);
           //printArray(array);
            shiftRight(array, placeIndex, pickindex);
            array[placeIndex] = max;
        }
       // printArray(array);
    }
}

class AlgoComparision{
   private int[] array;

   public AlgoComparision(int size){
       array = new int[size];
       fillArray();
       //ArrayUtility.printArray(array);
   }

   private void fillArray(){
       for(int i = 0; i < array.length; i++){
           array[i] = (int)Math.round(Math.random() * 1000);
       }
       //System.out.print("Original Array = " );
       //ArrayUtility.printArray(array);
   }

   public void testAlgos(){
    testShiftSort();
    testSwapSort();
   }

   private void testShiftSort(){
       int[] array =this.array.clone();
       long startTime = System.nanoTime();
            ArrayUtility.MaxsortShift(array);
       long estimatedTime = System.nanoTime()-startTime;
       System.out.println("Time for Shift Sort for " + array.length + " numbers : " + estimatedTime);
   }

   private void testSwapSort(){
       int[] array =this.array.clone();
       long startTime = System.nanoTime();
            ArrayUtility.MaxsortSwap(array);
       long estimatedTime = System.nanoTime()-startTime;
       System.out.println("Time for Swap Sort for " + array.length + " numbers  : " + estimatedTime);
   }


}

class ArrayUtilitymain{
    public static void main(String[] args) {
        /*int[] array = {0,1,2,3,4,5,6,7,8,9};
        //ArrayUtility.shiftRight(array, 2,5);
        //ArrayUtility.swap(array, 0,8);
        ArrayUtility.printArray(array);
        //ArrayUtility.MaxsortSwap(array);
        ArrayUtility.MaxsortShift(array);
        ArrayUtility.printArray(array);*/
        for(int j = 0; j < 10; j++){
            System.out.println("**************** Test " + j + " ****************");
        for(int i = 10; i < 100001; i *= 10){
        AlgoComparision ac = new AlgoComparision(i);
        ac.testAlgos();
        }
        }
    }
}
