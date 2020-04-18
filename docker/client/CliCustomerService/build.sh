#!/bin/bash

#Preparing environment
cd ../../../client/CliCustomerService
echo "Compiling the customer service client system"
mvn -q -DskipTests clean package assembly:single
echo "Done"
cp ./target/CliCustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar ../../docker/client/CliCustomerService/.
mvn clean

# building the docker image
cd ../../docker/client/CliCustomerService/
docker build -t djotiham/dd-client-customer-service .
# to remove old images
docker rmi $(docker images -qa -f 'dangling=true')

# cleaning up the environment
rm -rf CliCustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar
