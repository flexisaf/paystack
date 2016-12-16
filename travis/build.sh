#!/bin/bash
jdk_switcher use oraclejdk8
if [[ $TRAVIS_BRANCH == 'master' ]]
  ./gradlew clean check test publish
else
  ./gradlew clean check test
fi