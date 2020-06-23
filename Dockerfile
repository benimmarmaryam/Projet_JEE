FROM tomcat:9.0
VOLUME /tmp
MAINTAINER xyz
COPY build/Projet_JEE.war /usr/local/tomcat/webapps/Projet_JEE.war
CMD ["catalina.sh", "run"]

