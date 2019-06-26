#!/usr/bin/env bash
#/bin/bash

exec java -jar app.jar \
--spring.profiles.active=pro \
--mysql.host=${MYSQL_HOST} \
