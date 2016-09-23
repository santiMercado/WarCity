package Modulos;

public class Mapa {
   
protected GameObject[][] matriz;

public Mapa(int n, int m){
	
	matriz= new GameObject[n][m];
}

public GameObject get(int x, int y){
	return matriz[x][y];
}

public void set(int x,int y,GameObject g){
   matriz[x][y]=g;
}


	
}
