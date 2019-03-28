/*
 * Copyright 2018 Uppsala University Library
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

import java.lang.reflect.Constructor;

import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraConverterFactory;

public class DivaFitnesseDependencyProvider {
	private static DivaFedoraConverterFactory converterFactory;

	public DivaFitnesseDependencyProvider() {
		// needs a public constructor for fitnesse to work
		super();
	}

	public static void setConverterFactoryClassName(String converterFactoryClassName) {
		Constructor<?> constructor;
		try {
			constructor = Class.forName(converterFactoryClassName).getConstructor();
			converterFactory = (DivaFedoraConverterFactory) constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static DivaFedoraConverterFactory getConverterFactory() {
		return converterFactory;
	}
}
