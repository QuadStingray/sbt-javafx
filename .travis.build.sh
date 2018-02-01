#!/bin/bash

if grep -q "SNAPSHOT" version.sbt
then
    echo ""
else
    rm -rf credentials.properties && git checkout master && sbt "release with-defaults" && sbt paradox ghpagesPushSite
fi