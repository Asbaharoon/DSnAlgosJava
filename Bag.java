/* Algorithm 1.4 Bag (Allows you to just add items no deletion allowed)
*/

public class Bag<Item>
{
    private Node first; // first node in list

    private class Node
    {
        Item item;
        Node next;
    }

    public void add(Item item)
    {
        // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
}
