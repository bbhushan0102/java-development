#!/bin/bash
# (see https://github.com/microsoft/mssql-docker/issues/2 )
echo "Container initialisation: waiting for the server to come up"
while [ ! -f /var/opt/mssql/log/errorlog ]
do
  sleep 1
done
FOUND=0
i=0
while [[ $FOUND -ne 1 ]] && [[ $i -lt 60 ]]; do
  i=$i+1
  FOUND=$(grep -cim1 "Service Broker manager has started" /var/opt/mssql/log/errorlog)
  if [[ $FOUND -ne 1 ]]; then
    sleep 1
  fi
done
if [[ $FOUND -ne 1 ]]; then
  echo "Container initialisation: Error: waited for more than 60 seconds for the server to start. Trying to create the database now..."
fi

echo "Container initialisation: creating the database if needed"

# Added pause to deal with timing issue on startup
sleep 10;

# Run the setup script to create the DB and the schema in the DB
/opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P $MSSQL_SA_PASSWORD -i setup.sql

echo "Container initialisation: done"

