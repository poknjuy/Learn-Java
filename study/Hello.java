package study;

public class Hello
{
    private String name;

    public void hello()
    {
        System.out.println("hello ");
    }
    public void hello(String name)
    {
        System.out.println("hello"+" "+name);
    }
    public void asyncHello()
    {
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Hello , " + Hello.this.name);
            }
        };
        new Thread(r).start();
    }

    public class World
    {
        public void world()
        {
            System.out.println("world");
        }
    }
}