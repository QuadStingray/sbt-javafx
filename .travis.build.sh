#!/bin/bash
git config user.name "Travis CI"
git config user.email "github_travis@quadstingray.com"

if grep -q "SNAPSHOT" version.sbt
then
    sbt paradox ghpagesPushSite
else
    sbt ^publish
    rm -rf credentials.properties
    sbt "release with-defaults"
    sbt paradox ghpagesPushSite
fi