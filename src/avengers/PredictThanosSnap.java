package avengers;
//import java.util.*;
/**
 * Given an adjacency matrix, use a random() function to remove half of the nodes. 
 * Then, write into the output file a boolean (true or false) indicating if 
 * the graph is still connected.
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * PredictThanosSnapInputFile name is passed through the command line as args[0]
 * Read from PredictThanosSnapInputFile with the format:
 *    1. seed (long): a seed for the random number generator
 *    2. p (int): number of people (vertices in the graph)
 *    2. p lines, each with p edges: 1 means there is a direct edge between two vertices, 0 no edge
 * 
 * Note: the last p lines of the PredictThanosSnapInputFile is an ajacency matrix for
 * an undirected graph. 
 * 
 * The matrix below has two edges 0-1, 0-2 (each edge appear twice in the matrix, 0-1, 1-0, 0-2, 2-0).
 * 
 * 0 1 1 0
 * 1 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 
 * Step 2:
 * Delete random vertices from the graph. You can use the following pseudocode.
 * StdRandom.setSeed(seed);
 * for (all vertices, go from vertex 0 to the final vertex) { 
 *     if (StdRandom.uniform() <= 0.5) { 
 *          delete vertex;
 *     }
 * }
 * Answer the following question: is the graph (after deleting random vertices) connected?
 * Output true (connected graph), false (unconnected graph) to the output file.
 * 
 * Note 1: a connected graph is a graph where there is a path between EVERY vertex on the graph.
 * 
 * Note 2: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, isConnected is true if the graph is connected,
 *   false otherwise):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(isConnected);
 * 
 * @author Yashas Ravi
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/PredictThanosSnap predictthanossnap.in predictthanossnap.out
*/

public class PredictThanosSnap {
	 
    public static void main (String[] args) {
 
        if ( args.length < 2 ) {
            StdOut.println("Execute: java PredictThanosSnap <INput file> <OUTput file>");
            return;
        }
        // read file names from command line
        String predictthanossnapInputFile = args[0];
        String predictthanossnapOutputFile = args[1];

	    // Set the input file.
        StdIn.setFile(predictthanossnapInputFile);
        long seed = StdIn.readInt();
        int v = StdIn.readInt();

        int [][] adj = new int [v][v]; //initialize adj array
        for (int i=0; i<v; i++) {
            for (int j=0; j<v; j++) {
                adj[i][j] = StdIn.readInt();
               // StdOut.print(adj[i][j]);
            }
        }
        StdOut.setFile(predictthanossnapOutputFile);
        StdRandom.setSeed(seed);

        int [] remaining = new int [v]; //array of remaining vertices
        //int deleted=0;
        
        for (int k=0; k<v; k++) {
            if (StdRandom.uniform() <= 0.5) {
                //StdOut.println("this vertex is getting deleted" + k);
                remaining[k]=1; //all deleted vertexes have 1, all remaining vertexes have zero
                //deleted++;
                for (int m=0; m<v; m++) { 
                    //StdOut.println("here is m" + m);
                adj[k][m]=0;//deletes vertex from adj matrix, makes all edges 0
                adj[m][k]=0;
               }
            }
        } //makes updated adjacency matrix

        //for (int i = 0; i < adj.length; i++) { //this equals to the row in our matrix.
            //for (int j = 0; j < adj[i].length; j++) { //this equals to the column in each row.
              // StdOut.print(adj[i][j] + " ");
            //}
            //StdOut.println();
        //}

        //StdOut.println("HERE ARE REMAINING VERTEXES:") ;
        
          //for (int r=0; r<v; r++) {
            //StdOut.println("r=" + r + " val=" + remaining[r]);
        //} //prints remaining vertices array
        
       //DFS dfs = new DFS();
       int peopleleft=0;
       for (int q=0; q<remaining.length; q++) {
        if (remaining[q] !=1) {
            peopleleft++;
        }
       }
       //StdOut.println("people left:"+ peopleleft);
       //boolean [] visited = new boolean [v];
       boolean CONNECTED = false;
       Stack s = new Stack();
       //int [] parent = new int[v];
        //for (int i=0; i<v; i++) {
           // parent[i]=-1;
        //}
        
        
        int current=0;
        while (current<v) {
         if (remaining[current] !=1 ) {
            if(s.peek()!=current) {
               s.push(current); //pushed current into stack
                }
               remaining[current] =2;
               int connection =0;
               int newconnection =0;
               for (int w=0; w<v; w++) { //neightbors of current
                if (adj[current][w]!=0) {
                    if (remaining[w]==2) {
                    //s.push(w);
                    //StdOut.println("here is w:" + w);
                    //visited[w]=true;
                        connection ++;
                    } else {
                        connection ++;
                        newconnection ++;
                        current = w;
                        w=v;
                    }
                }
            }
               if ((newconnection ==0) && (connection ==0)) {
                CONNECTED =false;
                s.pop();
                current =v;
               } else if (newconnection ==0) {
                    s.pop();
                    current=s.peek();
                    if (current ==-1) {
                        current =v;
                    }
                } 
            } else if (remaining[current]==1) {
                current ++;
            } 
        }
       int numVisited=0;
       for (int b=0; b<v; b++) {
        if (remaining[b]==2) {
            numVisited++;
        }
       }
       //StdOut.println("here is numVisited" + numVisited);
       //StdOut.println("here is peopleleft" + peopleleft);
       //StdOut.println("here is deleted" + deleted);
       if (numVisited == peopleleft) {
            CONNECTED=true;
       }
        
       StdOut.println(CONNECTED);

    
    }
    

}
