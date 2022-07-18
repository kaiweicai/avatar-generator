import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.GitHubAvatar;
import com.talanlabs.avatargenerator.IdenticonAvatar;
import com.talanlabs.avatargenerator.SquareAvatar;
import com.talanlabs.avatargenerator.TriangleAvatar;
import com.talanlabs.avatargenerator.cat.CatAvatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;
import com.talanlabs.avatargenerator.hema.HemaAvatar;
import com.talanlabs.avatargenerator.layers.backgrounds.RandomColorPaintBackgroundLayer;
import com.talanlabs.avatargenerator.layers.masks.RoundRectMaskLayer;
import com.talanlabs.avatargenerator.layers.others.ShadowLayer;
import com.talanlabs.avatargenerator.smiley.SmileyAvatar;
import com.talanlabs.avatargenerator.utils.AvatarUtils;
import sun.reflect.generics.tree.Tree;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MultiMain {
	static final int elementsMenuCount = 5;
	public static void main(String[] args) {
		int size = 128;
		Avatar[] avatars = new Avatar[]{
//				IdenticonAvatar.newAvatarBuilder().size(size, size).build(),
//				GitHubAvatar.newAvatarBuilder().size(size, size).build(),
//				GitHubAvatar.newAvatarBuilder(396, 5).size(size, size).build(),
//
//				CatAvatar.newAvatarBuilder().size(size, size).build(),
//				CatAvatar.newAvatarBuilder().size(size, size)
//						.layers(new ShadowLayer(), new RandomColorPaintBackgroundLayer(), new RoundRectMaskLayer())
//						.padding(4).margin(4).build(),
//				SmileyAvatar.newAccessoriesAvatarBuilder().size(size, size).build(),
//				SmileyAvatar.newEyeMouthAvatarBuilder().size(size, size).build(),
//				SmileyAvatar.newGhostAvatarBuilder().size(size, size).build(),
//				SmileyAvatar.newDefaultAvatarBuilder().size(size, size).build(),
//				EightBitAvatar.newMaleAvatarBuilder().size(size, size).build(),
//				EightBitAvatar.newFemaleAvatarBuilder().size(size, size).build(),
				HemaAvatar.newAvatarBuilder().size(size, size).build(),
				HemaAvatar.newAvatarBuilder().size(size, size).build(),
//				TriangleAvatar.newAvatarBuilder().size(size, size).build(),
//				SquareAvatar.newAvatarBuilder().size(size, size).build()
		};

		int w = 6;
		int h = 6;
		//部件目录的个数。

		BufferedImage dest = new BufferedImage(size * w, size * h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = dest.createGraphics();
		AvatarUtils.activeAntialiasing(g2);
		Map<Long,Long> codeMap = new TreeMap();
		Random random = new Random(10);
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				long code = Math.abs(random.nextLong());
				long codeDigit =code%(new BigDecimal("10").pow(3*elementsMenuCount).longValue());
				if (codeMap.containsKey(codeDigit)){
					//重复了,需要重新生成
					System.out.println("重复了,需要重新生成,x is:"+x);
					x--;
					continue;
				}else{
					codeMap.put(codeDigit,code);
				}
//				int[] selector = isRepeat(code, elementsMenuCount);
				Avatar avatar = avatars[(x + y * w) % avatars.length];
				g2.drawImage(avatar.create(code), x * size, y * size, size, size, null);
				System.out.print(code + ", ");
				//g2.setColor(Color.RED);
				//g2.drawRect(x * 128, y * 128, 128, 128);

			}
			System.out.println("");
		}

		g2.dispose();

		AvatarShowing.showImage(dest);
	}

	private static boolean isRepeat(Long code,int elementsMenuCount,Map<int[],Long> storeMap){
		int[] selector = new int[elementsMenuCount];
		for(int i=0;i<elementsMenuCount;i++){
			selector[i] = (int)(code%1000L);
		}
		if (storeMap.containsKey(selector)){
			return true;
		}
		for (int[] key:storeMap.keySet()) {
			int j=0;
			for(int i = 0 ;i<selector.length;i++){
				if(selector[i]==key[i]){
					j++;
				}
			}
			if(j>=elementsMenuCount-1){
				return true;
			}
		}
		storeMap.put(selector,code);
		return false;
	}
}
