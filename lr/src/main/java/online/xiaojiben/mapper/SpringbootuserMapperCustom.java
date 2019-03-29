package online.xiaojiben.mapper;

import online.xiaojiben.pojo.Springbootuser;
import online.xiaojiben.utils.MyMapper;

public interface SpringbootuserMapperCustom extends MyMapper<Springbootuser> {
	String queryByIdAndName(String username, String pwd);
}