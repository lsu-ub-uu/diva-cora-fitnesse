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

import org.apache.commons.text.StringEscapeUtils;

import se.uu.ub.cora.data.DataGroup;
import se.uu.ub.cora.data.converter.DataToJsonConverter;
import se.uu.ub.cora.data.converter.DataToJsonConverterFactory;
import se.uu.ub.cora.data.converter.DataToJsonConverterProvider;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraConverterFactory;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraToCoraConverter;

public class DivaToCoraFormatFixture {

	private String type;
	private String xml;

	public void setDivaXML(String divaXML) {
		this.xml = removeExtraFormatingAddedByFitnesse(divaXML);
	}

	private String removeExtraFormatingAddedByFitnesse(String divaXML) {
		String tempXml = divaXML.replace("<pre>", "").replace("</pre>", "");
		return StringEscapeUtils.unescapeHtml4(tempXml);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJson() {
		try {
			return tryToConvertXMLToJson();
		} catch (Exception e) {
			return "can not convert xml:" + e;
		}
	}

	private String tryToConvertXMLToJson() {
		DataGroup fromXML = convertXMLToDataGroup();
		return convertDataGroupToJson(fromXML);
	}

	private DataGroup convertXMLToDataGroup() {
		DivaFedoraToCoraConverter converter = createConverterForCurrentType();
		return converter.fromXML(xml);
	}

	private DivaFedoraToCoraConverter createConverterForCurrentType() {
		DivaFedoraConverterFactory converterFactory = DivaFitnesseDependencyProvider
				.getConverterFactory();
		return converterFactory.factorToCoraConverter(type);
	}

	private String convertDataGroupToJson(DataGroup fromXML) {
		DataToJsonConverter dataToJsonConverter = createDataGroupToJsonConverter(fromXML);
		return dataToJsonConverter.toJsonCompactFormat();
	}

	private DataToJsonConverter createDataGroupToJsonConverter(DataGroup dataGroup) {
		DataToJsonConverterFactory dataToJsonConverterFactory = DataToJsonConverterProvider
				.createImplementingFactory();
		return dataToJsonConverterFactory.factorUsingConvertible(dataGroup);
	}

	public String getDivaXML() {
		return xml;
	}
}
