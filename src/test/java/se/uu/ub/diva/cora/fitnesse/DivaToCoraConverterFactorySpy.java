package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.diva.mixedstorage.fedora.DivaCoraToFedoraConverter;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraConverterFactory;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraToCoraConverter;

public class DivaToCoraConverterFactorySpy implements DivaFedoraConverterFactory {

	public String type;
	public DivaToCoraFitnesseConverterSpy converterSpy;

	// @Override
	// public DivaFedoraToCoraConverter factor(String type) {
	// }

	@Override
	public DivaFedoraToCoraConverter factorToCoraConverter(String arg0) {
		this.type = type;
		converterSpy = new DivaToCoraFitnesseConverterSpy();
		return converterSpy;
	}

	@Override
	public DivaCoraToFedoraConverter factorToFedoraConverter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
