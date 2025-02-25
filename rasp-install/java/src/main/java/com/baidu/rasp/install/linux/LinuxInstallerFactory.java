/*
 * Copyright 2017-2020 Baidu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.rasp.install.linux;

import com.baidu.rasp.install.Installer;
import com.baidu.rasp.install.InstallerFactory;

import static com.baidu.rasp.App.*;

/**
 * Created by OpenRASP on 5/19/17.
 * All rights reserved
 */
public class LinuxInstallerFactory extends InstallerFactory {
    @Override
    protected Installer getInstaller(String serverName, String serverRoot) {
        if (serverName.equals(TOMCAT)) {
            return new TomcatInstaller(serverName, serverRoot);
        }
        if (serverName.equals(JBOSS)) {
            return new Jboss4Installer(serverName, serverRoot);
        }
        if (serverName.equals(RESIN)) {
            return new com.baidu.rasp.install.windows.ResinInstaller(serverName, serverRoot);
        }
        if (serverName.equals(WEBLOGIC)) {
            return new WeblogicInstaller(serverName, serverRoot);
        }
        if (serverName.equals(WILDFLY)) {
            return new JbossEAPInstaller(serverName, serverRoot);
        }
        if (serverName.equals(JBOSSEAP)) {
            return new JbossEAPInstaller(serverName, serverRoot);
        }
        System.out.println("Unexpected server name: " + serverName);
        return null;
    }
}
