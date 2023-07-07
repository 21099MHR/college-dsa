
public class Item<KT extends Comparable<? super KT>> extends KeyedItem<KT> {
    private int assocint;
    private boolean assocboolean;

    public Item(String key, int assocint, boolean assocboolean) {
        super((KT) key);
        this.assocint = assocint;
        this.assocboolean = assocboolean;
    }

    public int getAssocint() {
        return assocint;
    }

    public void setAssocint(int setter)
    {
        assocint = setter;
    }

    public boolean getAssocboolean()
    {
        return assocboolean;
    }

    public void setAssocboolean(boolean setter)
    {
        assocboolean = setter;
    }
}
