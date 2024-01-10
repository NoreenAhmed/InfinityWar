package avengers;

/**
 * Given a Set of Edges representing Vision's Neural Network, identify all of the 
 * vertices that connect to the Mind Stone. 
 * List the names of these neurons in the output file.
 * 
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * MindStoneNeighborNeuronsInputFile name is passed through the command line as args[0]
 * Read from the MindStoneNeighborNeuronsInputFile with the format:
 *    1. v (int): number of neurons (vertices in the graph)
 *    2. v lines, each with a String referring to a neuron's name (vertex name)
 *    3. e (int): number of synapses (edges in the graph)
 *    4. e lines, each line refers to an edge, each line has 2 (two) Strings: from to
 * 
 * Step 2:
 * MindStoneNeighborNeuronsOutputFile name is passed through the command line as args[1]
 * Identify the vertices that connect to the Mind Stone vertex. 
 * Output these vertices, one per line, to the output file.
 * 
 * Note 1: The Mind Stone vertex has out degree 0 (zero), meaning that there are 
 * no edges leaving the vertex.
 * 
 * Note 2: If a vertex v connects to the Mind Stone vertex m then the graph has
 * an edge v -> m
 * 
 * Note 3: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut:
 *     StdOut.setFile(outputfilename);
 *     //Call StdOut.print() for EVERY neuron (vertex) neighboring the Mind Stone neuron (vertex)
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/MindStoneNeighborNeurons mindstoneneighborneurons.in mindstoneneighborneurons.out
 *
 * @author Yashas Ravi
 * 
 */


public class MindStoneNeighborNeurons {
    
    public static void main (String [] args) {
        
    	if ( args.length < 2 ) {
            StdOut.println("Execute: java MindStoneNeighborNeurons <INput file> <OUTput file>");
            return;
        }
        String MindStoneNeighborNeuronsInputFile = args[0];
        String MindStoneNeighborNeuronsOutputFile = args[1];

        StdIn.setFile(MindStoneNeighborNeuronsInputFile);
       
        int vertices= StdIn.readInt();
        String [] v = new String [vertices];
        for (int i=0; i<vertices; i++) {
            String name = StdIn.readString();
            v[i]=name;
        }

        String MindStone= "";
        int edges = StdIn.readInt();
            String [] froms = new String [edges];
            String [] tos = new String [edges];
      
       StdOut.setFile(MindStoneNeighborNeuronsOutputFile);

        for (int i=0; i<edges; i++) {
            String from = StdIn.readString();
            String to = StdIn.readString();
            froms[i] = from;
            tos[i]= to;
            //StdOut.println(froms[i]);
            //StdOut.print(tos[i]);
         }
        boolean [] marked = new boolean[vertices];

        for (int s=0; s<v.length;s++ ) { //marks all vertexes that are in froms
            for (int t=0; t<froms.length; t++) {
                if (v[s].equals(froms[t])) {
                    marked[s]=true;
                }
            }
        }

        for (int m=0; m<marked.length; m++) { //vertex not in froms is the mindstone
            if (marked[m]==false) {
                MindStone =v[m];
            }
        }

        //StdOut.println("here is the mindstone:" + MindStone);
    
        for (int f=0; f<froms.length; f++) { //prints out all edges connected to Mindstone
            if (tos[f].equals(MindStone)) {
                StdOut.println(froms[f]);
            }
        }
           
                //StdOut.print(v[i]);
                //StdOut.print(froms[j]);
                //if (v[i].equals(froms[j])) {
                   // check =1;
                //} //if (check ==1) { //if the vertex is present in the froms array
                   // S//tring con = tos[j]; //get the vertex it is connected to
                //while (v[i].equals(froms[j])) {

                 //else {
                    //check =0;
                //}
             //}
                //if (check == 0) {
                   
                //} 
            
         	// WRITE YOUR CODE HERE
    }
    
}

