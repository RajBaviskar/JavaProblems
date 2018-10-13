import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CreatingGraph {
    int totalNode;
    LinkedList<Integer>[] adjList;

    CreatingGraph(int totalNode){
        this.totalNode = totalNode;
        this.adjList = new LinkedList[totalNode];
        for(int i = 0; i < totalNode; i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to){
        adjList[from].add(to);
        adjList[to].add(from); // comment this line when you want directed graph
    }

    private void printGraph() {
        for(int i = 0; i < totalNode; i++){
            LinkedList<Integer> list = adjList[i];
            System.out.println();
            System.out.print("Node = " + i + "  Connected Nodes are=");
            for(Integer item: list){
                System.out.print(item + ",");
            }
        }
        System.out.println();
    }

    private void bfs(int number) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[totalNode];
        visited[number] = true;

        q.add(number);
        System.out.println("############# BFS ########### ");
        while(!q.isEmpty()){
            int num  = q.poll();
            System.out.println(num + ",  ");
            LinkedList<Integer> list = adjList[num];

            for(Integer eachItem: list) {
                if(!visited[eachItem]){
                    visited[eachItem] = true;
                    q.add(eachItem);
                }
            }
        }
    }

    private void dfs(int number) {
        Deque<Integer> st = new LinkedList<>();
        boolean[] visited = new boolean[totalNode];
        visited[number] = true;

        st.push(number);
        System.out.println("############# DFS ########### ");
        while (!st.isEmpty()) {
            int num = st.pop();
            System.out.println(num + ",  ");
            LinkedList<Integer> list = adjList[num];

            for (Integer eachItem : list) {
                if (!visited[eachItem]) {
                    visited[eachItem] = true;
                    st.push(eachItem);
                }
            }
        }
    }

    private boolean isCycleDirected(int number) {
        boolean[] visited = new boolean[totalNode];
        boolean[] rec = new boolean[totalNode];

        return isCycleUtilDirected(number, visited,rec);
    }

    private boolean isCycleUtilDirected(int number, boolean[] visited, boolean[] rec) {
        if(rec[number]){
            return true;
        }

        if(visited[number]){
            return false;
        }

        LinkedList<Integer> list = adjList[number];
        rec[number] = true;
        visited[number] = true;
        for (Integer eachItem : list) {
            if(isCycleUtilDirected(eachItem, visited,rec)){
                return true;
            }
        }
        rec[number] = false;

        return false;
    }

    private boolean isCycleUnDirected(int number) {
        boolean[] visited = new boolean[totalNode];
        return isCycleUtilUnDirected(number, visited,-1);
    }

    private boolean isCycleUtilUnDirected(int number, boolean[] visited, int parent) {

        visited[number] = true;
        LinkedList<Integer> list = adjList[number];

        for (Integer eachItem : list) {
            if(!visited[eachItem]){
                if(isCycleUtilUnDirected(eachItem, visited,number)){
                    return true;
                }
            }else if(eachItem != parent){
                return true;
            }

        }

        return false;
    }

    private void topologicalSort() {
        boolean[] visited = new boolean[totalNode];
        Deque<Integer> q = new LinkedList<>();
        topologicalSortUtil(0, visited, q);
        System.out.println(" ####### Topology Sort #######");
        while(!q.isEmpty()){
            System.out.println(q.pop());
        }
    }

    private void topologicalSortUtil(int number, boolean[] visited, Deque<Integer> q) {


        visited[number] = true;
        LinkedList<Integer> list = adjList[number];

        for (Integer eachItem : list) {
            if(!visited[eachItem]){
                topologicalSortUtil(eachItem, visited,q);
            }
        }
        q.push(number);
    }

    private boolean isTreeUndirected() {
        // if cycle exists it nor tree
        // if all nodes are not visited its not tree
        boolean[] visited = new boolean[totalNode];
        if(isCycleUtilUnDirected(0,visited,-1)){
            System.out.println("Since Cycle exists");
            return false;
        }

        for(int i = 0; i < totalNode; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    private int totalDisCon() {
        boolean[] visited = new boolean[totalNode];
        int count = 0;
        for(int i = 0 ; i < totalNode; i++){
            if(!visited[i]){
                count++;
                disConUtil(i,visited);
            }

        }

        return count;
    }

    private void disConUtil(int i, boolean[] visited) {
        visited[i] = true;
        LinkedList<Integer> list = adjList[i];
        for(Integer eachItem: list){
            if(!visited[eachItem]){
                disConUtil(eachItem,visited);
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
       // graph.addEdge(3,4);
        graph.addEdge(4,5);
//        graph.addEdge(4,3);
//        graph.addEdge(5,4); // making it cycle
        //graph.addEdge(6,5);
        graph.addEdge(6,7);

//        int totalNode = 5;
//        CreatingGraph graph = new CreatingGraph(totalNode);
//        graph.addEdge(1,0);
//        graph.addEdge(0,2);
//        graph.addEdge(2,1);
//        graph.addEdge(0,3);
//        graph.addEdge(1,4);


        //graph.printGraph();

        //graph.bfs(0);
        //graph.dfs(0);
        //System.out.println(graph.isCycleDirected(0));


        //graph.topologicalSort();

        //System.out.println("This graph is tree = " + graph.isTreeUndirected());

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
