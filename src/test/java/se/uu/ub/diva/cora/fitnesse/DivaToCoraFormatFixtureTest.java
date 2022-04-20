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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.diva.cora.fitnesse.spy.DivaToCoraConverterFactorySpy;

public class DivaToCoraFormatFixtureTest {
	private DivaToCoraFormatFixture fixture;
	private DivaToCoraConverterFactorySpy converterFactorySpy;

	@BeforeMethod
	public void beforeMethod() {
		DivaFitnesseDependencyProvider.setConverterFactoryClassName(
				"se.uu.ub.diva.cora.fitnesse.spy.DivaToCoraConverterFactorySpy");
		converterFactorySpy = (DivaToCoraConverterFactorySpy) DivaFitnesseDependencyProvider
				.getConverterFactory();
		fixture = new DivaToCoraFormatFixture();
	}

	@Test
	public void testNoConverterErrorClassname() throws Exception {
		DivaFitnesseDependencyProvider.setConverterFactoryClassName(
				"se.uu.ub.diva.cora.fitnesse.spy.DivaToCoraConverterThrowsExceptionFactorySpy");
		assertEquals(fixture.getJson(), "can not convert xml:java.lang.RuntimeException");
	}

	@Test
	public void testNothingAsTypeAndXML() throws Exception {
		fixture.getJson();
		assertEquals(converterFactorySpy.type, null);
		assertEquals(converterFactorySpy.converterSpy.xml, null);
	}

	@Test
	public void testTypeIsUsedWhenFactoringConverter() throws Exception {
		fixture.setType("someType");
		fixture.getJson();
		assertEquals(converterFactorySpy.type, "someType");
	}

	@Test
	public void testPreIsRemovedXMLIsSentToConverter() throws Exception {
		String divaXML = "<pre>some xml</pre>";
		fixture.setDivaXML(divaXML);
		fixture.getJson();
		assertEquals(converterFactorySpy.converterSpy.xml, "some xml");
	}

	@Test
	public void testRemoveHTMLEscapeBeforeXmlIsSentToConverter() throws Exception {
		String divaXML = "<pre>&lt;place&gt;some xml&lt;/place&gt;</pre>";
		fixture.setDivaXML(divaXML);
		fixture.getJson();
		assertEquals(converterFactorySpy.converterSpy.xml, "<place>some xml</place>");
	}

	@Test
	public void testReturnedTextIsFromConverter() throws Exception {
		String returnedJson = fixture.getJson();
		assertEquals(returnedJson, "{\"name\":\"DataGroupReturnedFromSpy\"}");
	}

	@Test
	public void testGetDivaXML() throws Exception {
		String divaXML = "some Xml";
		fixture.setDivaXML(divaXML);
		assertEquals(fixture.getDivaXML(), "some Xml");
	}
}
