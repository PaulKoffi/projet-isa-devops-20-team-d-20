#!/bin/bash

#Preparing environment
cd ../../j2eSubmodules/Web
echo "Compiling the Drone Delivery system Web component"
mvn -q -DskipTests clean package
cp ./target/Web.war ../../docker/drone-delivery/.
mvn clean
echo "Done"

# building the docker image
cd ../../docker/drone-delivery/
docker build -t team-d/dd-internal .

# cleaning up the environment
rm -rf Web.war
