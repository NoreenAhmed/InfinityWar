package avengers;
//import java.util.NoSuchElementException;

public class Stack {
    private Node first = null; // front of the list
    // nested private class seen ONLY inside this file
    private class Node {
    private int vertex;
    //public Integer edge;
    private Node next;
    
}
public boolean isEmpty() {
return first == null;
}

public void push(int vertex) {
Node oldFirst = first;
first = new Node();
first.vertex = vertex;
//first.edge = e;
first.next = oldFirst;
}

// Running time? O(1)
// Problems? Underflow
public int pop() {
// what happens when the stack is empty?
    if ( isEmpty() ) {
        return -1;
    }
    int vertex = first.vertex;
    first = first.next; // first now points to the second node
    return vertex;
}

public int peek() {
    if (isEmpty()) {
        return -1;
    }
    int vertex=first.vertex;
    return vertex;
}
}

//public int peek() {

    //return last;


//}



//}


// Client
/*public static void main (String[] args) {
LinkedStackOfStrings s = new LinkedStackOfStrings();
s.push("jacket");
s.push("shirt");
s.push("pants");
s.push("socks");
String item = null;
int n = 5;
try {
// code that might throw an exception

while ( n > 0 ) {
item = s.pop();
System.out.println("Popped item: " + item);
n--;
}

}*/

