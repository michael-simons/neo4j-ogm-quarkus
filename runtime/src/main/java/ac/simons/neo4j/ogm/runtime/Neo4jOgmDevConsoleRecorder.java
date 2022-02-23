/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ac.simons.neo4j.ogm.runtime;

import io.quarkus.runtime.annotations.Recorder;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * @author Michael J. Simons
 */
@Recorder
public class Neo4jOgmDevConsoleRecorder {

	/**
	 * Creates a supplier for a list of classes
	 *
	 * @param annotatedClasses The list of classes to be supplied
	 * @return A recordable supplier
	 */
	public Supplier<Collection<Class<?>>> recordAnnotatedClasses(
		Collection<Class<?>> annotatedClasses) {

		var supplier = new AnnotatedClassesSupplier();
		supplier.setValue(annotatedClasses);
		return supplier;
	}
}
