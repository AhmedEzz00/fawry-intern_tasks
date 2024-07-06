package com.example.function_as_argument;

import java.util.function.Consumer;

public class FunctionAsArgument {

    ///////////////////////////
//      JS implementation       //
    ///////////////////////////

//    function register(name, callback) {
//        callback(name + '@domain.com');
//    }
//    function sendWelcomeMail(mail) {
//        console.log('MAILING ' + mail);
//    }
//    register('hany', sendWelcomeMail)


    ///////////////////////////
//     JAVA implementation      //
    //////////////////////////
    public static void main(String[] args) {
        Consumer<String> welcomeMail= (mail)-> System.out.println("Mailing "+mail);
        register("Ahmed",welcomeMail);
    }
    static void register(String name, Consumer<String> consumer){
        consumer.accept(name+"@domain.com");
    }


}
