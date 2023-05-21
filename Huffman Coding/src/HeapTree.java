public class HeapTree <T extends Comparable<T>>{


    public void buildMinHeap(T[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null) break;
            int parent = (i - 1)/2;
            int curr = i;

            while(curr > 0){
                if (arr[parent].compareTo(arr[curr]) > 0){
                    T temp = arr[parent];
                    arr[parent] = arr[curr];
                    arr[curr] = temp;
                    curr = parent;
                    parent = (parent - 1)/2;
                }
                else break;
            }
        }
    }

    public T delete(T[] arr){
        int rear = 0;

        T value = arr[rear];

        while(arr.length > rear && arr[rear] != null) rear++;
        rear--;

        if(rear == -1) return null;
        arr[0] = arr[rear];
        arr[rear] = null;

        ReHeap(arr);

        return value;
    }

    public void ReHeap(T[] arr){

        int curr = 0;
        int Lchild = 1;
        int Rchild = 2;

        while(curr*2 + 1 < arr.length && arr[Lchild] != null){
            if(arr[Rchild] == null){
                if(arr[curr].compareTo(arr[Lchild]) > 0){
                    T temp = arr[curr];
                    arr[curr] = arr[Lchild];
                    arr[Lchild] = temp;
                    curr = Lchild;
                    Lchild = curr*2 + 1;
                    Rchild = curr*2 + 2;
                }
                else break;
            }
            else if(arr[curr].compareTo(arr[Lchild]) > 0 || arr[curr].compareTo(arr[Rchild]) > 0){
                if(arr[Lchild].compareTo(arr[Rchild]) < 0){
                    T temp = arr[curr];
                    arr[curr] = arr[Lchild];
                    arr[Lchild] = temp;
                    curr = Lchild;
                }
                else{
                    T temp = arr[curr];
                    arr[curr] = arr[Rchild];
                    arr[Rchild] = temp;
                    curr = Rchild;
                }

                Lchild = curr*2 + 1;
                Rchild = curr*2 + 2;
            }
            else break;

        }
    }

    public void insert(T[] arr, T data){
        int rear = 0;

        while(rear < arr.length && arr[rear] != null){
            rear++;
        }

        arr[rear] = data;

        int parent = (rear - 1) / 2;

        while(arr[rear].compareTo(arr[parent]) < 0){
            T temp = arr[parent];
            arr[parent] = arr[rear];
            arr[rear] = temp;

            rear = parent;
            parent = (rear - 1) / 2;

        }
    }

    public static void main(String[] args) {
        HeapTree<Integer> ht = new HeapTree<>();
        Integer [] arr = new Integer[10];



        ht.buildMinHeap(arr);
        ht.insert(arr, 5);
        ht.insert(arr, 2);
        ht.insert(arr, 3);
        ht.insert(arr, 1);


        for(Integer i : arr) System.out.println(i);
        System.out.println("***************************");

        ht.delete(arr);
        ht.delete(arr);
        ht.delete(arr);
        ht.delete(arr);
        System.out.println("***************");
        for(Integer i : arr) System.out.println(i);
    }
}