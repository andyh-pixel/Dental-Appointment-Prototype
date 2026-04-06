Description: Web application for dental appointment system. Functionality includes book, edit, delete appointments, create accounts and Log in.

Limitations: Login and register are the only ones that are functional with the Database. Booking, editing, canceling are UI only.

How to run:

*** Install ***
Install JDK 1.8
Install maven
Install tomcat 9
***************

*** Database ***
copy dental_demo.db to tomcat9/webapps/db
update the path to database in UserDAOImpl.java
***************

*** Compile ***
Use VS Code tasks (Cmd + Shift + P)
1. Tasks: Run Task
2. Deploy to tomcat
This will compile the project and copy to tomcat folder
See tasks.json under .vscode folder for more info
***************

*** Server ***
To start and stop the Tomcat server:
goto [project folder]/server
Start:
./start.sh
Stop:
./stop.sh
***************

*** Test ***
On a browser (preferably in incognito mode), open the following URL:
http://localhost:8080/dental_demo/index.html
***************


Structure of codebase:

BACK-END:

  Package/Controller:
  
    BookingServlet.java
    LoginServlet.java
    RegisterServlet.java
  Package Model:
  
    Appointment.java
    DataStore.java
    User.java
  Package dao (Data access object):
  
    UserDAO.java
    UserDAOImpl.java
  Package Service:
  
    BookingService.java
FRONT-END:

src/main/webapp

    index.html
  
    login.html
  
    register.html
  
    edit.html
  
    book.html

    success.html
  
src/main/webapp

  Package WEB-INF
  
    web.xml
