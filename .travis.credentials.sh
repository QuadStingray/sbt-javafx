#!/bin/bash
BINTRAY_FILE=~/.bintray/.credentials
cat <<EOF >$BINTRAY_FILE
realm = Bintray API Realm
host = api.bintray.com
user = $BINTRAY_USER
password = $BINTRAY_PASSWORD
EOF
