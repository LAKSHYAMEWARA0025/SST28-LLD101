public class Pen{
    public IPenType pen;
    public IMechanismType mechanism;
    public IRefillType refill;
    public String color;
    public  Pen(IPenType pen,IMechanismType mech,IRefillType r,String c){
        this.pen=pen;
        this.mechanism=mech;
        this.refill=r;
        this.color=c;
    }

    public void displayColor(){
        System.out.println("Color of Pen is:- "+this.color);
    }
    public void openPen(){
        mechanism.open();
    }
    public void refillPen(){
        refill.refill();
    }
    public void closePen(){
        mechanism.close();
    }
    public void write(String s){
        pen.write(s);
    }
    
}
