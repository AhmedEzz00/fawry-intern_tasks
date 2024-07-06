import java.util.ArrayList;
import java.util.List;

public class Example {

    private static volatile Example instance;
    private Example(){}

    public static Example instatiate(){
        if (instance== null){
            synchronized (Example.class){
                if (instance== null){
                    instance= new Example();
                }
            }
        }
        return instance;

    }
}
