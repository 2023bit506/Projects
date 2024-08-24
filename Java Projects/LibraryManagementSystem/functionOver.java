public class functionOver {
    public static void main(String[] args) {
        functionOver f1 = new functionOver();
        f1.Add(10);
        System.out.println(f1.Add(10,20));
    }
    public void Add(int a)
    {
        System.out.println(a);
    }
    public int Add(int a, int b)
    {
        return a+b;
    }
}
