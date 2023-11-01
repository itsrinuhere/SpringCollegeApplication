#  To Action for the Repository usage
 To clone the Repository
```shell
git clone https://github.com/itsrinuhere/SpringCollegeApplication

```
To pull the Repository
```shell
git pull origin master

```
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
13. `http://localhost:8080/api/student/certification` METHOD= POST tested success
   ```json
{
    "studentid":"19641a05m8",
    "name":"cloud certification",
    "expire":"2/2/2021",
    "verification":"https://google.com",
    "certify":"google.inc"
}
  ```
expire require date or null;
14. `http://localhost:8080/api/student/internship` METHOD = POST tested success
  ```json
{
  "studentid":"19641a05m8",
  "name":"Marketing interntest1",
  "company":"google",
  "startdate":"23/9/2021",
  "enddate":"23/09/2021",
  "verification":"http://google.com"
}

```
Date format should DD/MM/YYYY and id should be registered 
15. `http://localhost:8080/api/student/i/internship/uniqueId` method=delete
16. `http://localhost:8080/api/student/project` Method = post tested success
  ```json
{
  "studentid":"19641a05m8",
  "tags":"cloud, certification",
  "description":"xyzxyz",
  "url":"https://google.com",
  "verification":"google.inc"
}
```
17. `http://localhost:8080/api/student/skill` method =POST
18. `` method post
  ```json
{
  
}
```
To Upload a certificate file :
- firebase object upload

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