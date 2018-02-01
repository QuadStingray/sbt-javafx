#!/bin/bash

if grep -q "SNAPSHOT" version.sbt
then
    echo ""
else
    rm -rf credentials.properties && git remote rm origin && git remote add git@github.com:QuadStingray/sbt-javafx.git && git checkout master && sbt "release with-defaults" && sbt paradox ghpagesPushSite
fi