import java.util.Scanner;

public class Main {
    public static void main(String[] ags){
        String color="";
        String pen="";
        String ref="";
        String mech="";
        Scanner ok=new Scanner(System.in);
        System.out.println("Enter Pen type:- ");
        pen=ok.next();
        System.out.println("Enter Refill type:- ");
        ref=ok.next();
        System.out.println("Enter Mechanism type:- ");
        mech=ok.next();
        System.out.println("Enter Pen Color:- ");
        color=ok.next();
        PenFactory provider=new PenFactory();
        Pen p=new Pen(provider.getPen(pen),provider.getMechanism(mech),provider.getRefill(ref),color);
        System.out.println("Pen Details:- ");
        p.displayColor();
        p.openPen();
        p.write("Expectation kills!");
        p.refillPen();
        p.closePen();
        ok.close();
    }
}
