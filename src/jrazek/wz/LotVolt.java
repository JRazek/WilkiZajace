package jrazek.wz;

public class LotVolt {
    private double a = 0.02;
    private double b = 0.0005;
    private double c = 0.05;

    double startZ;
    double startW;

    double prevZ;
    double prevW;

    double z;
    double w;
    public LotVolt(double z, double w){
        this.z = z;
        this.w = w;
        this.startZ = z;
        this.startW = w;
    }

    public void next(){
        prevZ = z;
        prevW = w;
        z = z + a*z - b*z*w;
        w = w + b*prevZ*w - c*w;
    }
    void reset(){
        z = startZ;
        w = startW;
    }
    double getPrevZ(){
        return prevZ;
    }
    double getPrevW(){
        return prevW;
    }
    double getZ(){
        return z;
    }
    double getW(){
        return w;
    }
    void editParams(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
   /* double getA(){
        return a;
    }
    double getB(){
        return b;
    }
    double getC(){
        return c;
    }*/
}
