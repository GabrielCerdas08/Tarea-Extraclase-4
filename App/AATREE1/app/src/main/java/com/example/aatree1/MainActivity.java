package com.example.aatree1;

        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;


// Java program to delete a node from
// Doubly Linked List

public class MainActivity extends AppCompatActivity {

    EditText e1;
    int n2;
    int ans;
    boolean tree;
    TextView integerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Node head; // head of list

    /* Doubly Linked list Node*/
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized
        // as null
        Node(int d) { data = d; }
    }

    // Adding a node at the front of the list
    public int insert(int new_data)
    {
        // 1. allocate node
        // 2. put in the data
        Node new_Node = new Node(new_data);

        // 3. Make next of new node as head
        // and previous as NULL
        new_Node.next = head;
        new_Node.prev = null;

        // 4. change prev of head node to new node
        if (head != null)
            head.prev = new_Node;

        // 5. move the head to point to the new node
        head = new_Node;
        return new_data;
    }

    // This function prints contents of linked list
    // starting from the given node

    public void printlist(Node node)
    {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    // Function to delete a node in a Doubly Linked List.
    // head_ref --> pointer to head node pointer.
    // del --> data of node to be deleted.
    void deleteNode(Node del)
    {

        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v){
        MainActivity dll = new MainActivity();
        EditText e1 = (EditText) findViewById(R.id.num1);
        TextView integerTextView = (TextView) findViewById(R.id.result);
        List<Integer> integerData = new ArrayList<Integer>();
        n2 = Integer.parseInt(e1.getText().toString());

        if (v.getId() == R.id.buttonInsert) {
            ans = n2;
            tree =  integerData.add(ans);
            for(int i=0; i < integerData.size(); i++){
                integerTextView.setText(integerTextView.getText() + " " + integerData.get(i) + " , ");
            }
        }
        if (v.getId() == R.id.buttonClear){
            integerTextView.setText("  ");

        }
    }
}
