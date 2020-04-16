#!/bin/bash

# the image will be removed when stopped
docker run --rm -it -v `pwd`:/host-clissandre djotiham/dd-client-clissandre

# ^C to stop
