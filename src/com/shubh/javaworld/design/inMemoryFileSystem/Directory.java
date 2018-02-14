/**
 * 
 */
package com.shubh.javaworld.design.inMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SSingh
 *
 */
public class Directory extends Entry {
	private List<Entry> entries;
	private Directory parent;

	public Directory(String name) {
		this.setName(name);
		this.entries = new ArrayList<Entry>();
	}

	public String path() {
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		sb.append(parent.path());
		sb.append(getName());
		return sb.toString();
	}

	public void addFile(String name) {
		File f = new File();
		f.setName(name);
		this.entries.add(f);
	}

	public void addDirectory(String name) {
		Directory d = new Directory(name);
		this.entries.add(d);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
