package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class VODObjectAbs extends Abs {
    public String duration;
    public String film_id = BuildConfig.FLAVOR;
    public String fa_name = BuildConfig.FLAVOR;
    public String genres = BuildConfig.FLAVOR;
    public boolean is_series = false;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.vod;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        return this.fa_name;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.film_id;
    }
}
