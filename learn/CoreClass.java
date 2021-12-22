package learn;

import java.util.StringJoiner;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.Integer;

public class CoreClass
{
    public static void main(String[] args) throws Exception
    {
        String s1 = "hello!";
        String s2 = new String(new char[] {'h', 'e', 'l', 'l', 'o', '!'});
        String s3 = s1.toUpperCase();
        System.out.println(s1.equals(s2) + " " + s1.equals(s3) + " " + s1.equalsIgnoreCase(s3));
        System.out.println(s1.contains("ll"));
        s1.indexOf("ll");
        s1.lastIndexOf("l");
        s1.startsWith("h");
        s1.endsWith("o");
        s1.substring(2, 4);
        s1.substring(3);
        s1.trim();
        s1.strip();
        s1.isEmpty();
        s1.isBlank();
        s1.replace('l', 'w');
        String s4 = "A,B,C,D";
        String[] ss = s4.split("\\e");
        for (String s : ss) 
        {
            System.out.println(s);   
        }
        String s5 = String.join("  ", s1, s4);
        System.out.println(s5);
        String s6 = "%s, your score is %d!";
        System.out.println(s6.formatted("sx", 100));
        System.out.println(String.format("%s, you are too excellent!", "sx"));
        String.valueOf("123");
        int n1 = Integer.parseInt("123");
        int n2 = Integer.parseInt("ff", 16);
        System.out.println(n1 + " "+ n2);
        boolean b1 = Boolean.parseBoolean("true");
        System.out.println(b1);
        // int n3 = Integer.getInteger("java.version");
        // System.out.println(n3);
        char[] cs = s1.toCharArray();
        String sc = new String(cs);
        System.out.println(sc);

        StringBuilder sb = new StringBuilder(1024);
        sb.append("hello ").append("world");
        System.out.println(sb.toString());
        Adder adder = new Adder();
        adder.add(1).add(2).inc().value();
        System.out.println(adder.value());

        String[] names = {"shi", "xu"};
        StringJoiner sj =new StringJoiner(", ","hello ", "!");
        for (String name : names)
        {
            sj.add(name);
        }
        System.out.println(sj.toString());
        String s7 = String.join(", ", names);
        System.out.println(s7);

        Integer n3 = 100;
        int x = n3;
        Integer n4 = 100;
        System.out.println(n3.equals(n4));
        byte b = -1;
        System.out.println(Byte.toUnsignedInt(b));

        BeanInfo info = Introspector.getBeanInfo(Persons.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println(" " + pd.getReadMethod());
            System.out.println(" "+ pd.getWriteMethod());
        }

        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("I am free!");
        }
        else {
            System.out.println("work!");
        }
        String s8 = Weekday.SUN.name();
        int n5 = Weekday.MON.ordinal();



    }
}

class Adder
{
    private int sum = 0;

    public Adder add(int n)
    {
        sum += n;
        return this;
    }
    public Adder inc()
    {
        sum ++;
        return this;
    }
    public int value()
    {
        return sum;
    }

}

class Persons
{
    private String name;
    private int age;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age) 
    {
        this.age = age;
    }
    
}

enum Weekday {
    SUN(0, "星期日"), MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }
    public String tosString() {
        return this.chinese;
    }
}

