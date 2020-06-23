package lambda.service;

@FunctionalInterface  //检查是否是函数式接口
public interface LambdaService<T> {

    public static final int sum = 0;

    public abstract boolean show(T t);



}
