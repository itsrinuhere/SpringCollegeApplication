package com.web.college.Student;

import Utility.Utility;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    JdbcTemplate jt;
     Utility ut= new Utility();
    public int saveStudent(HashMap<String,Object> data) {
        try {
            String id= (String)data.get("studentid");
            return (!ut.isYearFormat((String) data.get("batch")) && !ut.isValidEmail((String) data.get("emailid")))
                   ?-1:
                    isinTable("select studentId from student where studentId='"+id+"'",id)?-1:
                    jt.update("insert into student (studentid,name,batch,emailid,mobile)values(?,?,?,?,?)",
                                id, data.get("name"), data.get("batch"), data.get("emailid"), data.get("mobile"));
        } catch (Exception e) {
            return -1;
        }
    }
    public boolean isinTable(String sql,String id){
        try{
            String val = jt.queryForObject(sql,String.class);
            System.out.println(val);
            return val != null && val.equals(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public  Object get(String sql, @NotNull String ... args){
        List<Map<String,Object>> dataS= jt.queryForList(sql,args);
        if(dataS.isEmpty()){
            return new ArrayList<>();
        }
        return dataS;
    }
    int saveSubData(String sql,@NotNull String ... args){
        try{
            sql = sql.replace("[", "").replace("]", "");
            System.out.println(sql);
         return jt.update(sql, args);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
