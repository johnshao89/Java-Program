package com.github.johnshao89;

/*	
 * 
 * 
 * 类中方法的声明和使用
	方法：描述类应该具有的功能
	比如：Math类：squrt（）、random（）。。。
		Arrays类：sort（）、binarySearch（）
		
	1.举例：
	2.方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
						方法体
									}
	
	*3.说明：
	*	3.1 关于权限修饰符：
	*		private，public，缺省，protected --》封装性
	*	3.2 返回值类型：有返回值vs没有返回值
	*		3.2.1 如果方法有返回值，则必须在方法声明时指定返回值类型。同时方法中需要使用return来返回指定类型
	*				如果方法没有返回值，则必须用void表示
	*		3.2.2 定义的方法该不该有返回值？
	*				1.看题目要求
	*	3.3 方法名：属于标识符，遵循标识符规则
	*	3.4 形参列表：数据类型1 形参名1，数据类型2 形参名2.。。
	*	3.5 方法体：
	*
	*4.	return关键字使用：
	*		1.适用范围：在方法体中
	*		2.结束方法，返回数据
	*		3. return关键字后面不可以声明执行语句
	*
	*5.	方法使用中可以条用当前类的属性或者方法
	*		特殊方法：方法A中又调用了方法A
	*		方法中不可以定义方法
	*/
public class CustomerTest {

}
//客户类
class Customer{
	//属性
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat() {
		System.out.println("客户吃饭");
	}
	
	public void sleep(int hour) {
		System.out.println("休息了"+hour+"个小时");
	}
	
	public String getName(){
		return name;
	}
	
	public String getNation(String nation) {
		String info ="我的国家是"+nation;
		return info;
	}
}