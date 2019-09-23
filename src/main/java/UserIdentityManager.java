/*
package org.wso2.carbon.identity.application.authentication.handler.ciba;

import internal.CibaHandlerServiceComponent;
import org.wso2.carbon.identity.core.util.IdentityDatabaseUtil;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;
import org.wso2.carbon.user.api.UserRealm;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserIdentityManager {


    private static final Logger LOGGER = Logger.getLogger(UserIdentityManager.class.getName());
    private UserIdentityManager() {

    }

    private static UserIdentityManager configHandlerInstance = new UserIdentityManager();

    public static UserIdentityManager getInstance() {
        if (configHandlerInstance == null) {

            synchronized (UserIdentityManager.class) {

                if (configHandlerInstance == null) {

                    */
/* instance will be created at request time *//*

                    configHandlerInstance = new UserIdentityManager();
                }
            }
        }
        return configHandlerInstance;
    }


    public String getUserFromGivenClaim(String identity) throws UserStoreException {
        return identity;
     */
/*   int tenantId = CibaHandlerConstants.SUPER_TENANT_ID;
        // TODO: 9/16/19 Check if user exists-even for claim values and if not return null
        UserRealm userRealm = CibaHandlerServiceComponent.getRealmService().getTenantUserRealm(tenantId);
        UserStoreManager userStoreManager= (UserStoreManager) userRealm.getUserStoreManager();

        userStoreManager.getUserList(identity,http://wso2.org/claims/username,"default");*//*



    }
}

*/
