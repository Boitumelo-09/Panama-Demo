
#include <cstdio>


extern "C" {

    __declspec(dllexport) int square(int x) {
        return x * x;
    }

    __declspec(dllexport) void greet() {
        printf("Hello From C++ \n");
    }
    __declspec(dllexport) void pizzaFromCpp() {
        printf("Am Eating Pzza From C++... \n");
    }
    __declspec(dllexport) void logPro() {
        printf("Getting Logs Using C++... \n");
    }
   
    __declspec(dllexport) void logIn(const char* name) {
        if (name == nullptr) {
            printf("Name is null bro...");
            return;
        }
        printf("You Are Now Logging In As: %s\n", name);
    }
    
}

