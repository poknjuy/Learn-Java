package learn;

import java.util.Arrays;
import java.util.Scanner;
import study.Hello;


public class Main
{
    public static void main(String[] args)
    {
        long l = 9l;
        long l1= l<<1;
        int l2= (int) l;
        float f = 3.14e38f;
        char zh = '中';
        String s = "\\hello\\ \"world\"";
        String t = "!";
        String r = s+t+zh+l;
        String duohang= """
                        1
                        2
                        3""";
        System.out.println(duohang);
        final double PI = 3.14;
        double x = PI>=0 ? PI : -PI;
        var sb = new StringBuilder();
        System.out.println("hello world");
        System.out.println(l+" "+l1+" "+f+" "+zh+" "+s+" "+PI);
        //System.out.println(sb);

        int[] ns = new int[]{4,4,3,2};
        ns[0] = 1;
        System.out.println(ns.length);
        System.out.printf("%.2f\n", f);

        try (var scanner = new Scanner(System.in)) 
        {
            System.out.println("input name:");
            //String name = scanner.nextLine();
            System.out.println("input age:");
            //int age = scanner.nextInt();
            //System.out.println(name+" "+age);
        }

        String option = "1";
        switch(option)
        {
            case"1" -> System.out.println("111");
            case"2" -> System.out.println("222");
            default -> System.out.println("No");
        }
        for(int n : ns)
        {
            System.out.println(n);
        }

        System.out.println(Arrays.toString(ns));
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));

        int[][] num = {{1,2,3,4},{5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(num));
        
        City bj = new City();
        bj.setName("beijing");
        bj.latitude = 39.903;
        bj.longitude = 116.401;
        System.out.println(bj.getName()+" "+bj.latitude+" "+bj.longitude);

        Person ming = new Person();
        ming.setName("ming");
        ming.setBirth(2008);
        System.out.println(ming.getAge());

        Group g = new Group();
        g.setNames("ming", "hong", "jun");

        Person p = new Person("xiao ming", 2000);
        System.out.println(p.getName()+" "+p.getAge());

        Hello h = new Hello();
        h.hello();
        h.hello("sx");
        Hello.World w = h.new World();
        w.world();
        h.asyncHello();
        
        Student stu = new Student("xiao ming", 12, 89);
        Person p2 = stu;
        System.out.println(stu instanceof Person);
        System.out.println(p instanceof Student);
        p2.run();

        Income[] incomes = new Income[]{new Income(3000), new Salary(7500), new StateCouncilSpecialAllowance(15000)};
        System.out.println(totalTax(incomes));


    }
    public static double totalTax(Income...incomes)
    {
        double total = 0;
        for(Income income : incomes)
        {
            total +=income.getTax();
        }
        return total;
    }
}

class City
{
    private String name;
    public double latitude;
    public double longitude;

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

}

class Person
{
    protected String name;
    protected int birth;
    protected int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Person()
    {
        this("unamed", 0);
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setBirth(int birth)
    {
        this.birth = birth;
    }
    public int getAge()
    {
        return calcAge(2021);
    }
    private int calcAge(int currentYear)
    {
        return currentYear - this.birth;
    }
    public void run()
    {
        System.out.println("person run");
    }
    @Override
    public String toString()
    {
        return "Person:name=" + name;
    }



}

class Group
{
    private String[] names;
    public void setNames(String...names)
    {
        this.names = names;
    }
}

class Student extends Person
{
    private int score;

    public Student(String name, int age, int score)
    {
        super(name, age);
        this.score = score;
    }
    public int getScore()
    {
        return this.score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    @Override
    public void run()
    {
        System.out.println("student run");
    }
    
}

class Income
{
    protected double income;

    public Income(double income)
    {
        this.income = income;
    }
    public double getTax()
    {
        return income * 0.1;
    }

}

class Salary extends Income
{
    public Salary(double income)
    {
        super(income);
    }
    @Override
    public double getTax()
    {
        if(income <= 5000)
        {
            return 0;
        }
        else
        {
            return (income - 5000) * 0.2;
        }

    }
}

class StateCouncilSpecialAllowance extends Income
{
    public StateCouncilSpecialAllowance(double income)
    {
        super(income);
    }
    @Override
    public double getTax()
    {
        return 0;
    }
}

abstract class abstr
{
    abstract public void hi();
}

interface inter
{
    String getName();
    default void run()
    {
        System.out.println(getName() + "run");
    }

}

class interfa implements inter
{
    private String name;

    public interfa(String name)
    {
        this.name = name;
    }
    @Override
    public void run()
    {
        System.out.println(this.name + "run");
    }
    @Override
    public String getName()
    {
        return this.name;
    }
    
}

interface inter2 extends inter
{
    void hello();
}


