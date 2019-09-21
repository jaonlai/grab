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

}
