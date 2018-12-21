package cn.jt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

//引入MybatisPlus
@TableName("user")		//表和类的映射
public class User {
	
	@TableId(type=IdType.AUTO)	//主键，自增主键
	private Long id;
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
}
