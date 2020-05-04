package files.rename;

import org.reflections.Reflections;
import reflection.IJobInter;
import reflection.MyInnotation;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2020/5/4 22:09
 **/
public class Test {

    public static void main(String[] args) throws Exception {


        Reflections reflections = new Reflections("reflection.*");
        //比如可以获取有Pay注解的class
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MyInnotation.class);

        for (Class<?> cl : classes){
            System.out.println(cl.getCanonicalName());
            Method method = cl.getMethod("execute", String.class);
            method.invoke(cl.newInstance(), "test1");
        }

    }




}
