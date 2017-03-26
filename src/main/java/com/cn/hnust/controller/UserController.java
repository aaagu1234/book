package com.cn.hnust.controller;  
  
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;  
 
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model){  
//        int userId = Integer.parseInt(request.getParameter("id"));  
//        User user = this.userService.getUserById(userId);  
//        model.addAttribute("user", user);  
        return "showUser";  
    } 
    @RequestMapping("/getList")  
    @ResponseBody
    public Map<String,Object> getList(String name,Integer page,Integer limit){ 
    	int start = (page-1)*limit;
    	Map<String,Object> mm = new HashMap<String,Object>();
    	if(name == null){
    		name = "";
    	}
    	mm.put("name", name);
    	mm.put("start", start);
    	mm.put("limit", limit);
    	List<User> list = this.userService.getList(mm);  
    	int total = this.userService.getTotalNum(); 
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("success", true);
    	map.put("data", list);
    	map.put("rowCount", total);
    	map.put("msg", "ok");  
        return map;  
    }
    
    @RequestMapping(value = "insert", method = RequestMethod.POST) 
    @ResponseBody
    public Map<String,Object> insert(String data){  
    	// 因为是同步sync extjs ，穿过来的是json字符串不是对象。所以要转一下 
    	JSONObject jsonObject=JSONObject.fromObject(data);
    	User stu=(User)JSONObject.toBean(jsonObject, User.class);
        this.userService.insert(stu);  
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("success", true);
    	map.put("msg", "添加成功");  
        return map;  
    } 
    
    @RequestMapping(value = "update", method = RequestMethod.POST) 
    @ResponseBody
    public Map<String,Object> update(String data){ 
    //Property 'java.util.Date.class' has no write method. SKIPPED.
    	// 因为是同步sync extjs ，穿过来的是json字符串不是对象。所以要转一下 
    	JSONObject jsonObject=JSONObject.fromObject(data);
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}));
    	User stu=(User)JSONObject.toBean(jsonObject, User.class);
        this.userService.update(stu);  
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("success", true);
    	map.put("msg", "编辑成功");  
        return map;  
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.POST) 
    @ResponseBody
    public Map<String,Object> delete(String data){ 
    //Property 'java.util.Date.class' has no write method. SKIPPED.
    	// 因为是同步sync extjs ，穿过来的是json字符串不是对象。所以要转一下 
    	JSONObject jsonObject=JSONObject.fromObject(data);
    	User stu=(User)JSONObject.toBean(jsonObject, User.class);
        this.userService.delete(stu.getId());  
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("success", true);
    	map.put("msg", "删除成功");  
        return map;  
    }
    
    @RequestMapping(value = "selectByKey", method = RequestMethod.GET) 
    @ResponseBody
    public Map<String,Object> selectByKey(Integer id){ 
        User u = this.userService.selectByKey(id);  
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("data", u);
    	map.put("success", true);
    	map.put("msg", "获取成功");  
        return map;  
    }
}  

 