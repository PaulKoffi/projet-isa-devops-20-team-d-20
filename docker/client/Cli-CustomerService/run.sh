#!/bin/bash

# the image will be removed when stopped
#other systems
#docker run --rm -it -v `pwd`:/host team-d/dd-client-customer-service
#on windows
docker run --rm -it -v "pwd":/host team-d/dd-client-customer-service

# ^C to stop
