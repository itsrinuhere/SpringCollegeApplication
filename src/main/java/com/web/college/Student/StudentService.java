package com.web.college.Student;

import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class StudentService {
    JdbcTemplate jt;
    public int saveStudent(HashMap<String,Object> data){
        jt.update("insert into student (studentid,name,batch,emailid,mobile)values(?,?,?,?)",
                data.get("studentid"),data.get("name"),data.get("batch"),data.get("emailld"),data.get("mobile"));
        return -1;
    }
    public  Object get(String Sql, @NotNull String ... args){
        return null;
    }

}
