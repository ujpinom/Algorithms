package union_find;

public class Uf {
	
	private int ID[];
	
	public Uf(int N) {
		
		int [] id= new int [N];
		this.ID=id;
		
		for(int i=0;i<N;i++) {
			ID[i]=i;
		}
		
	}
	
	
	public boolean isPandQconected(int p,int q) {
		
		if(ID[p]==ID[q]) {
			return true;
		}
		else return false;
		
		
	}
	
	public void union(int p,int q) {
		
		/*Une los dos elementos especificados*/
		
		int pid=ID[p];int qid=ID[q];
		
		for (int i=0;i<ID.length;i++) {
			
			if(ID[i]==pid) {
				ID[i]=qid;
			}
		}
		
		
	}
	
	
	

}
