#!/bin/bash
mkdir ~/.bintray/
BINTRAY_FILE=$TRAVIS_BUILD_DIR/credentials.properties
cat <<EOF >$BINTRAY_FILE
realm = Bintray API Realm
host = api.bintray.com
user = $BINTRAY_USER
password = $BINTRAY_PASSWORD
EOF
