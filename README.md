 # Customer Manangement System Backend Api's 
 
  Apis are developed using Java Spring Web ,Spring Boot, Maven ,JPA and Hibernate(H2) using Embedded Apache tomcat for   server environment and tested with postman. 

 Rest API's --->> Endpoints : 

1.) To retrieve the details of the customers stored in Db.

    GET : localhost:8080/customerapis/getcustomers

2.) To save the details of new customer in the Db.  

    POST : localhost:8080/customerapis/addcustomer
    
3.) To update the details of the customer already present in Db.

    PUT : localhost:8080/customerapis/updatecustomer/{id} -->id(int) of customer to be passed with updated JSON                 requestbody.
    
4.) To remove the details of the customer from Db.  

    DELETE : localhost:8080/customerapis/deletecustomer/{id} --->> id(int) of customer to be passed who is to be                    removed from Db.   


 Tomcat default port listening on : 8080


