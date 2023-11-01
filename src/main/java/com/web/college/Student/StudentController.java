package com.web.college.Student;
import Utility.Utility;
import jakarta.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    StudentService Ss;
    Utility ut= new Utility();
    @GetMapping("profile/{id}")
    ResponseEntity<Object> getImage(@PathVariable String id){
        return null;//url send
    }
    @PostMapping("profile/{id}")
    ResponseEntity<Object> saveImage(@PathVariable String id){
        return null;//file object save database
    }
    @PostMapping("student")
    ResponseEntity<Object> saveNewStudent(@RequestBody HashMap<String,Object> map){
    int res = Ss.saveStudent(map);
    return new ResponseEntity<>(res==-1? HttpStatus.BAD_REQUEST:HttpStatus.CREATED);
    }
    @GetMapping("student")
    ResponseEntity<Object> getData() {
       List<HashMap<String,Object>> da = (List<HashMap<String, Object>>)Ss.get("select * from student");
       return new ResponseEntity<>(da,HttpStatus.OK);
    }//testing completed
    @GetMapping("student/{end}")
    ResponseEntity<Object> getSubData(@PathVariable String end){
            List<HashMap<String,Object>> data;
            String sql = "";
            if(end!=null ){
                if(end.equals("certification") || end.equals("CERTIFICATION")){
                    sql = "select * from certification";
                }else if(end.equals("skill")||end.equals("SKILL")){
                    sql = "select * from skill";
                }else if(end.equals("project")||end.equals("PROJECT")){
                    sql = "select * from project";
                }else if(end.equals("internship")||end.equals("INTERNSHIP")){
                    sql = "select * from internship";
                }else{
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
            data = (List<HashMap<String,Object>>)Ss.get(sql);
            return new ResponseEntity<>(data,HttpStatus.OK);
    }//testing completed
    @GetMapping("student/{end}/{id}")
    ResponseEntity<Object> getSubStudentData(@PathVariable String end, @PathVariable String id,@Nullable @RequestParam("id") String uniqueId) {
        List<HashMap<String,String>> data = null;
        if(uniqueId!=null) System.out.println(uniqueId);
        String sql=null;
        if(end!=null && id!=null){
            if(end.equals("certification") || end.equals("CERTIFICATION")){
                sql = "select * from certification where studentId=?";
            }else if(end.equals("skill")||end.equals("SKILL")){
                sql = "select * from skill where studentId =?";
            }else if(end.equals("project")||end.equals("PROJECT")){
                sql = "select * from project where studentId=?";
            }else if(end.equals("internship")||end.equals("INTERNSHIP")){
                sql = "select * from internship where studentId=?";
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(uniqueId!=null){
                sql+=" and uniqueId=?";
                data = (List<HashMap<String, String>>) Ss.get(sql,id,uniqueId);
            }else{
                data = (List<HashMap<String, String>>) Ss.get(sql,id);
            }
        }
        assert data != null;
        return (data.isEmpty())?
                new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(data.get(0),HttpStatus.OK);
    }
//    @GetMapping("student/{end}/{id}")
//    ResponseEntity<Object> getSubObject(@PathVariable String end, @PathVariable String id,@RequestParam("uid") String uniqueId) {
//    return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping("student/{end}")
    ResponseEntity<Object> SaveSubData(@PathVariable String end,@RequestBody HashMap<String,Object> data){
        int res=-1;
        System.out.println("Post method using /student/"+end);
        String sql="";
        String id = (String)data.get("studentid");
        if(Ss.isinTable("select studentId from student where studentId='"+id+"'",id))
            if(end.equals("certification")||end.equals("CERTIFICATION")){
              //  res =Ss.saveSubData("insert into certification values(?,?,?,?,?"),ut.UUIDGenerator(),name,expire,verification,certifiedBy);
                   try{
                       sql = "insert into certification" +
                               "(uniqueid,studentid,name,expire,verification,certify)" +
                               "values(?,?,?,?,?,?)";
                       res= Ss.saveObjectByQuery(sql, ut.UUIDGenerator(),id,(String)data.get("name"), (String) data.get("expire"), (String) data.get("verification"), (String) data.get("certify"));
                   }catch (Exception ex){
                        ex.getMessage();
                   }
                   //end point certification tested successfully
            }else if(end.equals("skill")||end.equals("SKILL")){
                System.out.println("skills");
                try{
                    sql="insert into skill values(?,?,?,?)";
                    res=Ss.saveObjectByQuery(sql,
                            ut.UUIDGenerator(),id,data.get("skill").toString(),data.get("domain").toString());
                }catch(Exception e){

                }
            }else if(end.equals("project")||end.equals("PROJECT")){
                try{
                    sql ="insert into project" +
                            " values(?,?,?,?,?,?)";
                    res = Ss.saveObjectByQuery(sql,
                        ut.UUIDGenerator(),id,(String) data.get("description"),
                            (String)data.get("tags"),
                            (String)data.get("url"),
                            (String)data.get("verification"));
                }catch(Exception e){

                }
                System.out.println("project");
            }else if(end.equals("internship")||end.equals("INTERNSHIP")){
                System.out.println("internship");
                sql = "INSERT INTO internship (uniqueid, name, company, startdate, enddate, studentid, verification) VALUES (?, ?, ?, ?, ?, ?, ?)";
              try{
                  res= Ss.saveObjectByQuery(sql,
                          ut.UUIDGenerator(),(String) data.get("name"),(String) data.get("company"),
                          (String)data.get("startdate"),(String)data.get("enddate"),(String)data.get("studentid"),(String)data.get("verification"));
              }catch(Exception ignored){}//end of the Exception
            }
        /*
        End of the Internship end point tested success
         */
        return new ResponseEntity<>(res==-1?HttpStatus.BAD_REQUEST:HttpStatus.CREATED);
    }
}
