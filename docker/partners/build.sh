#!/bin/bash

#Preparing environment
cd ../../dotNet
./compile.sh
cp ./server.exe ../docker/partners/.

# building the docker image
cd ../docker/partners/
docker build -t djotiham/dd-external .

# cleaning up the environment
rm -rf server.exe
cd ../../dotNet
rm server.exe
