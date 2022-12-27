package com.ssw.test.string;

/**
 * @author ssw
 * @date 2022/9/30 10:24
 */
public class StringByteArrayExamples {
    public static void main(String[] args) {
        //Original String
        String string = "hello world";

        //Convert to byte[]
        byte[] bytes = string.getBytes();

        //Convert back to String
        String s = new String(bytes);

        //Check converted string against original String
        System.out.println("Decoded String : " + s);
    }
}
