package etalons;

import java.util.HashMap;
import java.util.Map;

public class SocialNetworks {
    public Map initCollection() {
        Map<String, String> set = new HashMap<String, String>();
        set.put("footer__social_logo footer__social_fb", "https://www.facebook.com/bankdruzey");
        set.put("footer__social_logo footer__social_tw", "http://twitter.com/sberbank/");
        set.put("footer__social_logo footer__social_yt", "http://www.youtube.com/sberbank");
        set.put("footer__social_logo footer__social_ins", "http://instagram.com/sberbank");
        set.put("footer__social_logo footer__social_vk", "http://vk.com/sberbank");
        set.put("footer__social_logo footer__social_ok", "https://ok.ru/sberbank");
        return set;
    }
}