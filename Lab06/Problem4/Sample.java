public class Sample {

    private String itemName;
    private float itemWeight;
    private int itemAmount;
    private String itemSender;
    private String itemReceiver;

    public Sample(String name, float weight, int amount, String sender, String receiver)
    {
        itemName = name;
        itemWeight = weight;
        itemAmount = amount;
        itemSender = sender;
        itemReceiver = receiver;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(float itemWeight) {
        this.itemWeight = itemWeight;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getItemSender() {
        return itemSender;
    }

    public void setItemSender(String itemSender) {
        this.itemSender = itemSender;
    }

    public String getItemReceiver() {
        return itemReceiver;
    }

    public void setItemReceiver(String itemReceiver) {
        this.itemReceiver = itemReceiver;
    }
}
