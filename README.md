# spring-rest-db-demo
Demo app using spring, exposing simple rest service and saving/reading stuff to db

Build:
mvn clean package

Builds as WAR. Needs to be deployed on tomcat
Requires environmental variable 
DEMO_PROPS=path/to/property/directory

Eg. 
DEMO_PROPS=C:\var\props
It looks for 
"file:${DEMO_PROPS}/demo.properties"
file.
