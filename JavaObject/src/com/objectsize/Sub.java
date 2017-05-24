package com.objectsize;

import java.lang.reflect.Field;

import org.apache.lucene.util.RamUsageEstimator;

import sun.misc.Unsafe;

public class Sub extends Parent {
	int b;

	public static class A {

		public static int a = 0;

		public final long b = 3;

		public int c;

	}

	public static void main(String[] args) throws NoSuchFieldException, Exception {
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		// 设置该Field为可访问
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);
		System.out.println(unsafe);

		Sub sub = new Sub();
		System.out.println(RamUsageEstimator.shallowSizeOf(sub));
		byte[] a = new byte[5];
		System.out.println(RamUsageEstimator.shallowSizeOf(a));
		Byte[] b = new Byte[5];
		System.out.println(RamUsageEstimator.shallowSizeOf(b));
	}

}
