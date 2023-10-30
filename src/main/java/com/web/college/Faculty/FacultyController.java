package com.web.college.Faculty;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("api")
public class FacultyController {
    @Autowired
    FacultyService fs;
    @PostMapping("faculty")
    ResponseEntity<Object> saveFaculty(@RequestBody HashMap<String,Object> data){
        return new ResponseEntity<>(fs.saveFaculty(data)==1?HttpStatus.CREATED:HttpStatus.NO_CONTENT);
    }
    @PostMapping("faculty/{id}")
    ResponseEntity<Object> saveSubFaculty(@RequestBody HashMap<String,Object> map, @PathVariable String id){
        int res = -1;
        if(map.get("userid")!=null && fs.isFacultyInTable((String)map.get("userid"))){
            try{
                switch (id) {
                    case "social" -> {
                        res = fs.saveSocialLinks(map);
                    }
                    case "recent" -> {
                        res = fs.saveResearchPapers(map);
                    }
                    case "experience" -> {
                        res=fs.saveExperience(map);//tested
                    }
                    default->{
                        return  new ResponseEntity<>("URL undefined",HttpStatus.BAD_REQUEST);
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
            return new ResponseEntity<>(res==1?HttpStatus.CREATED:HttpStatus.CONFLICT);
        }else{
            return  new ResponseEntity<>("{msg:'userid required'}",HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/faculty")
    ResponseEntity<Object> getAllFaculty() {
        fs.getAllFaculty();
        return new ResponseEntity<>( fs.getAllFaculty(),HttpStatus.OK);
    }
    @GetMapping("/faculty/{id}")
    ResponseEntity<Object> getsFacultyData(@PathVariable String id){
        String sql ="select * from ";
        switch(id){
            case "social"->{
                sql+="sociallinks";
            }case "experience"->{
                sql+="experience";
            }case "recent"->{
                sql+="recenteducation";
            }default -> {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        return new ResponseEntity<>(fs.getAllSubData(sql),HttpStatus.OK);
    }
    @GetMapping("/faculty/{id}/{userid}")
    ResponseEntity<Object> getFacultyDataByI(@PathVariable String id,@PathVariable String userid,@Nullable @RequestParam String q){
        if(q==null&&userid!=null && fs.isFacultyInTable(userid)){
            String sql ="select * from ";
            switch(id){
                case "social"->{
                    sql+="sociallinks where userid=?";
                }case "experience"->{
                    sql+="experience where userid =?";
                }case "recent"->{
                    sql+="recenteducation where userid=?";
                }default -> {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            return new ResponseEntity<>(fs.getData(sql,userid),HttpStatus.OK);
        }else if(q!=null&&userid!=null && fs.isFacultyInTable(userid)){//tested by warnings casting required
            String sql ="select * from ";
            switch(id){
                case "social"->{
                    sql+="sociallinks where userid=? and socialid=?";
                }case "experience"->{
                    sql+="experience where userid =? and experienceid=?";
                }case "recent"->{
                    sql+="recenteducation where userid=? and recentid=?";
                }default -> {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            return new ResponseEntity<>(fs.getData(sql,userid,q),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}