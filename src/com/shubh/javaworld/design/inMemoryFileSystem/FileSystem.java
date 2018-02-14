package com.shubh.javaworld.design.inMemoryFileSystem;

import java.util.List;

public class FileSystem {
	private Directory root = null;

	public FileSystem() {
		this.setRoot(new Directory("/"));
	}

	public Directory getRoot() {
		return root;
	}

	public void setRoot(Directory root) {
		this.root = root;
	}

	public void mkdir(String name) {

	}

	public List<String> ls(String path) {
		return null;
	}

	public void addContentToFile(String fileName, String content) {

	}

	public String readContentFromFile(String fileName) {
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
