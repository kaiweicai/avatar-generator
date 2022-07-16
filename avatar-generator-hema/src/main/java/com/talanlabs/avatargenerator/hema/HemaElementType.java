package com.talanlabs.avatargenerator.hema;

public enum HemaElementType {

	arms("com.talanlabs.avatargenerator.hema.images.arms"),
	backgrouds("com.talanlabs.avatargenerator.hema.images.backgrouds"),
	clothes("com.talanlabs.avatargenerator.hema.images.clothes"),
	eyes("com.talanlabs.avatargenerator.hema.images.eyes"),
	faces("com.talanlabs.avatargenerator.hema.images.faces"),
	整套("com.talanlabs.avatargenerator.hema.images.整套");

	public final String path;

	HemaElementType(String path) {
		this.path = path;
	}
}
