FROM openjdk:8
MAINTAINER djotiham (drone delivery isa-devops 2020)

# Loading the executable server inside the image
COPY ./CliCustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar ./dd-client-CliCustomerService.jar

# Mounting a local directory to support file loading in the shell
VOLUME /host-customer-service

# Running the client using the starting shell script
ENTRYPOINT ["java", "-jar", "./dd-client-CliCustomerService.jar"]

# Default arguments to be forwarded to the entry point
CMD ["localhost", "8000"]
