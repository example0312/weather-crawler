#!/bin/bash

PID=`ps -ef | grep java | grep weather-crawler | grep -v stop | awk '{print $2}'`
echo "print PID" >> /home/ec2-user/deploy.log
echo $PID >> /home/ec2-user/deploy.log

if [ ! -z "$PID" ]; then
  echo "Process is running."  >> /home/ec2-user/deploy.log
  kill -9 "$PID"
else
  echo "Process is not running." >> /home/ec2-user/deploy.log
fi

ls -al  >> /home/ec2-user/deploy.log
cp target/*.jar /home/ec2-user/.
cd /home/ec2-user

java -jar /home/ec2-user/weather-crawler-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &
ps -ef | grep java  >> /home/ec2-user/deploy.log