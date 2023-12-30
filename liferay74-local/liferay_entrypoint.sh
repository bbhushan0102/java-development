#!/usr/bin/env bash
#
# This script extends Liferay's Docker entryoint and provides a way to execute
# additional actions prior to calling Liferay's own entrypoint
#
# Author: Chris Newton 
# Date: 30/09/2020
#

function wait_and_deploy {

	local TMP_DEPLOY_DIR=/tmp/liferay/deploy

	if [ "$(ls -A $TMP_DEPLOY_DIR)" ]; then

		echo "$(date +%T) Files found in $TMP_DEPLOY_DIR. Waiting for Liferay to startup before deploying"

		until $(curl --fail --head --output /dev/null --silent http://localhost:8080); do
			sleep 5;
		done

		echo "$(date +%T) Liferay startup complete. Deploying files"

		mv $TMP_DEPLOY_DIR/* /opt/liferay/deploy
	else
		echo "$(date +%T) Nothing to deploy. No files found in $TMP_DEPLOY_DIR"
	fi

}

echo "$(date +%T) Replacing tokens with environment variable values"

export LIFERAY_NODE_NAME=$HOSTNAME

echo "$(date +%T) Processing environment specific configurations"

envsubst < /tmp/liferay/environment/tomcat/conf/server.xml > /opt/liferay/tomcat/conf/server.xml
envsubst < /tmp/liferay/environment/tomcat/webapps/ROOT/WEB-INF/classes/jdbc_ping_config.xml > /opt/liferay/tomcat/webapps/ROOT/WEB-INF/classes/jdbc_ping_config.xml

echo "$(date +%T) Starting background wait and deploy process"

export -f wait_and_deploy

nohup bash -c wait_and_deploy > /opt/liferay/logs/wait_and_deploy.log 2>&1 &

echo "$(date +%T) Executing Liferay's entrypoint"

exec /usr/local/bin/liferay_entrypoint.sh "$@"
