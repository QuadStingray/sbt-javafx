#!/bin/bash

BINTRAY_FILE=$TRAVIS_BUILD_DIR/credentials.properties
cat <<EOF >$BINTRAY_FILE
realm = Bintray API Realm
host = api.bintray.com
user = $BINTRAY_USER
password = $BINTRAY_PASSWORD
EOF

if grep -q "SNAPSHOT" version.sbt
then
    echo ""
else
    rm -rf credentials.properties && git remote rm origin && git remote add git@github.com:QuadStingray/sbt-javafx.git && git checkout master && sbt "release with-defaults" && sbt paradox ghpagesPushSite
fi