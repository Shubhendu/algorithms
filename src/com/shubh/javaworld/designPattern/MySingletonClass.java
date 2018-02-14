package com.shubh.javaworld.designPattern;

import java.text.NumberFormat;
import java.util.Calendar;

public class MySingletonClass {
	private volatile static MySingletonClass mySingletonClassInstance;

	private MySingletonClass() {

	}

	public MySingletonClass getInstance() {
		if (mySingletonClassInstance == null) {
			synchronized (MySingletonClass.class) {
				if (mySingletonClassInstance == null) {
					mySingletonClassInstance = new MySingletonClass();
				}
			}
		}
		return mySingletonClassInstance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		NumberFormat n = NumberFormat.getInstance();
		
		StringBuilder sb = new StringBuilder();
	}

}
