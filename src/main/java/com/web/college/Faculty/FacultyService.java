package com.web.college.Faculty;
import org.springframework.stereotype.Service;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
@Service
public class FacultyService {
    @Autowired
    JdbcTemplate jt;
    public int saveFaculty(@NotNull HashMap<String,Object> map){
        if(isFacultyInTable((String)map.get("userid"))) return -1;
        String sql="insert into faculty(userid,name,gender,dob,department,contactnumber,address,designation) values (?,?,?,?,?,?,?,?)";
        return jt.update(sql,
                map.get("userid"),map.get("name"),map.get("gender"),
                map.get("dob"),map.get("department"),map.get("contact_number"),
                map.get("address"),map.get("designation"));
    }
    public List<Map<String, Object>> getAllFaculty(){
        List<Map<String,Object>> dataS= jt.queryForList("select * from faculty");
        if(dataS.isEmpty()){
            return new ArrayList<>();
        }
        return dataS;
    }//working
    public boolean isFacultyInTable(String id){
        try{
            String userid = jt.queryForObject("select userid from faculty where userid='"+id+"'",String.class);
            if(userid!=null&& userid.equals(id)) return true;
        }catch(Exception e){
            return false;
        }
        return false;
    }//tested success

    public int saveExperience(@NotNull HashMap<String,Object> map){
        String ex =(String) map.get("exfrom");
        String to = (String) map.get("exto");
        String experienceId= UUID.randomUUID().toString().replace("-", "");
        final String sql = "insert into experience(experienceid, userid, experiencetype, exfrom, exto, company, designation)" +
                "values(?,?,?,'"+ex+"','"+to+"',?,?)";
        return jt.update(sql,experienceId,map.get("userid"),map.get("experiencetype"),map.get("company"),map.get("designation"));
    }//tested success
    public int saveSocialLinks(HashMap<String,Object> map){

        String socialId= UUID.randomUUID().toString().replace("-", "");
        String sql = "insert into sociallinks(socialid,userid,github,linkedin) values(?,?,?,?)";
        return jt.update(sql,socialId,map.get("userid"),map.get("github"),map.get("linkedin"));
    }//tested successfully
    public int saveResearchPapers(HashMap<String,Object> map){
        String papered = UUID.randomUUID().toString().replace("-", "");
        String sql = "insert into recenteducation(userid,recentid,type,issuedby)" +
                "values(?,?,?,?)";
        return jt.update(sql,map.get("userid"),papered,map.get("type"),map.get("issuedby"));
    }
    public List<Map<String,Object>> getAllSubData(@NotNull String sql){
        List<Map<String,Object>> dataS= jt.queryForList(sql);
        if(dataS.isEmpty()){
            return new ArrayList<>();
        }
        return dataS;
    }
    public Object getData(String sql,@NotNull String ... args){
        List<Map<String,Object>> dataS= jt.queryForList(sql, args);
        if(dataS.isEmpty()){
            return new ArrayList<>();
        }
        return dataS;
    }
}