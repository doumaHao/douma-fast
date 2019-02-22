package com.douma.fast.study.io;

import java.io.*;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/2/22 10:12
 */
public class Bio {

    public static void main(String[] args) {

        String filePath = Bio.class.getClassLoader().getResource("file/io/file.txt").getPath();

        Bio bio = new Bio();
        bio.read(filePath);
    }

    public void read(String filePath) {
        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            //一行一行执行IO 读取文件
            String line1 = bufferedReader.readLine();
            String line2 = bufferedReader.readLine();
            String line3 = bufferedReader.readLine();
            String line4 = bufferedReader.readLine();
            System.out.println("第一行：" + line1);
            System.out.println("第二行：" + line2);
            System.out.println("第三行：" + line3);
            System.out.println("第四行：" + line4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
