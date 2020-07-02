package cn.enjoyedu.ch3;

import java.util.concurrent.atomic.AtomicReference;

/**
 *类说明：演示引用类型的原子操作类
 */
public class UseAtomicReference {
    static AtomicReference<UserInfo> atomicUserRef;
    public static void main(String[] args) {
        /**
         * 将一个引用类型进行包装起来，然后进行操作，保证操作过程的原子性
         */
        UserInfo user = new UserInfo("Mark", 15);//要修改的实体的实例
        atomicUserRef = new AtomicReference(user);
        UserInfo olduser = atomicUserRef.get();
        UserInfo updateUser = new UserInfo("Bill",17);
        //保证这一步是原子操作
        atomicUserRef.compareAndSet(user,updateUser);
        //
        UserInfo newuser = atomicUserRef.get();
        System.out.println(olduser);
        System.out.println(newuser);
    }
    
    //定义一个实体类
    static class UserInfo {
        private volatile String name;
        private int age;
        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
