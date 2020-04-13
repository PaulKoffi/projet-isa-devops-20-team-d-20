#!/bin/bash

#Preparing environment
cd ../../
mvn -q -DskipTests clean package
cd j2eSubmodules
echo "Compiling the Drone Delivery system component by component"

echo "Web"
cd Web
mvn -q -DskipTests clean package
cp ./target/Web.war ../../docker/drone-delivery/.
mvn clean
cd ..

echo "Done"
cd ..

# building the docker image
cd docker/drone-delivery/
docker build -t team-d/dd-internal .

# cleaning up the environment
rm -rf Web.war
