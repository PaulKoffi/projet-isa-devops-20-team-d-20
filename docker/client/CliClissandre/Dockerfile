FROM openjdk:8
MAINTAINER djotiham (drone delivery isa-devops 2020)

# Loading the executable server inside the image
COPY ./CliClissandre-1.0-SNAPSHOT-jar-with-dependencies.jar ./dd-client-CliClissandre.jar

# Mounting a local directory to support file loading in the shell
VOLUME /host-clissandre

# Running the client using the starting shell script
ENTRYPOINT ["java", "-jar", "./dd-client-CliClissandre.jar"]

# Default arguments to be forwarded to the entry point
CMD ["localhost", "8083"]
