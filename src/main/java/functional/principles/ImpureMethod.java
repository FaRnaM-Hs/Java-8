package functional.principles;

public class ImpureMethod {

    int v = 5;

    public int sum(int a, int b) {
        return a + b + v;
    }

    public int impure_2(int a, int b) {
        v++;
        return a + b;
    }
    
    public void print(String s) {
        System.out.println(s);
        // db.save(s);
    }
}
