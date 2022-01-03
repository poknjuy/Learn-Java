package learn;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.Integer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CoreClass {
    public static void main(String[] args) throws Exception {
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
        for (String s : ss) {
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
        for (String name : names) {
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
        String s8 = day.name();
        int n5 = day.ordinal();
        String s9 = day.tosString();
        System.out.println(s8 + " " + n5 + " " + s9);
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
            case SAT: {
                System.out.println("Today is " + day.name() + "!");
                break;
            }
            case SUN: {
                System.out.println("Today is " + day.name() + "!");
                break;
            }
        }
        
        Point p1 = new Point(123, 456);
        System.out.println(p1.x() + " " + p1.y() + " " + p1);
        Point p2 = Point.of();
        Point P3 = Point.of(123, 456);

        BigInteger bi1 = new BigInteger("1234567890");
        System.out.println(bi1.pow(5));
        BigInteger bi2 = new BigInteger("1234567890");
        BigInteger bi3 = new BigInteger("12345678901234567890");
        BigInteger bi4 = bi2.add(bi3);
        System.out.println(bi2.longValue() + " " + bi4.floatValue());
        //System.out.println(bi2.multiply(bi3).longValueExact());
        BigInteger bi5 = new BigInteger("999999").pow(99);
        System.out.println(bi5.floatValue());
        
        BigDecimal bd1 = new BigDecimal("123.456700");
        BigDecimal bd2 = bd1.stripTrailingZeros();
        System.out.println(bd1.scale());
        System.out.println(bd2.scale());
        BigDecimal bd3 = new BigDecimal("1234500");
        BigDecimal bd4 = bd3.stripTrailingZeros();
        System.out.println(bd3.scale());
        System.out.println(bd4.scale());
        BigDecimal bd5 = new BigDecimal("123.456789");
        System.out.println(bd5.setScale(4, RoundingMode.HALF_UP));
        System.out.println(bd5.setScale(4, RoundingMode.DOWN));
        System.out.println(bd3.divide(bd5, 10, RoundingMode.HALF_UP));
        BigDecimal [] dr = bd3.divideAndRemainder(bd5);
        System.out.println(dr[0] + " " + dr[1]);
        if (dr[1].signum() == 0) {
            System.out.println("整除");
        }
        else {
            System.out.println("非整除");
        }
        BigDecimal bd6 = new BigDecimal("123.4567");
        System.out.println(bd6.equals(bd1));
        System.out.println(bd6.compareTo(bd1));

        Math.abs(-100);
        Math.abs(-7.8);
        Math.max(100, 99);
        Math.min(1.2, 2.3);
        Math.pow(2, 10);
        Math.sqrt(2);
        Math.exp(2);
        Math.log(4);
        Math.log10(100);
        Math.sin(3.14);
        Math.asin(1.0);
        Math.atan2(1, -1);
        double pi = Math.PI;
        double e = Math.E;
        Math.sin(Math.PI / 6);
        Math.random();
        double x1 = Math.random();
        double min = 10;
        double max = 50;
        double x2 = x1 * (max - min) + min;
        long n = (long) x2;
        System.out.println(x2);
        System.out.println(n);
        Random r = new Random(1);
        for (int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(100) + " ");
        }
        System.out.println();
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));
        sr = null;
        try {
            sr = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException exception) {
            sr = new SecureRandom();
        }
        byte [] buffer = new byte[16];
        sr.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));


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

record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
    public static Point of() {
        return new Point(0, 0);
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }

}


