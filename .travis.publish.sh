#!/bin/bash

if [[ "$BRANCH" != "master" ]]; then
  echo 'Nothing to do';
else
  if grep -q "SNAPSHOT" version.sbt
  then
      echo 'Nothing to do';
  else
      sbt -Dbintray.user=$BINTRAY_USER -Dbintray.pass=$BINTRAY_PASSWORD ^publish
  fi
fi