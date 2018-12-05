package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.diva.tocorastorage.fedora.DivaToCoraConverter;
import se.uu.ub.cora.diva.tocorastorage.fedora.DivaToCoraConverterFactory;

public class DivaToCoraConverterFactorySpy implements DivaToCoraConverterFactory {

	public String type;
	public DivaToCoraFitnesseConverterSpy converterSpy;

	@Override
	public DivaToCoraConverter factor(String type) {
		this.type = type;
		converterSpy = new DivaToCoraFitnesseConverterSpy();
		return converterSpy;
	}

}
