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

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import se.uu.ub.cora.diva.tocorastorage.DivaToCoraConverterFactory;
import se.uu.ub.cora.diva.tocorastorage.DivaToCoraConverterFactoryImp;
import se.uu.ub.diva.cora.fitnesse.DivaFitnesseDependencyProvider;

public class DivaFitnesseDependencyProviderTest {
	@Test
	public void testConstructor() {
		DivaFitnesseDependencyProvider dependencyProvider = new DivaFitnesseDependencyProvider();
		assertTrue(dependencyProvider instanceof DivaFitnesseDependencyProvider);
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testFactorConverterNonExistingClassName() {
		DivaFitnesseDependencyProvider.setConverterFactoryClassName(
				"se.uu.ub.cora.diva.tocorastorage.DoesNotExistFactoryImp");
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testFactorConverterClassNameNotSet() {
		DivaFitnesseDependencyProvider.setConverterFactoryClassName(null);
	}

	@Test
	public void testFactorHttpHandler() {
		DivaFitnesseDependencyProvider.setConverterFactoryClassName(
				"se.uu.ub.cora.diva.tocorastorage.DivaToCoraConverterFactoryImp");
		DivaToCoraConverterFactory converterFactory = DivaFitnesseDependencyProvider
				.getConverterFactory();
		assertTrue(converterFactory instanceof DivaToCoraConverterFactoryImp);
	}

}
