package gabywald.projet.codinggames;

/*
 * Question  is : "
 * A tree is composed of nodes which follow these rules : 
 * <ul>
 * <li>A node holds a value corresponding to an integer. </li>
 * <li>Except for the root node of the tree, a node is always referenced by only one other node. </li>
 * <li>A node has no more than two children. They are called left child and right child. </li>
 * <li>If a node has no right or left child, the corresponding reference is <i>null</i>. </li>
 * <li>All the descendants to the left of a node are smaller than the node and all the descendant to the right of the node are greater than the node. </li>
 * </ul>
 * Here is an example of such a tree (the root node holds the integer 9) : 
 * 					9
 * 				  /	   \
 * 				7		13
 * 			  /   \		   \
 * 			5		8		17
 * 		   /  \			   /
 * 		2		6		 16
 * 
 *  - To simplifu things, we combine evrything into a single class named <i>Node</i>. 
 *  - The height of the tree is between 0 and 100 000 nodes (the height of a tree is the length of the path from the root to the deepest node in the tree). 
 * 
 * Question : Implement a new Node's method name <i>find(int v)</i> which returns the node holding the value of <i>v</i>. If the node doesn't exist then <i>find</i> should return <i>null</i>.
 * 
 * Important note : Try to save memory (RAM) space. 
 * 
 * To test your solution you can use two examples of tree : 
 *  - The variable <i>small</i> corresponds to the root node os the tree given above. 
 *  - The variable <i>large</i> corresponds to the root node of a tree of height 100 000 nodes. The deepest node holds 0.  
 * @author Gabriel Chandesris (2021)
 */
public class Node {

    // keep these​​​​​​‌​​‌​​‌‌​‌‌‌​​​​‌​‌​‌‌​​​ fields
    Node left, right;
	int value;

	// test to find 8 and 0 (with a small tree and a big tree)
    public Node find(int value2find) {
        Node current  = this;
        while(current != null) {
            if (current.value == value2find) {
                return current;
            }
            if (value2find > current.value) {
                current = current.right;
            } else if (value2find < current.value) {
                current = current.left;
            }
        }
        return current;
    }
	
}
