package org.wso2.carbon.test.gateway;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.AbstractSynapseHandler;
import org.apache.synapse.MessageContext;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.rest.RESTConstants;



public class CustomSynapseHandler extends AbstractSynapseHandler {
    private static final Log log = LogFactory.getLog(CustomSynapseHandler.class);

    @Override
    public boolean handleRequestInFlow(MessageContext messageContext) {
        handleLogIN(messageContext);
        return true;
    }

    @Override
    public boolean handleRequestOutFlow(MessageContext messageContext) {
        handleLogOUT(messageContext);
        return true;
    }

    @Override
    public boolean handleResponseInFlow(MessageContext messageContext) {
        handleLogIN(messageContext);
        return true;
    }

    @Override
    public boolean handleResponseOutFlow(MessageContext messageContext) {
        handleLogOUT(messageContext);
        return true;
    }

    public void handleLogIN(MessageContext synCtx) {
        if (!synCtx.isResponse()) {
            log.info("REQUEST PATH : " + synCtx.getMessageID());
        } else {
            log.info("RESPONSE PATH : " + synCtx.getMessageID());
        }
        String proxyName = (String) synCtx.getProperty(SynapseConstants.PROXY_SERVICE);
        if (proxyName != null) {
            log.info(synCtx.getMessageID() + " - " + "dispatched TO proxy name: " + proxyName);
            return;
        }

        String apiName = (String) synCtx.getProperty(RESTConstants.SYNAPSE_REST_API);
        String resourceName = (String) synCtx.getProperty(RESTConstants.SYNAPSE_RESOURCE);
        String context = (String) synCtx.getProperty(RESTConstants.REST_API_CONTEXT);
        String fullRequestPath = (String) synCtx.getProperty(RESTConstants.REST_FULL_REQUEST_PATH);
        String subRequestPath = (String) synCtx.getProperty(RESTConstants.REST_SUB_REQUEST_PATH);
        String httpMethod = (String) synCtx.getProperty("HTTP_METHOD");
        if (apiName != null) {
            log.info(synCtx.getMessageID() + " - " + "dispatched TO api name: " + apiName);
            if (resourceName != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched TO api " + apiName + " resource name: " + resourceName);
            if (context != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched TO api " + apiName + " context: " + context);
            if (fullRequestPath != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched TO api " + apiName + " path: " + fullRequestPath);
            if (subRequestPath != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched TO api " + apiName + " sub path: " + subRequestPath);
            if (httpMethod != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched TO api " + apiName + " on http method: " + httpMethod);
        }

    }

    public void handleLogOUT(MessageContext synCtx) {
        if (!synCtx.isResponse()) {
            log.info("REQUEST PATH : " + synCtx.getMessageID());
        } else {
            log.info("RESPONSE PATH : " + synCtx.getMessageID());
        }
        String proxyName = (String) synCtx.getProperty(SynapseConstants.PROXY_SERVICE);
        if (proxyName != null) {
            log.info(synCtx.getMessageID() + " - " + "dispatched FROM proxy name: " + proxyName);
            return;
        }

        String apiName = (String) synCtx.getProperty(RESTConstants.SYNAPSE_REST_API);
        String resourceName = (String) synCtx.getProperty(RESTConstants.SYNAPSE_RESOURCE);
        String context = (String) synCtx.getProperty(RESTConstants.REST_API_CONTEXT);
        String fullRequestPath = (String) synCtx.getProperty(RESTConstants.REST_FULL_REQUEST_PATH);
        String subRequestPath = (String) synCtx.getProperty(RESTConstants.REST_SUB_REQUEST_PATH);
        String httpMethod = (String) synCtx.getProperty("HTTP_METHOD");
        if (apiName != null) {
            log.info(synCtx.getMessageID() + " - " + "dispatched FROM api name: " + apiName);
            if (resourceName != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched FROM api " + apiName + " resource name: " + resourceName);
            if (context != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched FROM api " + apiName + " context: " + context);
            if (fullRequestPath != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched FROM api " + apiName + " path: " + fullRequestPath);
            if (subRequestPath != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched FROM api " + apiName + " sub path: " + subRequestPath);
            if (httpMethod != null)
                log.info(synCtx.getMessageID() + " - " + "dispatched FROM api " + apiName + " on http method: " + httpMethod);

        }

    }
}