#!/bin/bash

## >>>>> Building CLIs and Drone Delivery System <<<<<
## As you can see, we have a pom.xml file at the root of this project. It's the parent pom and it contains references
## to the 2 maven projects parts of our architecture : CLIs and drone delivery system
mvn clean package

## >>>>> Building the external partner .Net system <<<<<
cd partners/DotNet
./compile.sh
cd ../..

## >>>>> Building all docker images <<<<<
## As you can see, we have a directory named docker at the root of this project. It contains all docker scripts to build
## docker images of the 3 parts of our architecture : CLIs, drone delivery system, and the dotNet partner
cd docker
## CLIs
cd client/CliClissandre
sh build.sh
cd ../CliCustomerService
sh build.sh
cd ../..
## Drone Delivery System
cd drone-delivery
sh build.sh
cd ..
## Partner dotNet system
cd partners
sh build.sh
cd ../..



