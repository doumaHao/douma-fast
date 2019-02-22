package com.douma.fast.study.loader;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/2/15 14:45
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类装载器:" + appClassLoader);
        ClassLoader extensionClassLoader = appClassLoader.getParent();
        System.out.println("系统类装载器的父类加载器——扩展类加载器:" + extensionClassLoader);
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println("扩展类加载器的父类加载器——引导类加载器:" + bootstrapClassLoader);
    }

    /**
     * 查看父类加载器
     */
    public static void showClassLoader(){

    }


}
