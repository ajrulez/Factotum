/*
 * Copyright 2015 C. A. Fitzgerald
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.riotopsys.factotum.api;

import net.riotopsys.factotum.api.interfaces.ICancelRequest;

/**
 * Created by afitzgerald on 8/29/14.
 */
public class SimpleCancelRequest implements ICancelRequest {


    private final Object template;

    public SimpleCancelRequest(Object object) {
        template = object;
    }

    @Override
    public boolean match(Object object) {
        return template.equals(object);
    }
}
