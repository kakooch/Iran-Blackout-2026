package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class Abs extends PresenterItem {
    public String count_comments = "0";
    public String image_url = BuildConfig.FLAVOR;
    public boolean isBookmarked = false;
    public String share_link;
    public String stars;

    public float getStars() {
        try {
            return Float.valueOf(this.stars).floatValue();
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
