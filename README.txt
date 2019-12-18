README


1. Pagination
Pagination is work for all get method except those with uniqueResult. 
Example: 
url: localhost:8080/patients?page=1&size=2
NOTE: 
*	page: the current page
	size: the number of items are displayed
* If the employee dont set page and size, the system will auto set it to the default: page = 1 and size = 100

2.WORKFLOW FOR ADDING DATA: patient -> drug -> visitlog -> prescription

3.Patient API

a. Add Patient
url: localhost:8080/patients
method:POST
payload:
{
	"name": "Thanh",
	"gender": "Male",
	"birthday": "1997-06-26",
	"address": "702 Nguyen Van Linh"
}

b. Update Patient
url:localhost:8080/patients/update/1
method: PUT
payload:
{
	"name": "Nga",
	"gender": "Female",
	"birthday": "1997-06-26",
	"address": "702 Nguyen Van Linh"
}

c. Get All Patient
url: localhost:8080/patients
method: GET
payload:

d. Find Patient by ID
url: localhost:8080/patients/searchByID/1
method:GET
payload:

e. Find Patient bt Name
url: localhost:8080/patients/searchByName/Nga
method:GET
payload:

d. Find Patient by Birthday
url: localhost:8080/patients/searchByBirthday/1997-06-26
method:GET
payload:


4. Drug
a. Add Drug
url: localhost:8080/drugs
method: POST
payload: 
{	
	"name" : "Acetaminophen",
	"usage": "fever reducer"
}

b. Update Drug
url: localhost:8080/drugs/update/1
method: PUT
payload: 
{	
	"name" : "Acetaminophen numb0",
	"usage": "fever reducer"
}


c. Get All Drug
url:localhost:8080/drugs
method: GET
payload:

d. Get Drug By ID
url:localhost:8080/drugs/searchByID/1
method: GET
payload:

e. Get Drug by Name
url:localhost:8080/drugs/searchByName/Ace
method: GET
payload:

5.VisitLog

a. 
* Add Visit with New Patient
url: localhost:8080/visits
method:POST
payload:
{
	"visitDate": "2020-06-29",
	"visitTime": "02:12:00",
	"patient": {
		"name": "Long",
		"gender": "Male",
		"birthday": "2000-05-24",
		"address": "23 Nguyen Van Linh"
	},
	"information":"headache, fever",
	"doctor": "Dr. Thanh"
}

*Add Visit with Returning Patient
url: localhost:8080/visits
method: POST
payload: 
{
	"visitDate": "1999-06-15",
	"visitTime": "02:12:00",
	"patient": {
		"id": 1
	},
	"information":"toothache",
	"doctor": "Dr.Thanh"
}

b. Get All Visit
url:localhost:8080/visits
method:GET
payload: 

c. Search By Date
url:localhost:8080/visits/searchByDate/1999-06-15
method: GET
payload: 

d. Search by ID
url:localhost:8080/visits/searchByID/1
method: GET
payload: 



f. Search By Patient ID
url:localhost:8080/visits/searchByPatientID/1
method: GET
payload: 

6. Prescription
a. Add Prescription
url:localhost:8080/prescription
method:POST
payload: 
{	
	"name": "Presciption",
	"prescribedDrugs":[
	{
		"dose": "3 per day",
		"instruction": "after meal",
		"drug":{
			"id": 1
		},
		"quantity": 12
	},
	{
		"dose": "2 per day",
		"instruction": "before meal",
		"drug":{
			"id": 2
		},
		"quantity": 20
	}],
	"visitLog":{
		"id": 1
	}
}

b. Get All Prescription
url:localhost:8080/prescription
method: GET
payload: 

c. Get Prescription by ID
url:localhost:8080/visits/searchByID/1
method:GET
payload: 


d. Get Prescription by Patient ID
url: localhost:8080/prescription/searchByPatientID/1
method: GET
payload: 

7. Prescribed Drug
a. Get All Prescribed Drug
url: localhost:8080/prescribedDrug
method: GET
payload:

b. Get Prescribed Drug by ID
url: localhost:8080/prescribedDrug/searchByID/1
method: GET
payload:

c. Update Prescribed Drug
url: localhost:8080/prescribedDrug/update/1
method: PUT
payload: 
{
	"dose": "2 per day",
	"instruction": "after meal",
    "quantity": 12,
    "drug": {
    	"id": 1
    }
}

