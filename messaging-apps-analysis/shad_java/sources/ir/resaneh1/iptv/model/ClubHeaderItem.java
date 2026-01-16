package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ClubHeaderItem extends PresenterItem {
    public String rank;
    public String score;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.clubHeader;
    }

    public ClubHeaderItem(String str, String str2) {
        this.rank = BuildConfig.FLAVOR;
        this.score = BuildConfig.FLAVOR;
        this.rank = str;
        this.score = str2;
    }
}
