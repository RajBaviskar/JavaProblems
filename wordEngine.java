import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class wordEngine {
    class Pair{
        String w;
        int c;
        public Pair(String w, int c){
            this.w = w;
            this.c = c;
        }
    }

    String[][] wordCountEngine(String document) {
        // your code goes here
        String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < words.length; i++){
            String key = words[i];
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }

        List<Pair> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            Pair newPair = new Pair(entry.getKey(), entry.getValue());
            list.add(newPair);
        }

        Comparator<Pair> comp = new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.c - a.c;
            }
        };

        Collections.sort(list, comp);


        String[][] res = new String[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i).w;
            res[i][1] = String.valueOf(list.get(i).c);
        }

        return res;


    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        wordEngine wd = new wordEngine();
        String[][] result= wd.wordCountEngine(document);
        System.out.println(result.length);
        for(int i = 0; i < result.length; i++) {
            System.out.print("word =" + result[i][0] + " and ");
            System.out.println("count  =" + result[i][1]);
            System.out.println("******************************");
        }
    }

}