package learn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Reflection {
    public static void main(String[] args) throws Exception{
        Class cls1 = String.class;

        String s = "Hello";
        Class cls2 = s.getClass();

        // Class cls3 = Class.forName("java.lang.String");

        boolean sameClass = (cls1 == cls2);

        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

        Class stdClass = ReflectionStudent.class;
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("name"));
        System.out.println(stdClass.getDeclaredField("grade"));

        Field f = String.class.getDeclaredField("value");
        f.getName();
        f.getType();
        int m = f.getModifiers();
        
        ReflectionPerson p = new ReflectionPerson("xiao ming");
        Class c = p.getClass();
        Field f2 = c.getDeclaredField("name");
        Object value = f2.get(p);
        System.out.println(value);
        f2.set(p, "xiao hong");
        System.out.println(p.getName());

        System.out.println(stdClass.getMethod("getScore", String.class));
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
        System.out.println(stdClass.getMethod("getName"));

        String s2 = "Hello world";
        String r = s2.substring(6);
        System.out.println(r);
        Method m2 = String.class.getMethod("substring", int.class);
        String r2 = (String) m2.invoke(s2, 6);
        System.out.println(r2);
        Method m3 = String.class.getMethod("substring", int.class, int.class);
        String r3 = (String) m3.invoke(s2, 6, 11);
        System.out.println(r3);

        Method m4 = Integer.class.getMethod("parseInt", String.class);
        Integer n = (Integer) m4.invoke(null, "12345");
        System.out.println(n);

        Method m5 = ReflectionPerson.class.getMethod("hello");
        m5.invoke(new ReflectionStudent("xiao ming"));

        Constructor cons1 = Integer.class.getConstructor(int.class);
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);
        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("456");
        System.out.println(n2);

        Class i = Integer.class;
        Class n3 = i.getSuperclass();
        System.out.println(n3);
        Class o = n3.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());

        Class s3 = Integer.class.getSuperclass();
        Class[] is = s3.getInterfaces();
        for (Class j : is) {
            System.out.println(j);            
        }

        Integer.class.isAssignableFrom(Number.class);
        Number.class.isAssignableFrom(Integer.class);

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[] {Hello.class}, handler);
        hello.morning("bob");
        


    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitiva: " + cls.isPrimitive());
    }


}

class ReflectionStudent extends ReflectionPerson {
    public int score;
    private int grade;

    public ReflectionStudent(String name) {
        super(name);
    }
    
    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }

    public void hello() {
        System.out.println(this.name + ": hello");;
    }
}

class ReflectionPerson {
    public String name;

    public ReflectionPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void hello() {
        System.out.println(this.name + ": hello");
    }
}

interface Hello {
    void morning(String name);
}
