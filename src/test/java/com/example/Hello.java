package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengxiaopeng on 2017/1/1.
 */
public class Hello {

    @RefAnno(name="sxp111",ref = @Anno1(value = 15))
    public   void  hello(){
    }

    public static void main(String[] args) {

      /*  Map map=new HashMap();
        System.out.println( map.get("key"));;*/   //null


        try {
            Method method = Hello.class.getMethod("hello");
            RefAnno refAnno = method.getAnnotation(RefAnno.class);

            Anno1 anno1 = refAnno.ref();
            int value = anno1.value();

            System.out.println(value);

            Method methodOfAnno = RefAnno.class.getMethod("name");
            Anno1 annotation = methodOfAnno.getAnnotation(Anno1.class);
            int value1 = annotation.value();
            System.out.println(value1);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}

@Retention(RetentionPolicy.RUNTIME)
@interface Anno1{
    int value() default 0;
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RefAnno{

    /**
     * 注解接口里的方法也可以加注解
     * @return
     */
    @Anno1(88)
    String name() default "sxp";

    /**
     * 注解的RefAnno 的成员ref 是 注解 Anno1类型
     * @return
     */
    Anno1 ref() default @Anno1(value = 1);

}