public class Bag <T> {
    protected int packages;
    protected float weight;
    protected DEQ<T> bag;

    public Bag()
    {
        bag = new DEQ<T>();
        packages = 0;
        weight = 0;
    }

    public void pickUpOrder(Sample pack) throws QueueException
    {
        bag.enqueue(pack);
        packages++;
        weight += (pack.getItemWeight() * pack.getItemAmount());

    }

    public void pickUpExpressOrder(Package expPack) {
        bag.enqueueFirst(expPack);
        packages++;
        weight += (expPack.getItemWeight() * expPack.getItemAmount());
    }

    public void displayPackageBag()
    {
        System.out.println("Bag has " + packages + " packages and weighs " + weight + " lbs.");
    }

    public void displaySampleBag(Bag<T> samples)
    {
        System.out.println("Bag has " + samples.packages + " packages and weighs " + samples.weight + " lbs.");
    }



    public Queue<T> getBag()
    {
        return bag;
    }

    public int getPackages()
    {
        return packages;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setPackages(int newPackages)
    {
        packages = newPackages;
    }

    public void setWeight(float newWeight)
    {
        weight = newWeight;
    }

}
