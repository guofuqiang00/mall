package lambda.service.impl;

import lambda.service.A;

public class Context {
    //持有一个具体策略的对象
    private A  a;

    public Context(A a){

        this.a = a;
    }

    public int contextInterface(int n1,int n2){
       return a.sum(n1,n2);
    }


}
