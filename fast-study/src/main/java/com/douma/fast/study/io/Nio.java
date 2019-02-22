package com.douma.fast.study.io;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/2/22 10:31
 */
public class Nio {

    public static void main(String[] args) {

        String filePath = Bio.class.getClassLoader().getResource("file/io/file.txt").getPath();

        Nio nio = new Nio();
        nio.read(filePath);
    }

    public void read(String filePath) {

        try (
                //获取文件流
                FileInputStream fileInputStream = new FileInputStream(filePath);
                //获取流通道
                FileChannel fileChannel = fileInputStream.getChannel();) {

            //设置缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(15);

            //文件通过通道读取到缓存区
            int byteRead = fileChannel.read(byteBuffer);

            //是否是一整行（是否有10换行和13回车）
            boolean isLine = false;
            while (byteRead != -1) {

                System.out.println("Buffer信息: 上限=" + byteBuffer.limit() + ",容量=" + byteBuffer.capacity() + ",位置=" + byteBuffer.position());

                byteBuffer.flip();

                System.out.print(Charset.forName("utf-8").decode(byteBuffer));
                byteBuffer.clear();
                byteRead = fileChannel.read(byteBuffer);

//                byteBuffer.reset().position()
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
