import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {
    public static class Item{
        Double cost;
        int weight;
        int value;
        public Item(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.cost = new Double(this.value/this.weight);
        }
    }
    public static void main(String[] args){
//        int[] wt = {10, 40, 20, 30};
//        int[] val = {60, 40, 100, 120};

        //{{60, 10}, {100, 20}, {120, 30}}
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        List<Item> ratio = new ArrayList<>();
        for(int i = 0;i < wt.length; i++){
            Item item = new Item(val[i], wt[i]);
            ratio.add(item) ;
        }

        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.cost.compareTo(o2.cost);
            }
        };

        Collections.sort(ratio, comp);
        //Double totalCost= 0.0;
        Double cost = 0.0;
        Double profit = 0.0;
        boolean over = false;
        int i = ratio.size()-1;
        for(; i >=0 ; i--){
            cost += ratio.get(i).weight;
            if(cost > capacity){
                over = true;
                cost -= ratio.get(i).weight;
                break;
            }

            profit += ratio.get(i).value;
        }
        if(over) {
            Double diff = capacity - cost;
            Double fract = diff/ratio.get(i).weight;
            Double diffV = fract*ratio.get(i).value;
            profit += diffV;
        }

        System.out.println(profit);
    }
}
