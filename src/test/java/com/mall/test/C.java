package com.mall.test;

public class C {

    public static void aiXin(){
        for(float y = (float) 1.5;y>-1.5;y -=0.1)  {
            for(float x= (float) -1.5;x<1.5;x+= 0.06){
                float a = x*x+y*y-1;
                if((a*a*a-x*x*y*y*y)<=0.0)  {
                    System.out.print("蕊");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        aiXin();

    }
}
