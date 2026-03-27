import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import static java.lang.IO.println;

public class Main {
    public static void main(String[] args) throws Throwable {

        // LOAD DLL (IMPORTANT)
        System.load("C:\\Users\\hp\\Desktop\\panama-demo\\build\\calc.dll");

        Linker linker = Linker.nativeLinker();
        SymbolLookup lib = SymbolLookup.loaderLookup();


        MethodHandle square = linker.downcallHandle(
                lib.find("square").get(),
                FunctionDescriptor.of(ValueLayout.JAVA_INT,
                        ValueLayout.JAVA_INT)
        );

        int result = (int) square.invoke(10);
        println("Square: " + result);


        MethodHandle greet = linker.downcallHandle(
                lib.find("greet").get(),
                FunctionDescriptor.ofVoid()
        );
        greet.invoke();

        MethodHandle pizza = linker.downcallHandle(
                lib.find("pizzaFromCpp").get(),
                FunctionDescriptor.ofVoid()
        );
        pizza.invoke();

        MethodHandle log = linker.downcallHandle(
                lib.find("logPro").get(),
                FunctionDescriptor.ofVoid()
        );
        log.invoke();



    }
}