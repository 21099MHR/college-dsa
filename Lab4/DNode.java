
public class DNode extends Node {

    private DNode back;

    public DNode(Object newItem) {
        super(newItem);
        super.setNext(this);
        back = this;
    }

    public DNode(Object item, DNode nextNode, DNode backNode)
    {
        super(item, nextNode);
        this.setBack(backNode);
    }

    public DNode getBack()
    {
        return back;
    }

    public void setBack(DNode backNode) {
        back = backNode;
    }

    public DNode getNext()
    {
        return (DNode) super.getNext();
    }

    public void setNext(DNode nextNode)
    {
        super.setNext(nextNode);
    }

}
