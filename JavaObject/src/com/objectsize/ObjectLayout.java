package com.objectsize;

import java.lang.reflect.Field;

import org.apache.lucene.util.RamUsageEstimator;

import sun.misc.Unsafe;

public class ObjectLayout {

	byte a;
	int c;
	boolean d;
	long e;
	short m;
	Object f;
	int[] s;
	double[] t;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Unsafe.class.getDeclaredField("theUnsafe");

		// 设置该Field为可访问
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);
		System.out.println(unsafe);

		ObjectLayout fuck = new ObjectLayout();
		System.out.println(RamUsageEstimator.shallowSizeOf(fuck));
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
		
	}

}
