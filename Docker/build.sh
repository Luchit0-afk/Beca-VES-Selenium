#!/bin/bash

docker build -t "jmeter/docker:5.2.1" .
docker pull selenium/standalone-chrome
