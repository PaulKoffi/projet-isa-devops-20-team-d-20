#!/bin/bash

#Preparing environment
cd ../../
mvn -q -DskipTests clean package
cd j2e
echo "Compiling the Drone Delivery system component by component"

echo "BillingComponent"
cd BillingComponent
#mvn -q -DskipTests clean package
cp ./target/BillingComponent.war ../../docker/drone-delivery/.
#mvn clean
cd ..

echo "BillingWebService"
cd BillingWebService
#mvn -q -DskipTests clean package
cp ./target/BillingWebService.war ../../docker/drone-delivery/.
#mvn clean
cd ..

echo "CustomerRegisterComponent"
cd CustomerRegisterComponent
#mvn -q -DskipTests clean package
cp ./target/CustomerRegisterComponent.war ../../docker/drone-delivery/.
#mvn clean
cd ..

echo "DeliveryComponent"
cd DeliveryComponent
#mvn -q -DskipTests clean package
cp ./target/DeliveryComponent.war ../../docker/drone-delivery/.
#mvn clean
cd ..

echo "DeliveryWebService"
cd DeliveryWebService
#mvn -q -DskipTests clean package
cp ./target/DeliveryWebService.war ../../docker/drone-delivery/.
#mvn clean
cd ..

#echo "Entities"
#cd Entities
## mvn -q -DskipTests clean package
#cp ./target/Entities.war ../../docker/drone-delivery/.
## mvn clean
#cd ..

echo "Web"
cd Web
#mvn -q -DskipTests clean package
cp ./target/Web.war ../../docker/drone-delivery/.
#mvn clean
cd ..

echo "Done"
cd ..
mvn clean

# building the docker image
cd docker/drone-delivery/
docker build -t team-d/dd-internal .

# cleaning up the environment
rm -rf BillingComponent.war
rm -rf BillingWebService.war
rm -rf CustomerRegisterComponent.war
rm -rf DeliveryComponent.war
rm -rf DeliveryWebService.war
#rm -rf Entities.war
rm -rf Web.war
