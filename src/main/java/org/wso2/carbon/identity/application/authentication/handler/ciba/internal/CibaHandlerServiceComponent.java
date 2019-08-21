package org.wso2.carbon.identity.application.authentication.handler.ciba.internal; /**
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * <p>
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.handler.ciba.CibaHandler;
import org.wso2.carbon.user.core.service.RealmService;

@Component(
        name = "identity.application.handler.ciba.component",
        immediate = true
)
public class CibaHandlerServiceComponent {

    private static final Log log = LogFactory.getLog(CibaHandlerServiceComponent.class);

    private static RealmService realmService;

    public static RealmService getRealmService() {

        return realmService;
    }

    @Reference(
            name = "realm.service",
            service = RealmService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetRealmService"
    )
    protected void setRealmService(RealmService realmService) {

        log.debug("Setting the Realm Service");
        CibaHandlerServiceComponent.realmService = realmService;
    }

    @Activate
    protected void activate(ComponentContext ctxt) {

        try {
            CibaHandler cibaHandler = new CibaHandler();
            ctxt.getBundleContext().registerService(ApplicationAuthenticator.class.getName(), cibaHandler, null);
            if (log.isDebugEnabled()) {
                log.info("IdentifierHandler bundle is activated");
            }
        } catch (Throwable e) {
            log.error("IdentifierHandler Authenticator bundle activation Failed", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext ctxt) {

        if (log.isDebugEnabled()) {
            log.info("cibaHandler bundle is deactivated");
        }
    }

    protected void unsetRealmService(RealmService realmService) {

        log.debug("UnSetting the Realm Service");
        CibaHandlerServiceComponent.realmService = null;
    }

}