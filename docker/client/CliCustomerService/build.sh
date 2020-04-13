#!/bin/bash

#Preparing environment
cd ../../../clientSubmodules/CliCustomerService
echo "Compiling the customer service client system"
mvn -q -DskipTests clean package assembly:single
echo "Done"
cp ./target/CliCustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar ../../docker/client/CliCustomerService/.
mvn clean

# building the docker image
cd ../../docker/client/CliCustomerService/
docker build -t team-d/dd-client-customer-service .

# cleaning up the environment
rm -rf CliCustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar
