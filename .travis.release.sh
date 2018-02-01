#!/bin/bash

if grep -q "SNAPSHOT" version.sbt
then
    echo ""
else
    rm -rf credentials.properties &&
    rm -rf project/travis-deploy-key &&
    git remote rm origin &&
    git remote add origin git@github.com:QuadStingray/sbt-javafx.git &&
    git fetch origin master &&
    git checkout master &&
    git config remote.origin.fetch +refs/heads/*:refs/remotes/origin/* &&
    git config branch.master.remote origin &&
    git config branch.master.merge refs/heads/master &&
    sbt "release with-defaults" &&
    sbt paradox ghpagesPushSite
fi