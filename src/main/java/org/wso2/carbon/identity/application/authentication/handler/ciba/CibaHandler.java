package org.wso2.carbon.identity.application.authentication.handler.ciba;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import org.wso2.carbon.identity.application.authentication.framework.AbstractApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.AuthenticationFlowHandler;
import org.wso2.carbon.identity.application.authentication.framework.AuthenticatorFlowStatus;
import org.wso2.carbon.identity.application.authentication.framework.LocalApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedIdPData;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Username Password based Authenticator.
 */
public class CibaHandler extends AbstractApplicationAuthenticator implements LocalApplicationAuthenticator {

    private static final long serialVersionUID = -4406878411547612129L;
    // private static final Log log = LogFactory.getLog(AbstractApplicationAuthenticator.class);


    @Override
    public AuthenticatorFlowStatus process(HttpServletRequest request,
                                           HttpServletResponse response, AuthenticationContext context) {
       // AuthenticatedIdPData local = context.getPreviousAuthenticatedIdPs().get(BasicAuthenticatorConstants.LOCAL);
        if (context.isLogoutRequest()) {
            return AuthenticatorFlowStatus.SUCCESS_COMPLETED;
        } else{
            /*// Get username from the request and set to the context.
            String stateparameter = request.getParameter("state");
            try {
                JSONObject json = (JSONObject) new net.minidev.json.parser.JSONParser().parse(stateparameter);
                String username = String.valueOf(json.get("username"));*/

                AuthenticatedUser authenticatedUser = AuthenticatedUser.
                        createLocalAuthenticatedUserFromSubjectIdentifier("admin");

            /*AuthenticatedUser authenticatedUser2 = AuthenticatedUser.
                    createFederateAuthenticatedUserFromSubjectIdentifier("admin");*/
                context.setSubject(authenticatedUser);
                //context.setSubject(authenticatedUser2);
                return AuthenticatorFlowStatus.SUCCESS_COMPLETED;

            }

            //JSONObject json = ( JSONObject) new JSONParser().parse(stateparameter);
            // JSONObject json = (JSONObject) parser.parse(stateparameter);

    }


    @Override
    protected void processAuthenticationResponse(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, AuthenticationContext authenticationContext) {

    }


    public boolean canHandle(HttpServletRequest httpServletRequest) {
        return true;
    }


    public String getContextIdentifier(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameter("sessionDataKey");
    }


    public String getName() {
        return CibaHandlerConstants.HANDLER_NAME;
    }


    public String getFriendlyName() {
        return CibaHandlerConstants.HANDLER_FRIENDLY_NAME;
    }
}