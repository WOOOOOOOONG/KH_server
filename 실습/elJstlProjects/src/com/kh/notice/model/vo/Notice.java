package com.kh.notice.model.vo;

public class Notice {
	private int nid;
	private String title;
	private String content;
	private String writer;
	
	public Notice() {}

	public Notice(int nid, String title, String content, String writer) {
		super();
		this.nid = nid;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	
	
}
