package com.web.college.Student;
import Utility.Utility;
import org.apache.coyote.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
        data = (List<HashMap<String,Object>>)Ss.get(sql);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @PostMapping("student/{end}")
    ResponseEntity<Object> SaveSubData(@PathVariable String end,@RequestBody HashMap<String,Object> data){
        int res=-1;
        String id = (String)data.get("studentid");
        if(Ss.isinTable("select studentId from student where studentId='"+id+"'",id))
            if(end.equals("certification")||end.equals("CERTIFICATION")){
              //  res =Ss.saveSubData("insert into certification values(?,?,?,?,?"),ut.UUIDGenerator(),name,expire,verification,certifiedBy);
            }else if(end.equals("skills")||end.equals("SKILLS")){
                System.out.println("skills");
                res=-1;
            }else if(end.equals("project")||end.equals("PROJECT")){
                System.out.println("project");
            }else if(end.equals("internship")||end.equals("INTERNSHIP")){
                System.out.println("internship");
                res =Ss.saveSubData("insert into internship values(?,?,?,?,?,?,?)",
                        ut.UUIDGenerator(),(String)data.get("name"),(String)data.get("company"),(String)data.get("startdate"),(String)data.get("enddate"),id,(String)data.get("verification"));

            }
        return new ResponseEntity<>(res==-1?HttpStatus.BAD_REQUEST:HttpStatus.CREATED);
    }
}
