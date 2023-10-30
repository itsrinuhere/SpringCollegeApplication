package com.web.college.Student;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService Ss;
    @PostMapping()
    ResponseEntity<Object> saveNewStudent(@RequestBody HashMap<String,Object> map){
    int res = Ss.saveStudent(map);
    return new ResponseEntity<>(res==-1? HttpStatus.CONFLICT:HttpStatus.CREATED);
    }
    @GetMapping()
    ResponseEntity<Object> getData(@RequestParam("id") String id ,@RequestParam("q") String q) {
        HashMap<String,Object> data = null;
        if(id != null) {
            data = (HashMap<String, Object>) Ss.get("",id);

        }
        else if(q!=null){
            if(q.equals("cgpa") || q.equals("CGPA")){
                data = (HashMap<String, Object>) Ss.get("");
            }

        }
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
//    ResponseEntity<Object> ViewStudents(){
//        return null;
//    }
//    ResponseEntity<Object> modifyStudentById(@RequestParam("id") String id){
//        return null;
//    }
//    ResponseEntity<Object> deleteStudentById(@RequestParam("id") String id){
//        return null;
//    }
//    ResponseEntity<Object> GetTotalStudentDataById(@RequestParam("id") String id){
//        return null;
//    }
}
