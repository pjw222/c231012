package c231020.board;

import java.sql.Date;

import c231019.user.UserBean;

public class BoardBean {
	private int id;
	private int userId;
	private UserBean user;
	private String title;
	private String content;
	private Date createdAt;

	public BoardBean() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserId(int user) {
		this.userId = user;
	}

	public int getUserId() {
		return userId;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}

	public UserBean getUser() {
		return user;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
