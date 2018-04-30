FROM tomcat:8.5-alpine

COPY target/*.war /usr/local/tomcat/webapps/