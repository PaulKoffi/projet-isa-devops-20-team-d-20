#!/bin/bash

# the image will be removed when stopped
#other linux
docker run --rm -it -v `pwd`:/host-customer-service team-d/dd-client-customer-service
#on windows ?
#docker run --rm -it -v "pwd":/host team-d/dd-client-customer-service

# ^C to stop
