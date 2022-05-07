package java8practice;

public class printImpl {


    public static void main(String[] args) {
        Iprintable<String> iprint = a->a.isBlank();
        System.out.println(iprint.print123(" "));


    }
    


    
}
