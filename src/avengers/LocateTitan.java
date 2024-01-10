package avengers;



/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }
        String LocateTitanInputFile = args[0];
        String LocateTitanOutputFile = args[1];

        StdIn.setFile(LocateTitanInputFile);

        int n= StdIn.readInt();
        double [] a = new double [n];
        for (int i=0; i<n; i++) {
                int gennum= StdIn.readInt();
                a[gennum] = StdIn.readDouble(); //makes an array of all the functionalities
                //System.out.println(gennum);
        //System.out.println(a);
                //a[n] = func;
        }
        
        StdOut.setFile(LocateTitanOutputFile);
        
    
       // int energy =0;
        int [][] adj = new int [n][n]; //initialize adj array
        int [] parent = new int [n];

        for (int p=0; p<parent.length; p++) {
            parent[p] = -1;
        }
     
        
        //StdOut.print(g);
        for (int v=0; v<n; v++) {
            //djList.add(new ArrayList<Integer>());
            for (int w=0; w<n; w++) {
                int energy = StdIn.readInt();
                adj[v][w]=energy; //creates an adj matrix of all the energies
               //System.out.println(adj[i][j]);
                if (energy !=0) {
                    //System.out.print(a[v]);
                    //System.out.print(a[w]);
                    //System.out.println(adj[v][w]);
                    double function = a[v] * a[w];
                    double totalcost = energy / function;
                    adj[v][w]= (int)(totalcost);
                    //System.out.println(adj[v][w]);
                    //StdOut.println(adj[v][w]);
                    //parent[w] = v;
                    
                    //StdOut.println(v + "->" + w);
                    //adjList.add
                }
                //System.out.println(adj[v][w]);
                //StdOut.println("--------");
                //StdOut.println(adj[v][w]);
              }
                //StdOut.println(w + "->" + parent[w]);
                
            }
            //for (int i = 0; i < adj.length; i++) { //this equals to the row in our matrix.
                //for (int j = 0; j < adj[i].length; j++) { //this equals to the column in each row.
                   //StdOut.print(adj[i][j] + " ");
               // }
                //StdOut.println();
            //}
        
       
                
            
       // g.printAdjList();
      
    	// WRITE YOUR CODE HERE
       
        

        int [] minCost = new int [n];
        boolean [] marked = new boolean [n];
        
        minCost[0]=0;
        for (int m=0; m<minCost.length; m++) {
            if (m==0) {
                minCost[m]=0;
            }
            else {
                minCost[m]= Integer.MAX_VALUE;
            }
            //StdOut.println(minCost[i]);   
        }
        
        
        //adjList =Graph.Graph(n, froms, tos);
        //int currentSource = 0;
        Dijkstra d = new Dijkstra();
         for (int i=0; i<n-1; i++) {

            int currentSource = d.getMinCostNode(minCost, marked);

            marked[currentSource] = true; //update the vertex that has been visited
            //StdOut.println(currentSource + "this is current source");
            for (int w=0; w<n; w++) { //neighbors of currentSource)
                //StdOut.println("this is i: " + i);
                //StdOut.println("this is w: " + w);
                //StdOut.println( "matrix value" + adj[i][w]);
                //it was adj[i][w]!=0 before
                if (adj[currentSource][w]!= 0 && marked[w] != true && minCost[currentSource] != Integer.MAX_VALUE &&
                    minCost[w]>(minCost[currentSource] +  adj[currentSource][w])) {
                        //StdOut.println("entered loop");
                        //StdOut.println("here is w:" + w);
                        //StdOut.println(adj[currentSource][w] + "is edge weight");
                        //StdOut.println(minCost[currentSource] + "old minCost[currentSource]");
                        //StdOut.println(minCost[w] + "minCost[w]");
                        minCost[w]=minCost[currentSource] + adj[currentSource][w];
                        //for (int k=0; k<minCost.length; k++) {
                            //StdOut.println(minCost[k]);
                        //}
                        //StdOut.println(minCost[w] + "is new minCost[w]");
                        parent[w]= currentSource;
                        //System.out.println(parent[w]);
                        
                    
                        }
                }

            }
            //StdOut.println("here is final minCost: ");
            for (int k=0; k<minCost.length; k++) {
                //StdOut.println(minCost[k]);
            }
        

        

        //with now final parent and value array
        StdOut.println(minCost[n-1]);

    }
    
    
    
}
    





      

    

