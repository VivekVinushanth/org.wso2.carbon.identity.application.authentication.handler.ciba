package org.wso2.carbon.identity.application.authentication.handler.ciba;

/**
 * Constants used by the org.wso2.carbon.identity.application.authentication.handler.ciba.CibaHandler.
 */
public abstract class CibaHandlerConstants {

    public static final String HANDLER_NAME = "CibaExecutor";
    public static final String HANDLER_FRIENDLY_NAME = "Ciba";
    public static final String USER_NAME = "username";
    public static final String FAILED_USERNAME = "&failedUsername=";
    public static final String ERROR_CODE = "&errorCode=";
    public static final String AUTHENTICATORS = "&authenticators=";
    public static final String LOCAL = "LOCAL";
    public static final String UTF_8 = "UTF-8";

    private CibaHandlerConstants() {
    }
}

