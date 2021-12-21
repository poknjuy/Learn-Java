package learn;

public class CoreClass
{
    public static void main(String[] args)
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


    }
}
