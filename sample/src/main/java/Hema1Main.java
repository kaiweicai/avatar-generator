import com.talanlabs.avatargenerator.cache.ICache;
import com.talanlabs.avatargenerator.cat.CatAvatar;
import com.talanlabs.avatargenerator.hema.HemaAvatar;

import java.nio.file.Paths;

public class Hema1Main {

	public static void main(String[] args) throws Exception {
		AvatarShowing.showAvatar(HemaAvatar.newAvatarBuilder().cache(ICache.defaultCache(Paths.get("temp/avatar/10")))
				.build());
	}
}
