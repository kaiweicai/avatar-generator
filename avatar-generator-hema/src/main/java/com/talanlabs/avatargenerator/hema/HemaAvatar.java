package com.talanlabs.avatargenerator.cat;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.element.ElementInfo;
import com.talanlabs.avatargenerator.element.ElementRegistry;
import com.talanlabs.avatargenerator.element.URLElementRegistry;

public class HemaAvatar {

	/**
	 * New avatar builder with hema
	 */
	public static Avatar.AvatarBuilder newAvatarBuilder() {
		return Avatar.newBuilder().elementRegistry(newElementRegistry());
	}

	/**
	 * New hema element resgistry
	 */
	public static ElementRegistry newElementRegistry() {
		URLElementRegistry elementRegistry = new URLElementRegistry();
		for (HemaElementType hemaElementType : HemaElementType.values()) {
			elementRegistry.putElement(hemaElementType.name(), URLElementRegistry
					.lsPngURLs(HemaAvatar.class.getClassLoader(), hemaElementType.path));
		}

		elementRegistry.putGroup(ElementInfo.of(CatElementType.body.name()), ElementInfo.of(CatElementType.fur.name()),
		                         ElementInfo.of(CatElementType.eyes.name()),
		                         ElementInfo.of(CatElementType.mouth.name()));
		elementRegistry.putGroup(ElementInfo.of(CatElementType.body.name()), ElementInfo.of(CatElementType.fur.name()),
		                         ElementInfo.of(CatElementType.eyes.name()),
		                         ElementInfo.of(CatElementType.mouth.name()),
		                         ElementInfo.of(CatElementType.accessorie.name()));
		elementRegistry.putGroup(ElementInfo.of(CatElementType.body.name()), ElementInfo.of(CatElementType.fur.name()),
		                         ElementInfo.of(CatElementType.eyes.name()),
		                         ElementInfo.of(CatElementType.mouth.name()), ElementInfo.of(CatElementType.zz.name()));

		return elementRegistry;
	}

}
