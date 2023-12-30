FROM liferay/dxp:7.2.10-sp4

ARG LABEL_BUILD_DATE
ARG LABEL_NAME
ARG LABEL_VCS_REF
ARG LABEL_VCS_URL
ARG LABEL_VERSION

COPY --chown=liferay:liferay resources/ .

RUN if [ -d "/opt/liferay/patching-tool/patches" ] && [ -n "$(ls -A /opt/liferay/patching-tool/patches)" ]; then \
    /opt/liferay/patching-tool/patching-tool.sh info && \
    ls -al patching-tool/patches/ && \
    cat /opt/liferay/patching-tool/logs/patching-tool.log && \
    /opt/liferay/patching-tool/patching-tool.sh setup && \
    /opt/liferay/patching-tool/patching-tool.sh info && \
    /opt/liferay/patching-tool/patching-tool.sh install && \
    rm -rf /opt/liferay/patching-tool/patches/*; \
    fi && \
    rm -rf /opt/liferay/osgi/state/* && \
    rm -rf /opt/liferay/work/* && \
    rm -rf /opt/liferay/tomcat/temp/* && \
    rm -rf /opt/liferay/tomcat/work/*

COPY --chown=liferay:liferay build/ccew-liferay .

LABEL org.label-schema.build-date="${LABEL_BUILD_DATE}"
LABEL org.label-schema.name="${LABEL_NAME}"
LABEL org.label-schema.schema-version="1.0"
LABEL org.label-schema.vcs-ref="${LABEL_VCS_REF}"
LABEL org.label-schema.vcs-url="${LABEL_VCS_URL}"
LABEL org.label-schema.vendor="CCEW"
LABEL org.label-schema.version="${LABEL_VERSION}"