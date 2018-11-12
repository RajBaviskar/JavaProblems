import java.util.ArrayList;
import java.util.List;
// https://stackoverflow.com/questions/2991950/one-way-flight-trip-problem
public class WDTopologicalSort {
    int size = 0;
    List<List<Integer>> list;
    public WDTopologicalSort(int size){
        this.size = size;
        list = new ArrayList<>();
        for(int i = 0; i < size;i++){
            List<Integer> l = new ArrayList<>();
            list.add(l);
        }
    }

    public void buildGraph(int start, int end){
        int index = start%size;
        //list.get(index).add(start);
        list.get(index).add(end);
    }


    public void printGraph(){
        for(int i = 0; i < size; i++){
            List<Integer> l = list.get(i);
            for(Integer each: l){
                System.out.print(each);
            }
            System.out.println();
        }
    }

    public void tp(int node, List<Integer>order){
        boolean[] vis = new boolean[size];
        tpUtil(vis, node, order);
    }

    public void tpUtil(boolean[] vis, int node, List<Integer> order) {
        order.add(node);
        vis[node%size] = true;
        int index = node%size;
        List<Integer> l = list.get(index);
        for(Integer each:l){
            if(!vis[each%size]){
                tpUtil(vis, each, order);
            }
        }
    }

    public static void main(String[] args){
        int[][] travel = {{6,7}, {3,4}, {5,6}, {4,5}, {7,8}};
        List<List<Integer>> result = new ArrayList<>();
        WDTopologicalSort g = new WDTopologicalSort(travel.length);

        for(int i = 0; i < travel.length; i++){
            g.buildGraph( travel[i][0],  travel[i][1]);
        }


       g.printGraph();

        List<Integer> order = new ArrayList<>();
        g.tp(3, order);

        for(Integer each : order){
            System.out.println( " -> " + each);
        }

        // with 2 Maps
//        Map<Integer, Integer> SD = new HashMap<>();
//        for(int i = 0; i < travel.length; i++){
//            SD.put(travel[i][0], travel[i][1]);
//        }
//
//        Map<Integer, Integer> DS = new HashMap<>();
//        for(int i = 0; i < travel.length; i++){
//            DS.put(travel[i][1], travel[i][0]);
//        }
//
//        int source = travel[0][0];
//        while(DS.containsKey(source)){
//            source = DS.get(source);
//        }
//
//        System.out.println("Source is = " + source);
//        int dest = SD.get(source);
//        List<Integer> l = new ArrayList<>();
//        l.add(source);
//        l.add(dest);
//        result.add(l);
//        while(SD.containsKey(dest)){
//            l = new ArrayList<>();
//            l.add(dest);
//            l.add(SD.get(dest));
//            result.add(l);
//            dest = SD.get(dest);
//        }

//        for(List<Integer> each : result){
//            System.out.print( "S: " + each.get(0));
//            System.out.println( " E: " + each.get(1));
//        }
    }
}
