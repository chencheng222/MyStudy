package com.cc.study.thread;

/**
 * 单例模式
 * 1.私有化构造方法->避免外部new对象
 * 2.提供私有静态属性->存储对象地址
 * 3.提供公共静态方法->获取属性
 *
 * @author chenc
 * @create 2019-08-17 15:26
 **/
public class DoubleCheckedLocking {

    // 2.提供私有静态属性
    private static volatile DoubleCheckedLocking instance;

    // 1.私有化构造方法
    private DoubleCheckedLocking() {

    }

    public static DoubleCheckedLocking getInstance() {

        // 再次检测，避免不必要的同步
        if(instance != null) {
            return instance;
        }

        synchronized (DoubleCheckedLocking.class) {
            if (instance == null) {
                /**
                 * 对象初始化
                 * 1.开辟空间
                 * 2.初始化对象信息
                 * 3.返回对象的地址给引用
                 *
                 * ->java编译存在指令重排序，若步骤2的时间消耗比较长，会先
                 * 返回对象的地址，导致其他线程引用的空对象
                 * 解决方法：静态变量采用volatile修饰
                 */
                instance = new DoubleCheckedLocking();
            }
        }


        return instance;
    }

}
