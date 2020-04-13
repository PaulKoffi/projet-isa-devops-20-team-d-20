#!/bin/bash

# the image will be removed when stopped
docker run --rm -it -v `pwd`:/host-clissandre team-d/dd-client-clissandre

# ^C to stop
