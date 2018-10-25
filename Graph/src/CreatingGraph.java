import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class CreatingGraph {
    int totalNode;
    ArrayList<Integer>[] adjList;
    public CreatingGraph(int totalNode){
        this.totalNode = totalNode;
        adjList = new ArrayList[totalNode];
        for(int i = 0; i < totalNode; i++){
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int a, int b){
        adjList[a].add(b);
        adjList[b].add(a);
    }

    public void printGraph(){
        for(int i = 0; i < totalNode; i++){
            System.out.println();
            ArrayList<Integer> list = adjList[i];
            System.out.print("Node = " + i + " -> ");
            for(Integer each: list){
                System.out.print(each + ",");
            }
        }
        System.out.println();
    }

    public void dfs(int start){
        boolean[] visited = new boolean[totalNode];
        System.out.println("####### DFS #######");
        dfsUtil(start,visited);
    }

    public void dfsUtil(int start,boolean[] visited){
        System.out.println(start);
        visited[start] = true;
        ArrayList<Integer> list = adjList[start];
        for(Integer each: list){
            if(!visited[each]) {
                dfsUtil(each, visited);
            }
        }
    }

    public void bfs(int start){
       boolean[] visited = new boolean[totalNode];
       System.out.println("####### BFS #######");
       Queue<Integer> q = new LinkedList<>();
       q.add(start);
       visited[start] = true;
       while (!q.isEmpty()){
           int index = q.poll();
           System.out.println(index);


           ArrayList<Integer> list = adjList[index];
           for(Integer each: list){
               if(!visited[each]){
                   q.add(each);
                   visited[each] = true;
               }
           }

       }
    }

    public boolean isCycleDirected() {
        boolean[] rec = new boolean[totalNode];
        boolean[] visited = new boolean[totalNode];
        return isCycleDirectedUtil(0, rec, visited);
    }

    public boolean isCycleDirectedUtil(int index, boolean[] rec, boolean[] visited){
        if(rec[index] == true){
            return true;
        }

        if(visited[index]){
            return false;
        }

        rec[index] = true;
        visited[index] = true;

        ArrayList<Integer> list = adjList[index];
        for(Integer each:list){
            if(isCycleDirectedUtil(each,rec,visited)){
                return true;
            }
        }

        rec[index] = false;

        return false;
    }

    public boolean isCycleUnDirected() {
        boolean[] visited = new boolean[totalNode];
        return isCycleUnDirectedUtil(0, visited, -1);
    }

    public boolean isCycleUnDirectedUtil(int index, boolean[] visited, int parent){
        visited[index] = true;

        ArrayList<Integer> list = adjList[index];
        for(Integer each:list){
            if(!visited[each]){
                if(isCycleUnDirectedUtil(each,visited,index)){
                    return true;
                }
            }else if(each != parent){
                return true;
            }

        }

        return false;
    }

    private void topologicalSort() {
        System.out.println("########## Topological sort BFS ##########");
        boolean[] visited = new boolean[totalNode];
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){
            int item = q.poll();
            System.out.println(item);

            ArrayList<Integer> list = adjList[item];
            for(Integer each:list){
                if(!visited[each]){
                    q.add(each);
                    visited[each] = true;
                }
            }
        }

        System.out.println("########## Topological sort DFS ##########");
        visited = new boolean[totalNode];
        q.clear();
        topologicalSortDFSUtil(0, visited,q);
        while(!q.isEmpty()){
            System.out.println(q.pop());
        }

    }

    private void topologicalSortDFSUtil(int item, boolean[] visited, Deque<Integer> q) {
        visited[item] = true;
        ArrayList<Integer> list = adjList[item];
        for(Integer each:list){
            if(!visited[each]){
                topologicalSortDFSUtil(each,visited,q);
            }
        }

        q.push(item);
    }

    private boolean isTreeUndirected() {
        boolean[] visited = new boolean[totalNode];
        if(isCycleUnDirectedUtil(0, visited, -1)){
            return false;
        }

        for(int i = 0; i < totalNode; i++){
            if(visited[i] != true){
                return false;
            }
        }

        return true;
    }

    private int totalDisCon() {
        int count=0;
        boolean[] visited = new boolean[totalNode];
        for(int i = 0; i < totalNode; i++){
            if(!visited[i] == true){
                count++;
                totalDisConUtil(i, visited);
            }
        }
        return count;
    }

    private void totalDisConUtil(int item , boolean[] visited) {
        visited[item] = true;
        ArrayList<Integer> list = adjList[item];
        for(Integer each:list){
            if(!visited[each] == true){
                totalDisConUtil(each, visited);
            }
        }
    }

    public static void main(String[] args) {

        int totalNode = 8;
        CreatingGraph graph = new CreatingGraph(totalNode);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,6);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        //graph.addEdge(4,3);
        //graph.addEdge(5,4);
        //graph.addEdge(6,5);
        graph.addEdge(6,7);

//        int totalNode = 5;
//        CreatingGraph graph = new CreatingGraph(totalNode);
//        graph.addEdge(1,0);
//        graph.addEdge(0,2);
//        graph.addEdge(2,1);
//        graph.addEdge(0,3);
//        graph.addEdge(1,4);


        graph.printGraph();

        graph.bfs(0);
        graph.dfs(0);
        //System.out.println(graph.isCycleDirected());
        System.out.println(graph.isCycleUnDirected());


        graph.topologicalSort();

        System.out.println("This graph is tree = " + graph.isTreeUndirected());

//        CreatingGraph g2 = new CreatingGraph(3);
//        g2.addEdge(0, 1);
//        g2.addEdge(1, 2);
//        System.out.println(g2.isCycleUnDirected(0));


        // Connected graph

        totalNode = 8;
        CreatingGraph disConGraph = new CreatingGraph(totalNode);
        disConGraph.addEdge(0,1);
        disConGraph.addEdge(0,2);

        disConGraph.addEdge(3,4);
        disConGraph.addEdge(3,6);

        disConGraph.addEdge(5,7);

        disConGraph.printGraph();

        System.out.println(disConGraph.totalDisCon());



    }
}
