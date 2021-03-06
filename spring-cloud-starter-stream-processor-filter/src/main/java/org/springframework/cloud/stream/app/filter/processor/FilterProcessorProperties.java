/*
 * Copyright 2015-2016 the original author or authors.
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

package org.springframework.cloud.stream.app.filter.processor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Configuration properties for the Filter Processor app.
 *
 * @author Eric Bottard
 * @author Gary Russell
 */
@ConfigurationProperties("filter")
@Validated
public class FilterProcessorProperties {

	private static final Expression DEFAULT_EXPRESSION = new SpelExpressionParser().parseExpression("true");

	/**
	 * A SpEL expression to be evaluated against each message, to decide whether or not to accept it.
	 */
	private Expression expression = DEFAULT_EXPRESSION;

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@NotNull
	public Expression getExpression() {
		return expression;
	}

}
