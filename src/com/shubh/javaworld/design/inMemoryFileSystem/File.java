package com.shubh.javaworld.design.inMemoryFileSystem;

import java.util.Date;

public class File extends Entry {
	private Directory parentDirectory;
	private String content;

	public int size() {
		return 1;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String path() {
		return parentDirectory.path() + "/" + getName();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date(System.currentTimeMillis());
		System.out.println(d.toString());

	}

}
