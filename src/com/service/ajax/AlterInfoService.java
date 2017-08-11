package com.service.ajax;

import com.beans.User;
import com.dao.UserDao;
import com.utils.Encrypt;
import com.utils.Tools;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/25 0025.
 */
public class AlterInfoService {
    private UserDao ud = new UserDao();
    /*
    * 查找用户
    * */
    public User getUserById(int id){
        return ud.selectUserById(id);
    }

    /*
    * 查找除本身外是否有其他的预邮箱相同用户
    * */
    public User getUserByMailDisSelf(String mail,int id){
        return ud.selectUserByUsermailDisSelf(mail,id);
    }

    /*
    * 修改密码
    * */
    public Map<String,String> alterPassword(int id,String oldPassword,String newPassword){
        Map<String,String> map = new HashMap<>();
        User user = getUserById(id);
        if(user==null){
            map.put("code","403");
            map.put("msg","不存在目标用户");
        }else{
            if(Encrypt.md5(oldPassword).equals(user.getPassword())){
                if(Tools.checkPasswordModel(newPassword)){
                    user.setPassword(Encrypt.md5(newPassword));
                    int count = ud.updateUserByObject(user);
                    if(count>0){
                        map.put("code","200");
                        map.put("msg","修改成功,新密码将会在下一次登录生效");
                    }else{
                        map.put("code","403");
                        map.put("msg","修改失败");
                    }
                }else{
                    map.put("code","403");
                    map.put("msg","新密码应为a-Z|0-9以及下划线组成的6-15个字符");
                }
            }else{
                map.put("code","403");
                map.put("msg","旧密码错误");
            }
        }
        return map;
    }

    /*
    * 修改个人信息
    * */
    public Map<String,String> alterInfo(int id,String mail){
        Map<String,String> map = new HashMap<>();
        User user = getUserByMailDisSelf(mail,id);
        if(user==null){
            user = getUserById(id);
            if(user==null){
                map.put("code","403");
                map.put("msg","获取用户身份异常");
            }else{
                if(Tools.isEmail(mail)){
                    user.setUsermail(mail);
                    int count = ud.updateUserByObject(user);
                    if(count>0){
                        map.put("code","200");
                        map.put("msg","修改成功");
                    }else{
                        map.put("code","403");
                        map.put("msg","修改失败");
                    }
                }else{
                    map.put("code","403");
                    map.put("msg","邮箱格式错误");
                }
            }
        }else{
            map.put("code","403");
            map.put("msg","目标邮箱已经被使用拉啦~");
        }
        return map;
    }
}
