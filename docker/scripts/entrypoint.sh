#!/bin/bash

/opt/jdk-11.0.2/bin/java -Dspring.profiles.active="$APP_PROFILE" -jar /opt/simplecrud-spring/target/simplecrud-0.0.1-SNAPSHOT.jar 