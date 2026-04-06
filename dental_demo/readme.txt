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
