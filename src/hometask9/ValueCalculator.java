package hometask9;

public class ValueCalculator implements Runnable{
        private int arraySize = 99999999;
        private int halfOfArraySize = arraySize / 2;

        private float[] array = new float[arraySize];
        private float[] array1 = new float[halfOfArraySize];
        private float[] array2 = new float[halfOfArraySize];

        private boolean whoUsedFirstArray = false;

        private long startTime;


    public ValueCalculator() {

        initHeadArrayAndInitTwoBranchesArray();
    }

    public void initHeadArrayAndInitTwoBranchesArray()
    {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < arraySize; i++) {
            array[i] = 1;
        }
        System.arraycopy(array,0,array1,0,halfOfArraySize);
        System.arraycopy(array,halfOfArraySize,array2,0,halfOfArraySize);
    }


    @Override
    public void run() {
        if (!whoUsedFirstArray)
        {
            whoUsedFirstArray = true;
            System.out.println(1);
            reinitializationArray(array1);
        }
        else
        {
            reinitializationArray(array2);
        }
    }
    private void reinitializationArray (float[] array){
        for (int i = 0; i < halfOfArraySize; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    public void mergesArrayAndCalculateAndPrintTime(){
        System.arraycopy(array1,0,array,0,halfOfArraySize);
        System.arraycopy(array2,0,array,halfOfArraySize,halfOfArraySize);
        calculateAndPrintTime();
    }
    private void calculateAndPrintTime(){
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
