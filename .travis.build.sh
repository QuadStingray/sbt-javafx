#!/bin/bash

if grep -q "SNAPSHOT" version.sbt
then
    sbt paradox
else
    sbt ^publish
    rm -rf credentials.properties
    sbt release with-defaults
fi

# sbt ^publish

# sbt release with-defaults