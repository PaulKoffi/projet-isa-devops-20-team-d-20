#!/bin/bash

## This script consists to fully update the project from root to all sub-modules
## simple update
echo "Updating root project"
git pull
## update all submodules
echo "Updating submodules"
git submodule update --init --recursive
## checkout every submodule to branch master
## >>>>> CLIs <<<<<
cd client
## Clissandre
echo "Checkout Clissandre on branch Master"
cd CliClissandre
git checkout master
git pull
cd ..
## Customer Service
echo "Checkout CliCustomerService on branch Master"
cd CliCustomerService
git checkout master
git pull
cd ..

## >>>>> Drone Delivery <<<<<
cd ../drone-delivery
## BillingComponent
echo "Checkout BillingComponent on branch Master"
cd BillingComponent
git checkout master
git pull
cd ..
## BillingWebservice
echo "Checkout BillingWebservice on branch Master"
cd BillingWebservice
git checkout master
git pull
cd ..
## CustomerRegisterComponent
echo "Checkout CustomerRegisterComponent on branch Master"
cd CustomerRegisterComponent
git checkout master
git pull
cd ..
## CustomerRegisterWebService
echo "Checkout CustomerRegisterWebService on branch Master"
cd CustomerRegisterWebService
git checkout master
git pull
cd ..
## DeliveryComponent
echo "Checkout DeliveryComponent on branch Master"
cd DeliveryComponent
git checkout master
git pull
cd ..
## DeliveryWebService
echo "Checkout DeliveryWebService on branch Master"
cd DeliveryWebService
git checkout master
git pull
cd ..
## DroneManagementComponent
echo "Checkout DroneManagementComponent on branch Master"
cd DroneManagementComponent
git checkout master
git pull
cd ..
## DroneWebService
echo "Checkout DroneWebService on branch Master"
cd DroneWebService
git checkout master
git pull
cd ..
## Entities
echo "Checkout Entities on branch Master"
cd Entities
git checkout master
git pull
cd ..
## PackageRegisterComponent
echo "Checkout PackageRegisterComponent on branch Master"
cd PackageRegisterComponent
git checkout master
git pull
cd ..
## PackageRegisterWebService
echo "Checkout PackageRegisterWebService on branch Master"
cd PackageRegisterWebService
git checkout master
git pull
cd ..
## PlanningComponent
echo "Checkout PlanningComponent on branch Master"
cd PlanningComponent
git checkout master
git pull
cd ..
## PlanningWebService
echo "Checkout PlanningWebService on branch Master"
cd PlanningWebService
git checkout master
git pull
cd ..
## ProviderRegisterComponent
echo "Checkout ProviderRegisterComponent on branch Master"
cd ProviderRegisterComponent
git checkout master
git pull
cd ..
## ProviderRegisterWebService
echo "Checkout ProviderRegisterWebService on branch Master"
cd ProviderRegisterWebService
git checkout master
git pull
cd ..
## Web
echo "Checkout Web on branch Master"
cd Web
git checkout master
git pull
cd ..

## >>>>> DotNet <<<<<
cd ../partners
## DotNet
echo "Checkout DotNet on branch Master"
cd DotNet
git checkout master
git pull
cd ..

## >>>>> Integration Tests <<<<<
cd ../integration-tests
## IntegrationTestsComponent
echo "Checkout IntegrationTestsComponent on branch Master"
cd IntegrationTestsComponent
git checkout master
git pull
cd ..
## IntegrationTestsComponent
echo "Checkout droneDelivery-IntegrationTests on branch Master"
cd droneDelivery-IntegrationTests
git checkout master
git pull
cd ..

echo "Done"
read -n 1 -s -r -p "Press any key to continue"

