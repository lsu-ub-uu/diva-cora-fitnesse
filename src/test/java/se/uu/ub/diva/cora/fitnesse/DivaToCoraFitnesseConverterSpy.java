package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.diva.tocorastorage.DivaToCoraConverter;
import se.uu.ub.cora.bookkeeper.data.DataGroup;

public class DivaToCoraFitnesseConverterSpy implements DivaToCoraConverter {

	public String xml;

	@Override
	public DataGroup fromXML(String xml) {
		this.xml = xml;
		return DataGroup.withNameInData("DataGroupReturnedFromSpy");
	}

}
