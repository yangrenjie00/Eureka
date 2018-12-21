package cn.jt.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.jt.pojo.User;

public interface UserMapper extends BaseMapper<User>{

	@Select("select count(*) from tb_user where ${type}=#{param}")
	public Integer check(@Param("type") String type,
			@Param("param") String param);
	
}
