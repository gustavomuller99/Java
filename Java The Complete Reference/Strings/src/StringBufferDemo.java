public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello World");

        System.out.println("sb = " + sb);
        System.out.println("sb.length() = " + sb.length());
        System.out.println("sb.capacity() = " + sb.capacity());

        sb.ensureCapacity(30);
        System.out.println("sb.capacity() = " + sb.capacity());

        System.out.println("char at 0 = " + sb.charAt(0));
        sb.setCharAt(0,'A');
        sb.setLength(2);
        System.out.println("sb = " + sb);
    }
}
