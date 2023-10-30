# EndPoints
## Student Endpoints
1. `http://localhost:8080/api/student` method Get
2. `http://localhost:8080/api/student` Method Post
  ``` json
    {
      'studentid':'#',
      name:'',
      batch:'',
      emailId:'',
      mobile:''
      ''
    }
```
4. `http://localhost:8080/api/student?q=skills` method=get
5. `http://localhost:8080/api/student?q=certification` method=get 
6. `http://localhost:8080/api/student?q=internship ` Method GET
7. `http://localhost:8080/api/student?q=internship&filter=domain` Method = GET domains
8. `http://localhost:8080/api/student/{id}` method GET
9. `http://localhost:8080/api/student/{id}` method DELETE 
10. `http://localhost:8080/api/student?q=project` method GET by
11. `http://localhost:8080/api/student?q=project&filter=domain` Method GET
12. `http://localhost:8080/api/student/certification` METHOD= POST
   ```json
      {}
  ```
13. `http://localhost:8080/api/student/internship` METHOD = POST
14. `http://localhost:8080/api/student/i/internship/uniqueId` method=delete
15. `http://localhost:8080/api/student/project` Method = post
16. `http://localhost:8080/api/student/skills` method =POST
### project table
- > uniqueId primary key Id
- > studentId
- > Description
- > Tags
- > URL
- > verification uri
### Skills Table
- > uniqueId
- > StudentId
-  > Skill
 - > Domain
  
### Certifications table
- > uniqueId
- > name
- > expire
- > verification
- > certifiedBy

### Internship
- > uniqueId
- > name
- > company
  > start date
  > End date
  > url
