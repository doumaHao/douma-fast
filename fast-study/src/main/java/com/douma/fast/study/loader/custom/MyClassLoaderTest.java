package com.douma.fast.study.loader.custom;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/2/15 15:52
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MyClassLoader loader = new MyClassLoader();
        Class<?> c = loader.findClass("com.douma.fast.crawl.loader.custom.HighRichHandsome");
        System.out.println("Loaded by :" + c.getClassLoader());

        Person p = (Person) c.newInstance();
        p.say();

        //注释下面两行则不报错
        HighRichHandsome man = (HighRichHandsome) c.newInstance();
        man.say();
    }

}
