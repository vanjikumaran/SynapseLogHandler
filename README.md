# SynapseLogHandler
Synapse Log handler is providing comprehensive details of each of entry and exist point of the mediation engine.
Which allows to calculate the latency caused by the mediation engine in the given request/responseflow.

![alt tag](https://docs.wso2.com/download/attachments/50504107/ESBwithRequestResponseFlow.png?version=1&modificationDate=1456204597000&api=v2)


# Engaging the SynapseLogHandler
To engage the deployed Synapse handler, you need to add the following configuration to the <ESB_HOME>/repository/conf/synapse-handlers.xml file.
<handlers>
    <handler name="CustomSynapseHandler" class="org.wso2.carbon.test.gateway.CustomSynapseHandler"/>
</handlers>