public class NumberRowSupplier {

    final int[] getArrayFinalMethod(){
        return new int[]{1,2,3};
    }

    private int[] getArrayPrivateMethod(){
        System.out.println("ВЫЗВАН МЕТОД PRIVATE");
        return new int[]{4,5,6};
    }

    public static int[] getArrayStaticMethod(){
        return new int[]{7,8,9};
    }
}
