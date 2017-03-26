package com.cn.hnust.service;  
  
import java.util.List;
import java.util.Map;

import com.cn.hnust.pojo.User;;  
  
public interface IUserService {  
    public List<User> getList(Map<String,Object> map);
    public int insert(User record);
    int update(User record);
    int delete(Integer id);
    User selectByKey(Integer id);
    int getTotalNum();
}  