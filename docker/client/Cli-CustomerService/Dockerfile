FROM openjdk:8
MAINTAINER team-d (drone delivery isa-devops 2020)

# Loading the executable server inside the image
COPY ./Cli-CustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar ./dd-client-CustomerService.jar

# Mounting a local directory to support file loading in the shell
VOLUME /host

# Running the client using the starting shell script
ENTRYPOINT ["java", "-jar", "./dd-client-CustomerService.jar"]

# Default arguments to be forwarded to the entry point
CMD ["localhost", "8080"]
