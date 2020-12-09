# Technologies:

-Developed using Java with Spring Framework\
-Mysql Database vs 8.0.21\
-Web Server: TomCat\
-IDE:Spring Tool Suite 4/Eclipse 

# Tests with de API

## 1. Healthcare Institution Register:
Method: POST\
URL: //HOST/healthcareinstitution/register\
JSON:\
              {   "name" : "Hostipal Base of California",\
                  "cnpj": "29102078000107"\
              } 

## 2. Exam Register
Method: POST\
URL: //HOST/exam/register \
JSON: \
      {    
          "patientName" : "AnonYXYZW123456",\
          "patientAge": "40",\
          "healthcareInstitution": {\
              "id": 4\
          }, 
          "patientGender": "N",\
          "physicianName": "Dr. Octopus",\
          "physicianCrm": "111111-11",\
          "procedureName": "Exam @"\
      } 


## 3. Exam Update
Method: PUT\
URL: //HOST/exam/update/idExam (Substitute idExam by the exacly id of the Exam that will be updated) \
JSON:\
        {   
            "patientName" : "Patient Updated - X", \
            "patientAge": "20",\
            "healthcareInstitution": { \
                "id": 4\
            }, 
            "patientGender": "F",\
            "physicianName": "Dr. Test Y",\
            "physicianCrm": "0000000000000",\
            "procedureName": "Exam Hemoglobin"\
        } 
        
        

## 4. Exam Remove
Method: DELETE\
URL: //HOST/exam/remove/idExam (Substitute idExam by the exacly id of the Exam that will be removed) 


## 5. Find Exam
Method: GET\
URL: //HOST/exam/find/idHealthcareInstitution/idExam (Substitue idHealthcareInstitution by the id of the HealthcareInstitution that is requiring the exam, and\
     change the idExam with the exacly id of them Exam that you need to retrieve)
     


#### P.S.: The database tables created are availabe inside the project, specifically in: ../resources/db/migration/*.sql. 
#### When the project is executed for the first time, the database will be automatically created by Flyway.
#### The Software Postman Client was used to executed the tests with the developed REST API.
