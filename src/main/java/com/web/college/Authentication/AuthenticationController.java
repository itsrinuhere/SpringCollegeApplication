package com.web.college.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
//    @GetMapping("{type}/{username}")
//    ResponseEntity<Object> getUser(@PathVariable String type, @PathVariable String username){
//    if(type!=null){
//        if(type.equals("student")){
//            if(username==null){
//                System.out.println("All students ");
//            }else{
//                System.out.println("username  data should respond");
//            }
//        }else if(type.equals("faculty")){
//
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//    }
//    return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//    }
}
