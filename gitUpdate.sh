#!/bin/bash

## This script consists to fully update the project from root to all sub-modules
## simple update
git pull
## update all submodules
git submodule update --init --recursive
## checkout every submodule to branch master
## >>>>> CLIs <<<<<
cd client
## Clissandre
cd CliClissandre
git checkout master
git pull
cd ..
## Customer Service
cd CliCustomerService
git checkout master
git pull
cd ..

## >>>>> Drone Delivery <<<<<
cd ../drone-delivery
## BillingComponent
cd BillingComponent
git checkout master
git pull
cd ..
## BillingWebservice
cd BillingWebservice
git checkout master
git pull
cd ..

