package avengers;

public class Dijkstra { 

    public int getMinCostNode(int [] a, boolean[] m) {

        int min = Integer.MAX_VALUE;
        int vertex =0;

        //boolean [] marker = new boolean [m.length];
        
        //int count = 0;
        for (int i=0; i<a.length; i++) {
            /*if (a[i] != 0 || a[i] !=Integer.MAX_VALUE) { //there is a number in the array that isnt zero or infinity
                count =1;
            } 
        } 

        if (count ==1) { //now we do hard part to find minimum not repeated
            for (int i=0; i<a.length; i++) {
                if(LocateTitan.locatetitan(marked[i])) != true) {

                }
            }
            
        }
        if (count ==0) {
            min = a[0]; //prints out 0
        }*/
        //or (int i=0; i<a.length; i++) {
            //if (a[i]==0) {
                //count ++;
                //min = a[i];

            //}
            //if (count ==1 && a) {

            //}
            if (m[i]!=true) {
            
                if (a[i]<= min) {
                    vertex = i;
                    //min = i;
                    min = a[i];
                    //m[i]=true;//
                }
                
                    //System.out.println(i);
                   // System.out.println(marker[i]);
                    //System.out.println("here is min:" + min);
                    //System.out.println("here is vertex:" + vertex);
                }
            }
            

        
        
        //return vertex;
        return vertex;
    }
}
