package com.example.springboot.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_detail")
public class UserDetail  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	private Long money;

	@Column(name = "user_level")
	private Long userLevel;

	@Column(name = "user_point")
	private Long userPoint;

	@Column(name = "nick_name")
	private String nickName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Long userLevel) {
		this.userLevel = userLevel;
	}

	public Long getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(Long userPoint) {
		this.userPoint = userPoint;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
