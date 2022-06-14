                                              Database Web Application


    • Technologies used

    1. Core Java
    2. Spring Mvc (Model View Controller)
    3. Hibernate Framework
    4. My Sql
    5. Html Css Js
    6. Jsp And Servlets
    7. Apache Tomcat Server 9.0

    • Aim of project

    • The aim of this project is to create a dynamic Web Application which can show a table of data on the server.
    • This table of data is connected to the database .
    • We can update or delete this data on web application.
    • The operations we perform on the web application is reflected in to database.
    • Suppose we delete a record of customer on the web application then the record of that customer is also deleted on database.
    • Similarly we can update the record of any existing customer or delete any existing customer.
    • This saves a lot of time for us. And we can directly manipulate any data from web application without writing any sql query.

    • Folder Structure
         
    • DatabaseWebApp is the root folder

    • Java Resources/src contains all the necessary packages and classes.

    • WEB-INF is the folder which is required by the server to run web application

    • WEB-INF contains lib which has all necessary libraries and jar files of spring,
      hibernate,my sql. It also contains view folder which has all the files required by the browser to render information on screen like html,jsp.

    •  Spring xml and web xml files contains the comfigurations files for both spring and 
       hibernate. It also contains the deployment descriptor.

    • Resources folder contains the static files like css/js.

    • Servers folder contains the tomcat server configuration files where we will 
      deploy our project.


    • Working

    1. Every request from web browser goes to the CustomerController Class (in the com.myapp.springdemo.controller package). It handles all the incoming       requests from the browser.
       
    2. Now CustomerService class (in the com.myapp.springdemo.service package) is an intermediate layer between CustomerDAO class(in the com.myapp.springdemo.dao package)
       
    3. CustomerDAO class helps to communicate with the database. It creates sessions for us to fetch data 
       from the database. And Hibernate helps to map the Customer class to the database.

    4. Spring MVC helps to create a dynamic form for us and the form data can be binded with the Customer class objects.

    5. Spring also helps us to inject required classes in to other classes.
       

    6. We have used CustomerService class here because in future if we want to add another DAO (Data access objects) 
       then we can simply connect it with CustomerService and we don’t have to write everything again. 

    7. JSP pages are used to view the records of customers on the web browser.It also shows the operations we can perform 
       on this records of customers.
       
    8. Apache Tomcat helps us to run our project on local server. If we enter http://localhost:8080/Database_App/customer/list
       on our browser it will show us a record of customers.
       
     9.Hibernate helps to map Customer Class to the database table.The instance variables of Customer Class maps to columns of the columns of the table 
       in the database. And class maps to table.
      
     10.Any operations like add,update or delete performed on the records of customers in the web browser will be reflected both in the database and
        web browser.   
