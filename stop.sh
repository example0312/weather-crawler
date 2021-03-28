#!/bin/bash
PID=`ps -ef | grep java | grep weather-crawler | awk '{print $2}'`

if [ ! -z "$PID" ]
then
    kill -9 $PID > /dev/null 2> /dev/null < /dev/null
fi

exit 0