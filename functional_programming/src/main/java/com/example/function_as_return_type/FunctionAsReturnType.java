package com.example.function_as_return_type;

import java.util.function.Function;

public class FunctionAsReturnType {

    ///////////////////////////
//      JS implementation       //
    ///////////////////////////
//    function multiplyBy(x) {
//        return function(y) {
//            return x * y;
//        };
//    }


    ///////////////////////////
//     JAVA implementation      //
    //////////////////////////
    public static void main(String[] args) {
        System.out.println(multiply(5).apply(4));
    }
    static Function<Integer,Integer> multiply(Integer x){
        Function<Integer, Integer> innerFunction= (Integer y)-> x * y;
        return innerFunction;
    }
}
