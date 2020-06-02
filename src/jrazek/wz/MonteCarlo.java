package jrazek.wz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonteCarlo {
    LotVolt lt;
    List<RandomSet> sets = new ArrayList<>();
    RandomSet bestSet;
    MonteCarlo(Main.Domain dm, LotVolt lt, int range){
        this.lt = lt;
        //System.out.println(random(dm));
        for(int i = 0; i < range; i++){
            sets.add(new RandomSet(random(dm), random(dm), random(dm)));
        }
    }
    public void check(){
        double bestFitness = 0;
        for(RandomSet set : sets){
            double fit = fitness(set);
            if(fit == 0){
                //perfect set
                bestSet = set;
                break;
            }
            if(fit > bestFitness){
                bestSet = set;
                bestFitness = fit;
            }
        }
    }
    public RandomSet getBestSet(){
        return bestSet;
    }
    private double fitness(RandomSet rms){
        double realZ = lt.getZ();
        double realW = lt.getW();


        double a = rms.getA();
        double b = rms.getB();
        double c = rms.getC();

        double z = lt.getPrevZ();
        double w = lt.getPrevW();

        double calculatedZ = z + a*z - b*z*w;
        double calculatedW = w + b*z*w - c*w;
        double calc = (  Math.abs(calculatedZ-realZ) + Math.abs(calculatedW-realW)  );
        if(calc == 0)
            return 0;

        return 1/calc;
    }

    public class RandomSet{
        RandomSet(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        double a;
        double b;
        double c;
        double getA(){
            return a;
        }
        double getB(){
            return b;
        }
        double getC(){
            return c;
        }
    }
    double random(Main.Domain dm){
        double start = dm.start; double end = dm.end;
        Random rand = new Random();
        return start + new Random().nextDouble() * (end - start);
    }
}
