FROM openjdk:1.8
EXPOSE 8200
ADD target/authentication_aws.jar authentication_aws.jar
ENTRYPOINT ["java","-jar","/authentication_aws.jar"]