package grafos;

import edu.princeton.cs.algs4.StdOut;

public class EdgeConnectivity {

    private int bridges;      // number of bridges
    private int cnt;          // counter
    private int[] pre;        // pre[v] = order in which dfs examines v
    private int[] low;        // low[v] = lowest preorder of any vertex connected to v

    public EdgeConnectivity(UndirectedGraph G) {
        low = new int[G.V()];
        pre = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            low[v] = -1;
        for (int v = 0; v < G.V(); v++)
            pre[v] = -1;
        
        for (int v = 0; v < G.V(); v++)
            if (pre[v] == -1)
                dfs(G, v, v);
    }

    public int components() { return bridges + 1; }

    private void dfs(UndirectedGraph G, int u, int v) {
        pre[v] = cnt++;
        low[v] = pre[v];
        for (int w : G.adj(v)) {
            if (pre[w] == -1) {
                dfs(G, v, w);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] == pre[w]) {
                    StdOut.println(v + "-" + w + " is a bridge");
                    bridges++;
                }
            }

            // update low number - ignore reverse of edge leading to v
            else if (w != u)
                low[v] = Math.min(low[v], pre[w]);
        }
    }
	
	
//	private boolean [] marked;
//	
//	private int contador;
//	
//	private boolean conectado;
//	
//	public EdgeConnectivity(UndirectedGraph g) {
//		
//		if(g==null) {
//			throw new IllegalArgumentException("Constructor con argumento nulo no permitido");
//		}
//		
//		marked=new boolean[g.V()];
//		
//		if(conectado(g,0)) {
//			conectado=true;
//		}
//		
//		else
//		
//	}
//	
//	
//	private boolean conectado(UndirectedGraph g, int s) {
//		
//		dfs(g,s);
//		
//		if(contador==g.V()) {
//			return true;
//		}
//		return false;
//
//	}
//	
//	public boolean conectado() {
//		return conectado;
//	}
//	
//	private void dfs(UndirectedGraph g,int v) {
//		
//		marked[v]=true;
//		++contador;
//		
//		for(int w: g.adj(v)) {
//			
//			if(!marked[w]) {
//					dfs(g,w);
//			}
//			
//		}
//
//	}

}
