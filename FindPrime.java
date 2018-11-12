import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
public class FindPrime {
    public static void main(String[] args){
        List<Integer> primDiv = getPrimeDivBruteForce(136);
        for(Integer each: primDiv){
            System.out.println(each);
        }

        System.out.println("lets try eff one");
        List<Integer> primDivEff = getPrimeDivEasyEfficient(136);
        for(Integer each: primDivEff){
            System.out.println(each);
        }
    }

    private static List<Integer> getPrimeDivEasyEfficient(int num) {
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= num; i++){
            boolean same = false;
            while(num%i == 0){
                if(same == false) {
                    res.add(i);
                    same = true;
                }
                num = num/i;
            }
        }
        return res;
    }

    private static List<Integer> getPrimeDivBruteForce(int num) {
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                //check if its prime
                if(isPrime(i)){
                    res.add(i);
                }
            }
        }
        return res;
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
