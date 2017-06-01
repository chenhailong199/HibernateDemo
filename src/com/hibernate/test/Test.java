package com.hibernate.test;

/**
 * @author Administrator
 *	通过子类来调用父类的静态字段，只会触发父类的初始化,但是这是要看不同的虚拟机的不同实现。
 *	
 */
public class Test {
	
 public static void main(String[] args) {
		System.out.println(SubClass.value);
	}
	
}
class SupperClass{
	static {
		System.out.println("-------SupperClass.init");
	}
	public static int value = 123;
}

class SubClass extends SupperClass{
	static {
		System.out.println("-------SubClass.init");
	}
}