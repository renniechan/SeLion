/*-------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2014 eBay Software Foundation                                                                        |
|                                                                                                                     |
|  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance     |
|  with the License.                                                                                                  |
|                                                                                                                     |
|  You may obtain a copy of the License at                                                                            |
|                                                                                                                     |
|       http://www.apache.org/licenses/LICENSE-2.0                                                                    |
|                                                                                                                     |
|  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed   |
|  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for  |
|  the specific language governing permissions and limitations under the License.                                     |
\*-------------------------------------------------------------------------------------------------------------------*/

package com.paypal.selion.plugins;

public enum TestPlatform {

    IOS("ios", "IOSPage", "ClassIOSDef.vm"), WEB("web", "BasicPageImpl", "Class.vm");

    private String platformName;
    private String baseClassName;
    private String defFileName;

    private TestPlatform(String platformName, String baseClassName, String defFileName) {
        this.platformName = platformName;
        this.baseClassName = baseClassName;
        this.defFileName = defFileName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getBaseClassName() {
        return baseClassName;
    }

    public String getVelocityTemplateToUse() {
        return defFileName;
    }

    /**
     * Utility to map the platform from Page Yaml to {@link TestPlatform}
     * 
     * @param platformFromFile
     *            - The value for platform read from the Yaml file
     * @return - {@link TestPlatform} if a valid match is found otherwise null
     */
    public static TestPlatform identifyPlatform(String platformFromFile) {
        for (TestPlatform platform : TestPlatform.values()) {
            if (platform.getPlatformName().equals(platformFromFile)) {
                return platform;
            }
        }
        return null;
    }

}
