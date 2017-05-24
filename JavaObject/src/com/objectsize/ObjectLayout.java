package com.objectsize;

import java.lang.reflect.Field;

import org.apache.lucene.util.RamUsageEstimator;

import sun.misc.Unsafe;

public class ObjectLayout {
	/**
	 * 内存对齐规则（64位系统实验） jdk 8
	 * 1、对象整体需要按8字节对齐，每个成员变量都尽量使本身的大小在内存中尽量对齐。比如 int 按 4 位对齐，long 按 8 位对齐。
       2、类属性按照如下优先级进行排列：长整型和双精度类型；整型和浮点型；字符和短整型；字节类型和布尔类型，最后是引用类型。这些属性都按照各自的单位对齐。
                         特例：如果是64位开启压缩指针对象，则8markword + 4 类型指针  则后面空余的4个字节，优先使用int排布，如果无int则使用小于int的填满，而后按照上述原则排布。
       3、 优先按照规则一和二处理父类中的成员，接着才是子类的成员
       4、 父类排布完成后需要进行8字节的对齐后才能继续排布子类的成员变量，如果父类没有成员变量，则直接排布子类的成员变量
	 * 
	 * 
	 */
	
	byte a;
	int h;
	int c;
	boolean d;
	long e;
	short m;
	Object f;
	int[] s;
	double[] t = new double[10];

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Unsafe.class.getDeclaredField("theUnsafe");

		// 设置该Field为可访问
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);
		System.out.println(unsafe);

		ObjectLayout fuck = new ObjectLayout();
		System.out.println(RamUsageEstimator.shallowSizeOf(fuck));

		ObjectLayout[] oarray = new ObjectLayout[4];
		System.out.println(RamUsageEstimator.shallowSizeOf(oarray));

		long c_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("c"));
		System.out.println("c:" + c_offset);

		long e_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("e"));
		System.out.println("e:" + e_offset);
		long a_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("a"));
		System.out.println("a:" + a_offset);
		long d_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("d"));
		System.out.println("d:" + d_offset);
		long f_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("f"));
		System.out.println("f:" + f_offset);

		long m_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("m"));
		System.out.println("m:" + m_offset);
		long s_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("s"));
		System.out.println("s:" + s_offset);
		long t_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("t"));
		System.out.println("t:" + t_offset);
		long h_offset = unsafe.objectFieldOffset(ObjectLayout.class.getDeclaredField("h"));
		System.out.println("h:" + h_offset);

	}

}
