package appstart.mymodappdemo;

import java.util.ServiceLoader;

import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;
import userfuncs.binaryfuncs.*;

public class MyModAppDemo {
    public static void main(String[] args) {

        if (SupportFuncs.isFactor(2, 10)) {
            System.out.println("2 is a factor of 10");
        }

        System.out.println("LCD between 35 and 105 is " + SimpleMathFuncs.lcf(35, 105));

        System.out.println("GCD between 35 and 105 is " + SimpleMathFuncs.gcf(35, 105));

        ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);

        BinaryFunc binOp = null;

        for (BinFuncProvider bfp : ldr) {
            if (bfp.get().getName().equals("absPlus")) {
                binOp = bfp.get();
                break;
            }
        }

        if (binOp != null) {
            System.out.println("Result absPlus: " + binOp.func(12, -4));
        } else {
            System.out.println("Null");
        }

        binOp = null;

        for (BinFuncProvider bfp : ldr) {
            if (bfp.get().getName().equals("absPlus")) {
                binOp = bfp.get();
                break;
            }
        }

        if (binOp != null) {
            System.out.println("Result absMinus: " + binOp.func(12, -4));
        } else {
            System.out.println("Null");
        }
    }
}