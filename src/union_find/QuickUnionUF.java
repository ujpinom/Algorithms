package union_find;
import java.util.Arrays;

public class QuickUnionUF {
	
	private int [] id;
	private int [] tree_size;
	private int [] rastreo;
	
	public QuickUnionUF(int N) {
		
		id=new int[N];
		tree_size=new int [N];
		rastreo=new int [N];
		Arrays.fill(tree_size, 1);
		
		for(int i=0;i<N;i++) {
			id[i]=i;
			rastreo[i]=i;
		}
		
	}
	
	public void setid(int [] a) {
		this.id=a;
	}
	
	public boolean conected(int p,int q) {
		
		
		return (root(p)==root(q));
	}
	
	private int root(int i) {
		
		while(i!=id[i]) {
			i=id[i];
		}
		return i;
	}
	
	public int [] getSize() {
		return id;
	}
	
	public void union(int p, int q) {
		
		int max=p;
		if(q>max) {
			max=q;
		}
			
		int i=root(p);
		int j=root(q);
		
		if(i==j) {
			return;
		}
		
		if(tree_size[j]<tree_size[i]) {
			id[j]=i;
			if(rastreo[i]<max)
				rastreo[i]=max;
			if(rastreo[j]>rastreo[i])
				rastreo[i]=rastreo[j];
			
			tree_size[i]+=tree_size[j];
		}
		else{
			id[i]=j;
			if(rastreo[j]<max)
				rastreo[j]=max;
			if(rastreo[i]>rastreo[j])
				rastreo[j]=rastreo[i];
			
			tree_size[j]+=tree_size[i];
		}
	}
	
	
	public int find(int i) {
		return tree_size[root(i)];
	}
	
	public int max(int i) {
		return rastreo[root(i)];
	}
	
	
	
	public static void main(String args[]) {
		
		QuickUnionUF p;
		
		int[] a= {0,1,0,0,2,3,5,7,8,9,10};
		
		p=new QuickUnionUF(a.length);
		
		p.union(1, 2);p.union(2, 6);p.union(6, 9);p.union(3, 4);p.union(5, 7);p.union(7,10);p.union(1, 7);
		int [] vector=p.getSize();
		for(int i=0;i<vector.length;i++) {
			System.out.println(vector[i]+" "+" size "+p.find(3));
		}
		
		System.out.println(p.max(6));
		
	}

}
