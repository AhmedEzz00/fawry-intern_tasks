package com.example.assign_function_to_variable;

import org.w3c.dom.ls.LSOutput;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AssignFunctionToVariable {

    ///////////////////////////
//      JS implementation       //
    ///////////////////////////

//    const add = (a, b) => a + b;
//    console.log(add(3, 4));


    ///////////////////////////
//     JAVA implementation      //
    //////////////////////////

public static void main(String[] args) {
    BiFunction<Integer,Integer,Integer> add=
            Integer::sum;
    //or
    // (a,b)-> a+b;
    System.out.println(add.apply(5,6));
    }
}
