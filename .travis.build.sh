#!/bin/bash

if grep -q "SNAPSHOT" version.sbt
then
    sbt paradox ghpagesPushSite
else
    sbt ^publish
    rm -rf credentials.properties
    git checkout master
    sbt "release with-defaults"
    sbt paradox ghpagesPushSite
fi