package learn;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ExceptionHandling {
    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
        
    }

    static byte[] toGBK(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(e);
            return s.getBytes();
        }
    }
}

