class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }
        
        ArrayList<Integer>[] g = buildAdjacencyList(n, connections);
        
        int count = 0;
        boolean[] vis = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(vis[i] == false) {
                dfs(g, vis, i);
                count++;
            }
        }
        
        return count-1;
    }
    
    private void dfs(ArrayList<Integer>[] g, boolean[] vis, int s) {
        if(vis[s] == true) return;
        
        vis[s] = true;
        
        for(int i=0; i<g[s].size(); i++) {
            int v = g[s].get(i);
            dfs(g, vis, v);
        }
    }
    
    private ArrayList<Integer>[] buildAdjacencyList(int n, int[][] connections) {
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i=0; i<n; i++) { 
            g[i] = new ArrayList<>(); 
        }
        
        for(int i=0; i<connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }
}