package com.shubh.javaworld.design.inMemoryFileSystem;

public abstract class Entry {
	private String name;
	private long createdAt;
	private long lastModifedAt;
	private User createdBy;
	private User lastModifedBy;

	public abstract int size();

	public String getName() {
		return name;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getLastModifedAt() {
		return lastModifedAt;
	}

	public void setLastModifedAt(long lastModifedAt) {
		this.lastModifedAt = lastModifedAt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getLastModifedBy() {
		return lastModifedBy;
	}

	public void setLastModifedBy(User lastModifedBy) {
		this.lastModifedBy = lastModifedBy;
	}

	public void setName(String name) {
		this.name = name;
	}
}
