public class MissingNum {
    public static void main(String[] args){
        int[] arrOne = {3,5,8,-1,-2};
        int[] arrTwo = {3,5,8,-1,-2,8};
        int result = findMissing(arrOne, arrTwo);
        System.out.println(result);
    }

    private static int findMissing(int[] arrOne, int[] arrTwo) {
        int sum = 0;
        int i = 0;
        int j = 0;

        if(arrOne.length < arrTwo.length){
            return findMissing(arrTwo, arrOne);
        }
        while(i < arrOne.length && j <arrTwo.length) {
            if (sum >= 0) {
                sum += arrOne[i];
                i++;
            } else {
                sum -= arrTwo[j];
                j++;
            }
        }

        while(i < arrOne.length){
            sum += arrOne[i];
            i++;
        }

        while (j < arrTwo.length){
            sum -= arrTwo[j];
            j++;
        }

        return sum;

    }
}
