#!/bin/sh

cd ${0%/*}/src

javac remote/*.java -d ../bin
