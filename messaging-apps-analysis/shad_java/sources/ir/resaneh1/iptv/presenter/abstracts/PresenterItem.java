package ir.resaneh1.iptv.presenter.abstracts;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes.dex */
public class PresenterItem {
    public transient String presenterId;
    private transient PresenterItemType presenterType = PresenterItemType.nothing;
    public transient boolean presenterIsSelected = false;
    public transient int presenterPosition = 0;

    public String getId() {
        return BuildConfig.FLAVOR;
    }

    public String getIdentitySrting() {
        return BuildConfig.FLAVOR;
    }

    public String getSearchAbleName() {
        return BuildConfig.FLAVOR;
    }

    public String getTitle() {
        return BuildConfig.FLAVOR;
    }

    public PresenterItemType getPresenterType() {
        return this.presenterType;
    }

    public String getPresenterId() {
        return this.presenterId;
    }

    public int getPresenterItemTypeInt() {
        return getPresenterType().ordinal();
    }
}
