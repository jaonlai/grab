package com.example.springboot.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String account;

	private String name;

	private String pwd;

	private String token;

	@Column(name = "create_date")
	private java.util.Date createDate;

	@Column(name = "update_date")
	private java.util.Date updateDate;

	private String slat;

}
