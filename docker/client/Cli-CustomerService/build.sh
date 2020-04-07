#!/bin/bash

#Preparing environment
cd ../../../client/Cli-CustomerService
echo "Compiling the customer service client system"
mvn -q -DskipTests clean package assembly:single
echo "Done"
cp ./target/Cli-CustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar ../../docker/client/Cli-CustomerService/.
mvn clean

# building the docker image
cd ../../docker/client/Cli-CustomerService/
docker build -t team-d/dd-client-customer-service .

# cleaning up the environment
rm -rf Cli-CustomerService-1.0-SNAPSHOT-jar-with-dependencies.jar
