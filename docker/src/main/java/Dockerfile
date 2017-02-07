FROM openjdk:8-jre
WORKDIR /home/NextGear
EXPOSE 8080
COPY *.war ./
RUN bash -xec 'touch *.war; ln -s *.war NSR.war'
CMD ["java","-jar","NSR.war"]
