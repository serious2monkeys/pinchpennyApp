#!/bin/bash
set -e

imageTag=$1
if [ -z "$1" ]
  then
    echo No image tag provided. Lates will be used
    imageTag=latest
fi

(exec "${BASH_SOURCE%/*}/web-module/pushImage.sh" $imageTag)