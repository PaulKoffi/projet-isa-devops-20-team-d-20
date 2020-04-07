#!/bin/bash

# step #1: configure the bank.propoerties file
mkdir -p ./WEB-INF/classes/
touch ./WEB-INF/classes/bank.properties
echo "bankHostName=$bank_host" >> ./WEB-INF/classes/bank.properties
echo "bankPortNumber=$bank_port" >> ./WEB-INF/classes/bank.properties

# step #2: update the webapp to load the right properties
jar uvf ./webapps/BillingComponent.war ./WEB-INF/classes/bank.properties
jar uvf ./webapps/BillingWebService.war ./WEB-INF/classes/bank.properties
jar uvf ./webapps/CustomerRegisterComponent.war ./WEB-INF/classes/bank.properties
jar uvf ./webapps/DeliveryComponent.war ./WEB-INF/classes/bank.properties
jar uvf ./webapps/DeliveryWebService.war ./WEB-INF/classes/bank.properties
jar uvf ./webapps/Web.war ./WEB-INF/classes/bank.properties

# step #3: start the TomEE engine
catalina.sh run
