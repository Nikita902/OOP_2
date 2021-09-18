package com.example.oop_2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
     Double Weight;
     Double Height;
     Double Age;
     Map<Sex, Double[]> bmr;
     Map <Activ, Double> amr;

    public Calculator()
    {
        BMR();
        AMR();
    }

    public void BMR() {
        bmr = new HashMap<Sex, Double[]>();
        bmr.put(Sex.Female, new Double[]{655.0955, 9.5634, 1.8496, 4.6756});
        bmr.put(Sex.Male, new Double[]{66.4730, 13.7516, 5.0033, 6.7550});
    }

    public void AMR(){
        amr = new HashMap<Activ, Double>();
        amr.put(Activ.Sitting, (Double)1.2);
        amr.put(Activ.Middle, (Double) 1.55);
        amr.put(Activ.Activity, (Double) 1.725);
    }

    public double resultBMR(Sex sex){
        return bmr.get(sex)[0] + (bmr.get(sex)[1] * Weight) + (bmr.get(sex)[2] * Height) -
                (bmr.get(sex)[3] * Age);
    }

    public double resultAMR (Activ activ){
        return amr.get(activ);
    }

    public double answer(Sex sex, Activ activ){
        return resultBMR(sex) * resultAMR(activ);
    }
}


