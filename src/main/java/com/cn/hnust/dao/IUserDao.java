package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.pojo.User;
@Repository
public interface IUserDao {
	List<User> getList(Map<String,Object> map);
    int delete(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int update(User record);
    
    int getTotalNum();
}