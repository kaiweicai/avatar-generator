package com.talanlabs.avatargenerator.hema;

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

		elementRegistry.putGroup(ElementInfo.of(HemaElementType.backgroud.name()),ElementInfo.of(HemaElementType.arm.name()),
		                         ElementInfo.of(HemaElementType.eye.name()),
								ElementInfo.of(HemaElementType.face.name()),
		                         ElementInfo.of(HemaElementType.clothe.name()));
		elementRegistry.putGroup(ElementInfo.of(HemaElementType.backgroud.name()),ElementInfo.of(HemaElementType.arm.name()),
		                         ElementInfo.of(HemaElementType.eye.name()),
								ElementInfo.of(HemaElementType.face.name()),
		                         ElementInfo.of(HemaElementType.clothe.name()));
//		elementRegistry.putGroup(ElementInfo.of(HemaElementType.arm.name()), ElementInfo.of(HemaElementType.backgroud.name()),
//		                         ElementInfo.of(HemaElementType.eye.name()),
//								ElementInfo.of(HemaElementType.face.name()),
//		                         ElementInfo.of(HemaElementType.clothe.name()));
//		elementRegistry.putGroup(ElementInfo.of(HemaElementType.arm.name()), ElementInfo.of(HemaElementType.backgroud.name()),
//		                         ElementInfo.of(HemaElementType.eye.name()),
//								ElementInfo.of(HemaElementType.face.name()),
//		                         ElementInfo.of(HemaElementType.clothe.name()));


		return elementRegistry;
	}

}
