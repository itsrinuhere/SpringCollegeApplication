# EndPoints
## Student Endpoints
1. `http://localhost:8080/api/student` method Get,Testing status: succesfull Response code 200
2. `http://localhost:8080/api/student` Method Post ,Testing status :success Response code 200
  ``` json
    {
        "studentid": "19641a05m5",
        "name": "srinivas2",
        "batch": "2019-2023",
        "emailid": "itsrinuhere1@1.com",
        "mobile": "7780294796"  
    }
```
4. `http://localhost:8080/api/student/skills` method=get , testing : success
5. `http://localhost:8080/api/student/certification` method=get testing : success
6. `http://localhost:8080/api/student/internship ` Method GET testing : success
7. `http://localhost:8080/api/student/project` Method Get testing :success
8. `http://localhost:8080/api/student?q=internship&filter=domain` Method = GET domains
9. `http://localhost:8080/api/student/{id}` method GET
10. `http://localhost:8080/api/student/{id}` method DELETE 
11. `http://localhost:8080/api/student?q=project` method GET by
12. `http://localhost:8080/api/student?q=project&filter=domain` Method GET
13. `http://localhost:8080/api/student/certification` METHOD= POST
   ```json
{
    "studentid":"19641a05m8",
    "name":"",
    "company":"",
    "startdate":"",
    "enddate":"",
    "verification":"http://google.com"
}

  ```
14. `http://localhost:8080/api/student/internship` METHOD = POST
  ```json
{
  
}
```
15. `http://localhost:8080/api/student/i/internship/uniqueId` method=delete
16. `http://localhost:8080/api/student/project` Method = post
  ```json
{
  
}
```
17. `http://localhost:8080/api/student/skills` method =POST
18. `` method post
  ```json
{
  
}
```


# Schemas of Student
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


# Faculty Service

## Endpoints of Faculty

- Endpoint 1
  - `http://localhost:8080/api/faculty' Method :GET
    Response