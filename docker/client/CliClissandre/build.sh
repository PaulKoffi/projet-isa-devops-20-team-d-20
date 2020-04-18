#!/bin/bash

#Preparing environment
cd ../../../client/CliClissandre
echo "Compiling the customer service client system"
mvn -q -DskipTests clean package assembly:single
echo "Done"
cp ./target/CliClissandre-1.0-SNAPSHOT-jar-with-dependencies.jar ../../docker/client/CliClissandre/.
mvn clean

# building the docker image
cd ../../docker/client/CliClissandre/
docker build -t djotiham/dd-client-clissandre .
# to remove old images
docker rmi $(docker images -qa -f 'dangling=true')

# cleaning up the environment
rm -rf CliClissandre-1.0-SNAPSHOT-jar-with-dependencies.jar
