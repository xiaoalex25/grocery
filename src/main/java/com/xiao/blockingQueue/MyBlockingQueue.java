package com.xiao.blockingQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟实现一个阻塞队列
 */
public class MyBlockingQueue<T> {
    /**
     * 队列中的容器用来存放元素
     */
    private final List<T>  list = new ArrayList<>();
    private final int maxSize;
    /**
     * 队列当前元素个数
     */
    private int size = 0;
    /**
     * 锁
     */
    private final Object object = new Object();

    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }


    /**
     * 插入一个元素
     * @param t
     * @throws InterruptedException
     */
    public void put(T t) throws InterruptedException {
        synchronized (object) {
            if (size == maxSize)
                object.wait();
            list.add(t);
            size++;
            object.notifyAll();
        }
    }

    /**
     * 获取队列中的第一元素
     * @return
     * @throws InterruptedException
     */
    public T take() throws InterruptedException {
        synchronized (object) {
            if (size == 0)
                object.wait();
            T remove = list.remove(0);
            object.notifyAll();
            return remove;
        }
    }
}
