package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.diva.mixedstorage.fedora.DivaCoraToFedoraConverter;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraConverterFactory;
import se.uu.ub.cora.diva.mixedstorage.fedora.DivaFedoraToCoraConverter;
import se.uu.ub.cora.xmlutils.transformer.CoraTransformationFactory;

public class DivaToCoraConverterFactorySpy implements DivaFedoraConverterFactory {

	public String type;
	public DivaToCoraFitnesseConverterSpy converterSpy;

	public static DivaFedoraConverterFactory usingFedoraURLAndTransformerFactory(String fedoraURL,
			CoraTransformationFactory transformationFactory) {
		return new DivaToCoraConverterFactorySpy();
	}

	@Override
	public DivaFedoraToCoraConverter factorToCoraConverter(String type) {
		this.type = type;
		converterSpy = new DivaToCoraFitnesseConverterSpy();
		return converterSpy;
	}

	@Override
	public DivaCoraToFedoraConverter factorToFedoraConverter(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
