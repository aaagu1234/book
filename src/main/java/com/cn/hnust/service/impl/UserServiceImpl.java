package com.cn.hnust.service.impl;  
  
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;  
  
import com.cn.hnust.dao.IUserDao;  
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
//    @Override  
//    public Apps getUserById(int userId) {  
//        // TODO Auto-generated method stub  
//        return this.userDao.selectByPrimaryKey(userId);  
//    }  

	
    public List<User> getList(Map<String,Object> map){
		  return this.userDao.getList(map);  
	}
    
    public int insert(User record){
    	  return this.userDao.insert(record);  
    }
    
    public int update(User record){
  	  return this.userDao.update(record);  
    }
    // 
    public int delete(Integer id){
    	  return this.userDao.delete(id);  
    }
     
    public User selectByKey(Integer id){
  	  return this.userDao.selectByKey(id);  
    }
    // int getTotalNum();
    public int getTotalNum(){
       return this.userDao.getTotalNum();  
    }
}  