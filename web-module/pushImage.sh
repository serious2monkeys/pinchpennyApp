#!/bin/bash
set -e

imageTag=$1
if [ -z "$1" ]
  then
    echo No image tag provided. Lates will be used
    imageTag=latest
fi

repositoryName=390013698277.dkr.ecr.eu-north-1.amazonaws.com/pinchpenny
imageFullName=$repositoryName:$imageTag

echo [START] pushing image $imageFullName
docker push $imageFullName

echo [FINISH] image $imageFullName pushed