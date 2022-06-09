class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //build the adjacency list
        ArrayList<Integer> g[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            g[u].add(v);
            g[v].add(u);
        }
        
        boolean[] vis = new boolean[n];
       
        //for different graph component check
        for(int i=0; i<n; i++) {
            bfs(g, source, destination, vis);
        }
        
        return vis[destination];
        
    }
    
    private void bfs(ArrayList<Integer> g[], int s, int d, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        
        while(q.size() > 0) {
            int u = q.poll();
            
            for(int i=0; i<g[u].size(); i++) {
                int v = g[u].get(i);
                
                if(vis[v] == false) {
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
    }
}