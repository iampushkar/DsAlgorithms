class Solution {
    //union find algo implementation - directly
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        
        int n = edges.length;
        
        int[] comp = new int[n+1];
        for(int i=1; i<=n; i++) {
            comp[i] = i;
        }
        
        for(int i=0; i<n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            int Pu = component(u, comp);
            int Pv = component(v, comp);
            
            if(Pu != Pv) {
                //Both belong to different component
                int high = Math.max(Pu, Pv);
                int low = Math.min(Pu, Pv);
                comp[high] = low; //assign lower to higher component 
            } else {
                //cycle is found
                ans[0] = u;
                ans[1] = v;
            }
        }
        
        return ans;
    }
    
    private int component(int n, int[] comp) {
        if(comp[n] == n) return n;
        
        comp[n] = component(comp[n], comp);
        return comp[n];    
    }
}