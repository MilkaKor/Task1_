package com.example.task0;

public class Procent {
    Procent(){
        sum = 0;
    }
    Procent(float value){sum = value;}
    private float sum;
    public void setSum(float value){this.sum = value;}
    public float getSum( ){return this.sum;}
    private double pr;
    public float countPr(int pr)
    {

        return (pr*this.sum)/100;
    }

    public float countSum(float sum, float pr)
    {
        return sum + sum*pr/100;
    }
    public  int countSumrnd(int pr)
    {
        return Math.round(this.sum+this.sum*pr/100);
    }
}
