package com.service.ajax;

import com.beans.Group;
import com.beans.Level;
import com.dao.GroupDao;
import com.dao.LevelDao;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/23 0023.
 */
public class UserGroupService {
    private GroupDao groupDao = new GroupDao();
    /*
    * 判断是否存在目标权限
    * */
    public boolean issetLevel(int id){
        Level level = new LevelDao().selectLevelById(id);
        return level != null;
    }

    /*
    * 根据用户组名称查找指定用户组信息
    * */
    public Group getUserGroupByName(String name){
        return groupDao.selectGroupByName(name);
    }

    /*
    * 根据ID查找指定的用户组信息
    * */
    public Group getUserGroupById(int id){
        return groupDao.selectGroupById(id);
    }

    /*
    * 查找除本身外是否含有其他同名用户组
    * */
    public Group getUserGroupDisId(String name,int id){
        return groupDao.selectGroupByNameDisId(name,id);
    }

    /*
    * 添加用户组
    * */
    public Map insertUserGroup(String name,String[] s){
        Map tipsMap = new HashMap<>();
        Group group = getUserGroupByName(name);
        if(group==null){
            boolean tmep = false;
            for(String ss:s){
                if(!issetLevel(Integer.parseInt(ss))){
                    tmep = true;
                    tipsMap.put("code","403");
                    tipsMap.put("msg","目标权限中有不存在项");
                    break;
                }
            }
            if(!tmep){
                group = new Group();
                group.setName(name);
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < s.length; i++) {
                    if(i==s.length-1){
                        sb.append(s[i]);
                    }else{
                        sb.append(s[i]).append(",");
                    }
                }
                group.setLevel(new String(sb));
                int num = groupDao.insertGroupByObject(group);
                if(num>0){
                    tipsMap.put("code","200");
                    tipsMap.put("msg","添加成功");
                }else{
                    tipsMap.put("code","403");
                    tipsMap.put("msg","添加失败");
                }
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","存在同名用户组");
        }
        return tipsMap;
    }

    /*
    * 获取用户组信息
    * */
    public Map selectUserGroup(int id){
        Map tipsMap = new HashMap<>();
        Group group = getUserGroupById(id);
        if(group==null){
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在目标用户组");
        }else{
            tipsMap.put("code","200");
            tipsMap.put("msg","获取成功");
            tipsMap.put("id",group.getId());
            tipsMap.put("name",group.getName());
            tipsMap.put("level",group.getLevel());
        }
        return tipsMap;
    }

    /*
    * 更新用户组
    * */
    public Map updateUserGroup(int id,String name,String le){
        Map tipsMap = new HashMap<>();
        Group group = new Group();
        group.setId(id);
        group.setName(name);
        group.setLevel(le);
        Group selGroup = getUserGroupById(id);
        if(selGroup!=null){
            if(getUserGroupDisId(group.getName(),group.getId())!=null){
                tipsMap.put("code","403");
                tipsMap.put("msg","已存在目标同名用户组");
            }else{
                String s[] = (group.getLevel()).split(",");
                int len = s.length;
                if(len<0){
                    tipsMap.put("code","403");
                    tipsMap.put("msg","权限不可以少于一项");
                }else{
                    boolean temp = false;
                    for (String ss:s){
                        if(!issetLevel(Integer.parseInt(ss))){
                            temp = true;
                            tipsMap.put("code","403");
                            tipsMap.put("msg","目标权限中有不存在项");
                            break;
                        }
                    }
                    if(!temp){
                        int num = groupDao.updateGroupByObject(group);
                        if(num>0){
                            tipsMap.put("code","200");
                            tipsMap.put("msg","更新成功!");
                        }else{
                            tipsMap.put("code","403");
                            tipsMap.put("msg","更新失败!");
                        }
                    }
                }
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在目标用户组");
        }
        return tipsMap;
    }

}
