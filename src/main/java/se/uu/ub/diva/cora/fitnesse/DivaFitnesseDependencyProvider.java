/*
 * Copyright 2018, 2022 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.diva.cora.fitnesse;

import java.lang.reflect.Method;

import se.uu.ub.cora.classicfedorasynchronizer.FedoraConverterFactory;
import se.uu.ub.cora.xmlutils.transformer.CoraTransformationFactory;
import se.uu.ub.cora.xmlutils.transformer.XsltTransformationFactory;

public class DivaFitnesseDependencyProvider {
	private static FedoraConverterFactory converterFactory;

	public DivaFitnesseDependencyProvider() {
		// needs a public constructor for fitnesse to work
		super();
	}

	public static void setConverterFactoryClassName(String converterFactoryClassName) {
		try {
			Class<?>[] cArg = new Class[1];
			cArg[0] = CoraTransformationFactory.class;
			Method constructor = Class.forName(converterFactoryClassName)
					.getMethod("usingTransformerFactory", cArg);

			XsltTransformationFactory transformationFactory = new XsltTransformationFactory();
			converterFactory = (FedoraConverterFactory) constructor.invoke(null,
					transformationFactory);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static FedoraConverterFactory getConverterFactory() {
		return converterFactory;
	}
}
