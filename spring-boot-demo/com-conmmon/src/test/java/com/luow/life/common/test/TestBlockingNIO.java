package com.luow.life.common.test;

import com.luow.life.conmmon.model.Person;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO {

    @Test
    public void testClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String className = "com.luow.life.conmmon.model.Person";
        Class<?> aClass = Class.forName(className);
//        System.out.println(aClass.toString());
        Object o = aClass.newInstance();
        Method[] methods = aClass.getMethods();
        Method setAge = aClass.getMethod("setAge", int.class);
        setAge.invoke(o,1);
        System.out.println(setAge);
        /*for (Method method : methods) {
            System.out.println(method.getName());
        }*/

    }

    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {
        //1. 获取通道、读取文件
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        //2. 分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //3. 读取本地文件，并发送到服务器
        while (inChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            sChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        sChannel.close();
    }

    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {
        //1. 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2. 绑定端口
        ssChannel.bind(new InetSocketAddress(8989));
        //3. 分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1204);
        //4. 获取客户端通道
        SocketChannel sChannel = ssChannel.accept();
        //5. 将客户端文件写入到本地
        while (sChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        sChannel.close();
        outChannel.close();
        ssChannel.close();


    }

}
