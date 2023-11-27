package by.study.news.bean;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Article {
   
	private int id;
	private Date date;
	private String title;
	private String brief;
	private String content;
	private int status;

	public Article() {
	}

	public Article(String title, String brief, String content) {

		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	public Article(String title, String brief, String content, int status) {

		this.title = title;
		this.brief = brief;
		this.content = content;
		this.status = status;
	}

	public Article(int id, String title, String brief, String content, int status) {

		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.status = status;
	}
	
	public Article(int id, Date date, String title, String brief, String content, int status) {

		this.date = date;
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", date=" + date + ", title=" + title + ", brief=" + brief + ", content=" + content
				+ ", status=" + status + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
