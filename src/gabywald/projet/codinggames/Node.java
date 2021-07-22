package gabywald.projet.codinggames;

/*
 * 
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
