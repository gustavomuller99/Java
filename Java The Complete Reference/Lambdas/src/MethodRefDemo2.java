interface StringFuncM {
    String func(String s);
}

class MyStringOps {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo2 {

    static String stringOp(StringFuncM sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String in = "test";
        String out;

        MyStringOps mso = new MyStringOps();

        out = stringOp(mso::strReverse, in);
        System.out.println(out);
    }
}
