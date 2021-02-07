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

echo [STARTING] Building $imageFullName
(exec "${BASH_SOURCE%/*}/../gradlew" bootJar --no-daemon)

echo [DOCKERIZING] Cretaing Docker Image
docker build -t $imageFullName "${BASH_SOURCE%/*}"
echo [FINISH] Image has been built