/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs;

/**
 * @author ssingh
 *
 */
public class FindCycleUndirected {
	private UnionFind uf;
	private boolean[] visited;

	private class UnionFind {
		private int[] parent;
		private int[] size;
		private int count;


		public UnionFind(int n) {
			setCount(n);
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int find(int x) {
			int root = x;
			while (root != parent[x]) {
				root = parent[x];
			}
			// Path compression			
			while(x != root) {
				int xParent = parent[x];
				parent[x] = root;
				x = xParent;
			}
			return root;
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY) {
				return;
			}
			if (size[rootY] > size[rootX]) {
				parent[x] = rootY;
				size[y] = size[y] + size[x];
			} else {
				parent[y] = rootX;
				size[x] = size[x] + size[y];
			}
			setCount(getCount() - 1);
		}

		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}
	}

	public boolean hasCycleWithUnionFind(Graph G) {
		int vertices = G.getNumberOfVertices();
		this.uf = new UnionFind(vertices);
		for (int v = 0; v < vertices; v++) {
			for (int w : G.getAdj()[v]) {
				// This will ensure that in an undirected graph we do not try to
				// add same edge twice.
				// Edge (0,1) (1,0) are same edge so we will only add (0,1)
				// once.
				if (w > v) {
					if (this.uf.connected(v, w)) {
						System.out.println(v + " : " + w);
						return true;
					}
					this.uf.union(v, w);
				}

			}

		}
		return false;
	}

	public boolean hasCycleWithDFS(Graph G) {
		int vertices = G.getNumberOfVertices();
		visited = new boolean[vertices];
		for (int v = 0; v < vertices; v++) {
			if (hasCycleDFS(G, v, v)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasCycleDFS(Graph G, int v, int parent) {
		if (visited[v]) {
			if (parent != v) {
				System.out.println(v + " : " + parent);
				return true;
			} else {
				return false;
			}
		}
		visited[v] = true;
		for (int w : G.getAdj()[v]) {
			if (w != parent) {
				if (hasCycleDFS(G, w, v)) {
					return true;
				}
			}

		}

		return false;
	}
	
	public static void main(String[] args){
//		Graph G = new Graph(5);
//		G.addEdge(0, 1);
//		G.addEdge(1, 2);
//		G.addEdge(2, 3);
//		G.addEdge(1, 3);
//		G.addEdge(1, 4);
//		
//		
//		FindCycleUndirected findCycle = new FindCycleUndirected();
//		System.out.println(findCycle.hasCycleWithDFS(G));
//		System.out.println(findCycle.hasCycleWithUnionFind(G));
		
		System.out.println(Integer.valueOf("01"));
		int  x= (int) Math.ceil(Math.log(5) / Math.log(2));
		System.out.println(2 * (int) Math.pow(2, x) - 1);
		System.out.println((Math.log(3) / Math.log(2)));
	}

}
