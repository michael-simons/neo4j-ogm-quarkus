/*
 * Copyright (c) 2022 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
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
package io.quarkiverse.neo4j.ogm.deployment;

import org.neo4j.ogm.session.SessionFactory;

import io.quarkus.builder.item.SimpleBuildItem;
import io.quarkus.runtime.RuntimeValue;

/**
 * Allows access to the Neo4j-OGM {@link SessionFactory} instance from within other extensions.
 *
 * @author Michael J. Simons
 */
public final class Neo4jOgmSessionFactoryBuildItem extends SimpleBuildItem {

    private final RuntimeValue<SessionFactory> value;

    public Neo4jOgmSessionFactoryBuildItem(RuntimeValue<SessionFactory> value) {
        this.value = value;
    }

    public RuntimeValue<SessionFactory> getValue() {
        return value;
    }
}
