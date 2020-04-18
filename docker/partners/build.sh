#!/bin/bash

#Preparing environment
cd ../../partners/DotNet
./compile.sh
cp ./server.exe ../../docker/partners/.

# building the docker image
cd ../../docker/partners/
docker build -t djotiham/dd-external .
# to remove old images
docker rmi $(docker images -qa -f 'dangling=true')

# cleaning up the environment
rm -rf server.exe
cd ../../partners/DotNet
rm server.exe
