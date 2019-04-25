package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.diva.mixedstorage.fedora.DivaCoraToFedoraConverter;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraConverterFactory;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraToCoraConverter;

public class DivaToCoraConverterThrowsExceptionFactorySpy implements DivaFedoraConverterFactory {

	public String type;
	public DivaToCoraFitnesseConverterSpy converterSpy;

	public static DivaFedoraConverterFactory usingFedoraURL(String fedoraURL) {
		return new DivaToCoraConverterThrowsExceptionFactorySpy();
	}

	@Override
	public DivaFedoraToCoraConverter factorToCoraConverter(String arg0) {
		throw new RuntimeException();
	}

	@Override
	public DivaCoraToFedoraConverter factorToFedoraConverter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
