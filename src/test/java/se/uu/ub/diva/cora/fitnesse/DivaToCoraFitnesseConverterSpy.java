package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.data.DataGroup;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraToCoraConverter;

public class DivaToCoraFitnesseConverterSpy implements DivaFedoraToCoraConverter {

	public String xml;

	@Override
	public DataGroup fromXML(String xml) {
		this.xml = xml;
		return new DataGroupSpy("DataGroupReturnedFromSpy");
	}

}
