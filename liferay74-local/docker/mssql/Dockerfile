FROM mcr.microsoft.com/mssql/server:2019-CU4-ubuntu-16.04

# Create work directory
RUN mkdir -p /usr/work
WORKDIR /usr/work

# Copy all scripts into working directory
COPY ./resources/ /usr/work

# Grant permissions for the import-data script to be executable
USER root
RUN chmod +x /usr/work/import-data.sh
USER mssql

EXPOSE 1433

CMD /bin/bash ./entrypoint.sh
