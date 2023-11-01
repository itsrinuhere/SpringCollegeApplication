package com.web.college.Student;

import Utility.Utility;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    jt.update("INSERT INTO internship (uniqueid, name, company, startdate, enddate, studentid, verification) VALUES (?, ?, ?, ?, ?, ?, ?)",
                                id, data.get("name"), data.get("batch"), data.get("emailid"), data.get("mobile"));
        } catch (Exception e) {
            return -1;
        }
    }
    public boolean isinTable(String sql,String id){
        try{
            String val = jt.queryForObject(sql,String.class);
            return val != null && val.equals(id);
        }catch(EmptyResultDataAccessException e){

            return false;
        }

    }
    public  Object get(String sql, @NotNull String ... args){
        try{
            List<Map<String,Object>> dataS= jt.queryForList(sql,args);
            return dataS;
        }catch(Exception e){
            return new ArrayList<>();
        }
//        PreparedStatementCreator psc=con -> {
//            PreparedStatement ps = con.prepareStatement(sql);
//            for(int i=0;i<args.length;i++){
//                StatementCreatorUtils.setParameterValue(ps,i,SqlTypeValue.TYPE_UNKNOWN,args[i]);
//            }
//            return ps;
//        };
//        List<Map<String,Object>> dataS = jt.queryForList(psc.toString());
    }
    public int saveInternship(HashMap<String, Object> data) {
        String sql = "INSERT INTO internship (uniqueid, name, company, startdate, enddate, studentid, verification) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            return jt.update(sql, preparedStatement ->{
                try {
                preparedStatement.setString(1, ut.UUIDGenerator());
                preparedStatement.setString(2,  (String) data.get("name"));
                preparedStatement.setString(3,   (String) data.get("company"));
                preparedStatement.setDate(4, ut.dateparser((String)data.get("startdate")));
                preparedStatement.setDate(5,  ut.dateparser((String)data.get("enddate")));
                preparedStatement.setString(6,(String)data.get("studentid"));
                preparedStatement.setString(7, (String)data.get("verification"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            // Properly handle the exception, e.g., log it or throw a custom exception
           System.out.println(e.getMessage());
            return -1;
        }
    }
    public int saveObjectByQuery(String sql,@NotNull String ... args)throws SQLException {
        try{
            return jt.update(sql, preparedStatement ->{
                try {
                    for(int i=0;i<args.length;i++){
                        if(ut.isObjectDateValid(args[i])){
                            preparedStatement.setDate(i+1, ut.dateparser(args[i]));
                        }else{
                            preparedStatement.setString(i+1,args[i]);
                        }
                    }
                } catch (Exception e) {
                e.printStackTrace();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
