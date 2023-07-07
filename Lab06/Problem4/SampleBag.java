
public class SampleBag<T> {

    private int packages;
    private float weight;
    private StackSLS<T> bag;

    public SampleBag()
    {
        bag = new StackSLS<T>();
        packages = 0;
        weight = 0;
    }

    public void pickUpOrder(Sample pack) throws QueueException
    {
        bag.push(pack);
        packages++;
        weight += (pack.getItemWeight() * pack.getItemAmount());

    }


    public void displayPackageBag()
    {
        System.out.println("Bag has " + packages + " packages and weighs " + weight + " lbs.");
    }

    public void displaySampleBag(Bag<T> samples)
    {
        System.out.println("Bag has " + samples.packages + " packages and weighs " + samples.weight + " lbs.");
    }



    public StackSLS<T> getBag()
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
