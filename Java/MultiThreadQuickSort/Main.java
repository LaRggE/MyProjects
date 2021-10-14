class QuickSort extends Thread {
    private int arr[];
    private int low;
    private int high;
    private int threads;
    private int num;

    public QuickSort(int arr[], int low, int high, int threads, int num) {
        this.arr = arr;
        this.low = low;
        this.high = high;
        this.threads = threads;
        this.num = num;
    }

    public void run() {
        sort(arr, low, high);
    }

    int doSort(int arr[], int low, int high) {
        //System.out.println(num);
        //Main.printArray(arr);
        int pivot = arr[high];
        //int pivEl = findMid(arr, low, high);
        //System.out.println("piv " + pivEl + " " + arr[pivEl]);
        //int pivot = arr[pivEl];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        //arr[i + 1] = arr[pivEl];
        //arr[pivEl] = temp;
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {

        if (low < high) {
            //Main.printArray(arr, "num " + Integer.toString(num));
            //Main.printArray(arr);
            if(threads >= Main.ThreadCount){
                
                int newPoint = doSort(arr, low, high);
                sort(arr, low, newPoint - 1);
                sort(arr, newPoint + 1, high);
                return;
            }
            
            int newMidPoint = doSort(arr, low, high);
            //Main.printArray(arr);
            //System.out.println("midPoint" + newMidPoint);
            QuickSort qs1 = new QuickSort(arr, low, newMidPoint - 1, threads + 1, threads + 1);
            threads += 1;
            
            qs1.start();
            sort(arr, newMidPoint + 1, high);
            try {
                qs1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private int findMid(int[] arr, int low, int high){
        int temp = arr[low];
        int mid = (high + low + 1) / 2;
        for (int i = low; i < high;i++){
            if(Math.abs(arr[i] - mid) < 2){
                return i;
            }
        } 
        return high;
    }
}
public class Main {

    static int ThreadCount = 2;
    static private int loopTimes = 10;
    static private int size = 10_000_000;
    public static void main(String args[]) throws InterruptedException {
        
        int mode = 0;
        if(args.length != 0){
            mode = Integer.parseInt( args[0] );
        }
        else mode = 1;
        if(mode == 0){
            ThreadCount = Integer.parseInt( args [1] );
        }
        mode = 1;

        if(mode == 1){
            System.out.println("Testing");
            testing();
        }
        else{
            System.out.println("One Time");
            oneTime();
        }
        
    }
    static void oneTime(){
        System.out.println("Thread count: " + ThreadCount);

        long start = 0;
        int arr[] = GenerateArray.generateRandomArray(size, 0, size);
        //printArray(arr);
        start = System.nanoTime();
        QuickSort qs = new QuickSort(arr, 0, size - 1, 1, 1);
        qs.start();
        try {
            qs.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long elapsedTime = System.nanoTime() - start;
        //printArray(arr);
        if(!checkIfCorrect(arr)){
            System.out.println("ERROR, NOT CORRECT");
        }
            System.out.println("Time: " + elapsedTime / 1000000 + "ms");
    }
    static void testing(){
        long start = 0;
        for(int thrCounter = 1; thrCounter < 5; thrCounter++){
            ThreadCount = thrCounter;
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("current thread Count: " + thrCounter);
            
             
            int average = 0;
            for(int i = 0; i < loopTimes; i++){
                
                int arr[] = GenerateArray.generateRandomArray(size, 0, size);
                start = System.nanoTime();
                QuickSort qs = new QuickSort(arr, 0, size - 1, 1, 1);
                qs.start();
                try {
                    qs.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long elapsedTime = System.nanoTime() - start;
                if(!checkIfCorrect(arr)){
                    System.out.println("ERROR");
                    break;
                }
                
                //System.out.println("Time: " + elapsedTime / 1000000 + "ms");
                average += elapsedTime / 1000000;
            }
            System.out.println("size: " + size);
            System.out.println("Average Time: " + average / loopTimes + "ms");
        }
    } 
    static boolean checkIfCorrect(int arr[]){
        int n = arr.length - 1;
        for(int i = 0; i < n; i++){
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    static void printArray(int arr[], String name) {
        System.out.println("start");
        System.out.print(name + " ");
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
} 