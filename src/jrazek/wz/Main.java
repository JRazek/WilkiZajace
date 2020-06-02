package jrazek.wz;

public class Main {
    public static void main(String[] args){
        LotVolt lt = new LotVolt(100, 30);
        int range = 10000000;
        MonteCarlo mc = new MonteCarlo(new Domain(-0.5, 0.5), lt, range);
        for(int i = 0; i < 5; i++){
            lt.next();
            mc.check();
        }

        MonteCarlo.RandomSet finalSet = mc.getBestSet();
        System.out.println("a - " + finalSet.getA());
        System.out.println("b - " + finalSet.getB());
        System.out.println("c - " + finalSet.getC());

        System.out.println("Z - " + lt.getZ());
        System.out.println("W - " + lt.getW());
    }
    public static class Domain{
        double start;
        double end;
        Domain(double start, double end){
            this.start = start;
            this.end = end;
        }
    }
}
