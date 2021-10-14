class GenerateArray{
    static int[] generateRandomArray(int size, int min, int max){
        int arr[] = new int[size];
        int range = max - min + 1;

        for(int i = 0; i < size; i++){
            int temp = (int)(Math.random() * range) + min;
            arr[i] = temp;
        }

        return arr;
    }
    static int[] generateArray(int size){
        int arr[] = new int[size];

        int j = size;

        for(int i = 0; i < size; i++){
            j = j - 1; 
            arr[i] = j;
        }

        return arr;
    }
}