/*
 * Copyright 2012-2022 the original author or authors.
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

package org.springframework.boot.autoconfigureprocessor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * Alternative to Spring Boot's {@code @AutoConfiguration} for testing (removes the need
 * for a dependency on the real annotation).
 *
 * @author Moritz Halbritter
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@TestAutoConfigureBefore
@TestAutoConfigureAfter
public @interface TestAutoConfiguration {

	@AliasFor(annotation = TestAutoConfigureBefore.class, attribute = "value")
	Class<?>[] before() default {};

	@AliasFor(annotation = TestAutoConfigureBefore.class, attribute = "name")
	String[] beforeName() default {};

	@AliasFor(annotation = TestAutoConfigureAfter.class, attribute = "value")
	Class<?>[] after() default {};

	@AliasFor(annotation = TestAutoConfigureAfter.class, attribute = "name")
	String[] afterName() default {};

}