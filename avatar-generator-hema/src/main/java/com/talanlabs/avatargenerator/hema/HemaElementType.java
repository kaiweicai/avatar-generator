package com.talanlabs.avatargenerator.hema;

public enum HemaElementType {

	arm("com.talanlabs.avatargenerator.hema.images.arms"),
	backgroud("com.talanlabs.avatargenerator.hema.images.backgrouds"),
	clothe("com.talanlabs.avatargenerator.hema.images.clothes"),
	eye("com.talanlabs.avatargenerator.hema.images.eyes"),
	face("com.talanlabs.avatargenerator.hema.images.faces");
//	整套("com.talanlabs.avatargenerator.hema.images.整套");

	public final String path;

	HemaElementType(String path) {
		this.path = path;
	}
}
