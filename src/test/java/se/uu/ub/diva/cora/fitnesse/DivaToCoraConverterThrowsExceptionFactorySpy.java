package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.diva.tocorastorage.fedora.DivaToCoraConverter;
import se.uu.ub.cora.diva.tocorastorage.fedora.DivaToCoraConverterFactory;

public class DivaToCoraConverterThrowsExceptionFactorySpy implements DivaToCoraConverterFactory {

	public String type;
	public DivaToCoraFitnesseConverterSpy converterSpy;

	@Override
	public DivaToCoraConverter factor(String type) {
		throw new RuntimeException();
	}

}
