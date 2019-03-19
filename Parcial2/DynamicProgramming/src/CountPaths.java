/*
    Juan Antonio Melendres Villa A00369017
    Martín Giovanni Esquivel A01633334
 */

public class CountPaths {
    //0 es camino libre y 1 es obstaculo
    public int  countPaths(int[][] m) {
        int[][] temp = new int[m.length][m[0].length];
        //maximo de "x" y "y"
        int y = m.length - 1;
        int x = m[0].length - 1;
        //le asginamos un 1 a la salida en el temp
        temp[y][x] = 1;		
        for(int j = y; j >= 0; j--) {
            for(int i = x; i >= 0; i--) {
                //si no es el inicio y ademas esta hasta abajo=> sumale el de la izquierda
                if(!(i == x && j == y) && j == y && m[j][i] != 1) {
                    temp[j][i]=temp[j][i+1];
                    //Si no es el inicio y ademas esti en la esquina derecha => sumale solo lo de abajo
                }
                else if(!(i == x && j == y) && i == x && m[j][i] != 1) {
                    temp[j][i]=temp[j+1][i];
                    //Si es normal =>sumale la derecha + abajo
                }
                else if(!(i == x && j == y) && m[j][i] != 1) {
                    temp[j][i]=temp[j+1][i]+temp[j][i+1];
                }
            }
        }
        return temp[0][0];
    }
    
    public static void result(CountPaths res, int [][] m) {
        System.out.println(res.countPaths(m));
    }
    
}
