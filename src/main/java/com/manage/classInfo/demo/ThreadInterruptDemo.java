package com.manage.classInfo.demo;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptDemo {
//	public static void main(String[] args) throws InterruptedException {
//		Thread thread = new Thread(()->{
//			while(true) {
//				boolean in = Thread.currentThread().isInterrupted();
//				if (in) {
//					System.out.println("before:" + in);
//					Thread.interrupted();//设置复位
//					System.out.println("after:" + Thread.currentThread().isInterrupted());
//				}
//			}
//		});
//		thread.start();
//		TimeUnit.SECONDS.sleep(1);
//		thread.interrupt();
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//		Thread thread = new Thread(()->{
//			while(true) {
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		thread.start();
//		TimeUnit.SECONDS.sleep(1);
//		thread.interrupt();
//		System.out.println("before:" + thread.isInterrupted());
//		TimeUnit.SECONDS.sleep(1);
//		System.out.println("after:" + thread.isInterrupted());
//	}
	
	
}
