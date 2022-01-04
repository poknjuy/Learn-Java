package learn;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Logger;

public class ExceptionHandling {
    public static void main(String[] args) {
        // Exception origin = null;
        // byte[] bs = toGBK("中文");
        // System.out.println(Arrays.toString(bs));
        // try {
        //     process1();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally {
        //     System.out.println("END");
        // }
        // try {
        //     Integer.parseInt("abc");
        // } catch (Exception e) {
        //     System.out.println("catched");
        //     throw new RuntimeException(e);
        // } finally {
        //     System.out.println("finally");
        // }
        // try {
        //     System.out.println(Integer.parseInt("abc"));
        // } catch (Exception e) {
        //     origin = e;
        //     throw e;
        // } finally {
        //     Exception e = new IllegalArgumentException();
        //     if (origin != null) {
        //         e.addSuppressed(origin);
        //     }
        // }

        // String s = null;
        // System.out.println(s.toLowerCase());

        double x = 0 - Math.abs(-123.45);
        assert x >= 0 : "x must >= 0";
        System.out.println(x);

        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");

        //Log log = LogFactory.getLog(Main.class);
    }

    static byte[] toGBK(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(e);
            return s.getBytes();
        } finally {
            System.out.println("No exception");
        }

    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process2() {
        throw new NullPointerException();
    }
}

