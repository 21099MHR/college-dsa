/*
 * Purpose: Data Structure and Algorithms Lab 11 Problem 3
 * Status: Incomplete
 * Last update: 09/10/19
 * Submitted:  09/11/19
 * Comment: Not enough time to figure out why the method calls aren't working.
 * @author: Matthew Ryan
 * @version: 2019.09.06
 */

import io.github.pixee.security.BoundedLineReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));


    public static <T> void main(String[] args) throws NumberFormatException, IOException {

        System.out.println
        ("\t0. Exit program"
         + "\n\t1. Insert key in BST"
         + "\n\t2. Delete key from BST"
         + "\n\t3. Search for key in BST"
         + "\n\t4. Display size of BST"
         + "\n\t5. Display height of BST"
         + "\n\t6. Display content of BST in preorder"
         + "\n\t7. Display content of BST in postorder"
         + "\n\t8. Display content of BST in inorder"
         + "\n\t9. Build copy of the tree, and test it");

        boolean switchOn = true;
        int selection = -1;

        MyBinarySearchTreePlus<?, ?> tree = new MyBinarySearchTreePlus();

        while(switchOn == true)
        {
            System.out.print("\nMake your selection now: ");
            selection = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000));

            switch(selection) {
            case 0:
                System.out.println("Exiting program... Good bye");
                switchOn = false;
                break;
            case 1:
                T toAdd = (T) new Item(BoundedLineReader.readLine(stdin, 5_000_000), selection, switchOn);
                tree.insert(toAdd);
                break;

            case 2:
                String searchKey = BoundedLineReader.readLine(stdin, 5_000_000);
                tree.delete(searchKey);
                break;

            case 3:
                String searchKey = BoundedLineReader.readLine(stdin, 5_000_000);
                tree.retrieve(searchKey);
                break;

            case 4:
                System.out.println("Size of tree: " + tree.getSize());
                break;

            case 5:
                System.out.println("Height of tree: " + tree.getHeight());
                break;

            case 6:

                System.out.println("BST in preorder: " + tree.toStringPreorder());
                break;

            case 7:
                System.out.println("BST in postorder: " + tree.toStringPostorder());
                break;

            case 8:
                System.out.println("BST in inorder : " + tree.toStringInorder());

            case 9:
                tree.getCopyOfTree();
            }
        }

    }

}
